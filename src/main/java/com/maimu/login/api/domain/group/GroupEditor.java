package com.maimu.login.api.domain.group;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GroupEditor {

    private final String groupName;
    private final String groupColor;

    @Builder
    public GroupEditor(String groupName, String groupColor){
        this.groupName = groupName;
        this.groupColor = groupColor;
    }
}
