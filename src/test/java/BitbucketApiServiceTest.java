import com.google.gson.Gson;
import org.jenkinsci.plugins.api.BitBucketTeamsResponse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BitbucketApiServiceTest {

    @Test
    public void testReturnsCorrectly() {
        String response = "{\"pagelen\": 10, \"values\": [{\"uuid\": \"{73abec4e-35ea-4117-b081-6deb98895904}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/bsEnjoi\"}, \"html\": {\"href\": \"https://bitbucket.org/bsEnjoi/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/bsEnjoi/avatar/?ts=1626166578\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/bsEnjoi\"}}, \"created_on\": \"2021-07-13T08:56:18.945377+00:00\", \"type\": \"workspace\", \"slug\": \"bsEnjoi\", \"is_private\": false, \"name\": \"Benjamin Smith\"}, {\"uuid\": \"{1053949a-c64f-4e72-ad62-4977d5092c0a}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/uleska\"}, \"html\": {\"href\": \"https://bitbucket.org/uleska/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/uleska/avatar/?ts=1632922364\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/uleska\"}}, \"created_on\": \"2018-12-02T09:26:50.705916+00:00\", \"type\": \"workspace\", \"slug\": \"uleska\", \"is_private\": true, \"name\": \"Uleska\"}], \"page\": 1, \"size\": 2}\n";

        Gson gson = new Gson();

        BitBucketTeamsResponse bitBucketTeamsResponse = gson.fromJson(response, BitBucketTeamsResponse.class);

        assertNotNull(bitBucketTeamsResponse);
    }

    @Test
    public void testUsernameReturnsCorrectly() {
        String response = "{\"pagelen\": 10, \"values\": [{\"uuid\": \"{73abec4e-35ea-4117-b081-6deb98895904}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/bsEnjoi\"}, \"html\": {\"href\": \"https://bitbucket.org/bsEnjoi/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/bsEnjoi/avatar/?ts=1626166578\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/bsEnjoi\"}}, \"created_on\": \"2021-07-13T08:56:18.945377+00:00\", \"type\": \"workspace\", \"slug\": \"bsEnjoi\", \"is_private\": false, \"name\": \"Benjamin Smith\"}, {\"uuid\": \"{1053949a-c64f-4e72-ad62-4977d5092c0a}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/uleska\"}, \"html\": {\"href\": \"https://bitbucket.org/uleska/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/uleska/avatar/?ts=1632922364\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/uleska\"}}, \"created_on\": \"2018-12-02T09:26:50.705916+00:00\", \"type\": \"workspace\", \"slug\": \"uleska\", \"is_private\": true, \"name\": \"Uleska\"}], \"page\": 1, \"size\": 2}\n";

        Gson gson = new Gson();

        BitBucketTeamsResponse bitBucketTeamsResponse = gson.fromJson(response, BitBucketTeamsResponse.class);

        assertNotNull(bitBucketTeamsResponse.getTeamsList().get(0).getUsername());
    }

    @Test
    public void testDisplayNameReturnsCorrectly() {
        String response = "{\"pagelen\": 10, \"values\": [{\"uuid\": \"{73abec4e-35ea-4117-b081-6deb98895904}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/bsEnjoi\"}, \"html\": {\"href\": \"https://bitbucket.org/bsEnjoi/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/bsEnjoi/avatar/?ts=1626166578\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/bsEnjoi/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/bsEnjoi\"}}, \"created_on\": \"2021-07-13T08:56:18.945377+00:00\", \"type\": \"workspace\", \"slug\": \"bsEnjoi\", \"is_private\": false, \"name\": \"Benjamin Smith\"}, {\"uuid\": \"{1053949a-c64f-4e72-ad62-4977d5092c0a}\", \"links\": {\"owners\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members?q=permission%3D%22owner%22\"}, \"hooks\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/hooks\"}, \"self\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska\"}, \"repositories\": {\"href\": \"https://api.bitbucket.org/2.0/repositories/uleska\"}, \"html\": {\"href\": \"https://bitbucket.org/uleska/\"}, \"avatar\": {\"href\": \"https://bitbucket.org/workspaces/uleska/avatar/?ts=1632922364\"}, \"members\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/members\"}, \"projects\": {\"href\": \"https://api.bitbucket.org/2.0/workspaces/uleska/projects\"}, \"snippets\": {\"href\": \"https://api.bitbucket.org/2.0/snippets/uleska\"}}, \"created_on\": \"2018-12-02T09:26:50.705916+00:00\", \"type\": \"workspace\", \"slug\": \"uleska\", \"is_private\": true, \"name\": \"Uleska\"}], \"page\": 1, \"size\": 2}\n";

        Gson gson = new Gson();

        BitBucketTeamsResponse bitBucketTeamsResponse = gson.fromJson(response, BitBucketTeamsResponse.class);

        assertNotNull(bitBucketTeamsResponse.getTeamsList().get(0).getDisplayName());
    }

}