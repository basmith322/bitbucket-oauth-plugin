import com.google.gson.Gson;
import org.jenkinsci.plugins.api.BitBucketTeamsResponse;
import org.jenkinsci.plugins.api.BitBucketWorkspace;
import org.jenkinsci.plugins.api.BitbucketApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scribe.model.Token;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BitbucketApiServiceTest {

    @InjectMocks
    BitbucketApiService bitbucketApiService = new BitbucketApiService("apiKey", "apiSecret", "callback");

    @Test
    void testGsonMapsToObjectCorrectly() {
        Gson gson = new Gson();
        BitBucketTeamsResponse expectedResponse = new BitBucketTeamsResponse();
        List<BitBucketWorkspace> bitBucketWorkspaces = new ArrayList<>();
        BitBucketWorkspace bitBucketWorkspace = new BitBucketWorkspace();
        bitBucketWorkspace.setUsername("test");
        bitBucketWorkspace.setDisplayName("Test User");
        bitBucketWorkspace.setType("workspace");
        bitBucketWorkspaces.add(bitBucketWorkspace);
        expectedResponse.setWorkspaceList(bitBucketWorkspaces);

        // When
        BitBucketTeamsResponse gsonMappedResponse = gson.fromJson(jsonExample(), BitBucketTeamsResponse.class);

        //Then
        assertEquals(
            expectedResponse.getWorkSpaceList().get(0).getDisplayName(),
            gsonMappedResponse.getWorkSpaceList().get(0).getDisplayName()
        );
        assertEquals(
            expectedResponse.getWorkSpaceList().get(0).getUsername(),
            gsonMappedResponse.getWorkSpaceList().get(0).getUsername()
        );
        assertEquals(
            expectedResponse.getWorkSpaceList().get(0).getType(),
            gsonMappedResponse.getWorkSpaceList().get(0).getType()
        );

    }

    @Test
    void testCreateAuthorizationCodeURLReturnsOK() {
        // Given
        Token token = new Token("Token", "Secret");
        String expectedResponse = "https://bitbucket.org/site/oauth2/authorize?client_id=apiKey&response_type=code";

        //When
        String response = bitbucketApiService.createAuthorizationCodeURL(token);

        // Then
        assertEquals(expectedResponse, response);
    }

    private String jsonExample() {
        return "{\n" + "  \"pagelen\": 10,\n" + "  \"values\": [\n" + "    {\n" + "      \"uuid\": \"{73abec4e-35ea-4117-b081-6deb98895904}\",\n" + "      \"links\": {\n" + "        \"owners\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/workspaces/test/members?q=permission%3D%22owner%22\"\n" + "        },\n" + "        \"hooks\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/workspaces/test/hooks\"\n" + "        },\n" + "        \"self\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/workspaces/test\"\n" + "        },\n" + "        \"repositories\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/repositories/test\"\n" + "        },\n" + "        \"html\": {\n" + "          \"href\": \"https://bitbucket.org/test/\"\n" + "        },\n" + "        \"avatar\": {\n" + "          \"href\": \"https://bitbucket.org/workspaces/test/avatar/?ts=1626166578\"\n" + "        },\n" + "        \"members\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/workspaces/test/members\"\n" + "        },\n" + "        \"projects\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/workspaces/test/projects\"\n" + "        },\n" + "        \"snippets\": {\n" + "          \"href\": \"https://api.bitbucket.org/2.0/snippets/test\"\n" + "        }\n" + "      },\n" + "      \"created_on\": \"2021-07-13T08:56:18.945377+00:00\",\n" + "      \"type\": \"workspace\",\n" + "      \"slug\": \"test\",\n" + "      \"is_private\": false,\n" + "      \"name\": \"Test User\"\n" + "    }\n" + "  ],\n" + "  \"page\": 1,\n" + "  \"size\": 1\n" + "}";
    }

}