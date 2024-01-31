package com.maimu.login.api.controller;


import com.maimu.login.api.dto.request.group.GroupCreate;
import com.maimu.login.api.dto.request.group.GroupEdit;
import com.maimu.login.api.dto.response.group.GroupResponse;
import com.maimu.login.api.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/group")
    public void group(@RequestBody @Valid GroupCreate groupCreate){
        groupService.createGroup(groupCreate);
    }

    @GetMapping(value = "/group/{groupId}", produces = "application/json")
    public GroupResponse get(@PathVariable Long groupId){
        return groupService.get(groupId);
    }

    @PatchMapping("/group/{groupId}")
    public void edit(@PathVariable Long groupId, @RequestBody @Valid GroupEdit groupEdit){
        groupService.edit(groupId, groupEdit);
    }

    @DeleteMapping("/group/{groupId}")
    public void delete(@PathVariable Long groupId){
        groupService.delete(groupId);
    }

}
