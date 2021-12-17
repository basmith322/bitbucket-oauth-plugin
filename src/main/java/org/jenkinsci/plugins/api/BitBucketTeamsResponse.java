package org.jenkinsci.plugins.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents Bitbuckets team api response
 * <p>
 * https://developer.atlassian.com/bitbucket/api/2/reference/resource/teams
 */
public class BitBucketTeamsResponse {

    @SerializedName("next")
    private String next;

    @SerializedName("values")
    private List<BitBucketWorkspace> workspaceList;

    public List<BitBucketWorkspace> getWorkSpaceList() {
        return workspaceList;
    }

    public void setWorkspaceList(List<BitBucketWorkspace> teamsList) {
        this.workspaceList = teamsList;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
