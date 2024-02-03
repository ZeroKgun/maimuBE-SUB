package com.maimu.login.api.dto.response.group;

import com.maimu.login.api.domain.group.Group;
import lombok.Builder;
import lombok.Getter;
@Getter
public class GroupResponse {

    private final Long id;
    private final String groupName;
    private final String groupColor;

    public GroupResponse(Group group){
        this.id = group.getId();
        this.groupName = group.getGroupName();
        this.groupColor = group.getGroupColor();
    }

    @Builder
    public GroupResponse(Long id, String groupName, String groupColor){
        this.id = id;
        this.groupName = groupName.substring(0, Math.min(groupName.length(), 20));
        this.groupColor = groupColor;
    }
}
