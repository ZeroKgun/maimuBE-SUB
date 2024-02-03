package com.maimu.login.api.controller;

import com.maimu.login.api.dto.request.maimu.MaimuCreate;
import com.maimu.login.api.dto.request.maimu.MaimuDelete;
import com.maimu.login.api.dto.request.maimu.MaimuSearch;
import com.maimu.login.api.dto.response.maimu.MaimuResponse;
import com.maimu.login.api.service.MaimuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MaimuController {

    private final MaimuService maimuService;

    //외부인이 작성하기 때문에 다른 파일로 옮길 가능성 있음
    @PostMapping("/group/{groupId}/maimu")
    public void write(@PathVariable Long groupId, @RequestBody @Valid MaimuCreate request){
        maimuService.writeMaimu(groupId, request);
    }

    //마이무 1개 내용 보기
    @GetMapping("/maimu/{maimuId}")
    public MaimuResponse get(@PathVariable Long maimuId){
        return maimuService.get(maimuId);
    }

    //페이징 처리한 마이무 여러개 보기
    @GetMapping("/maimu")
    public List<MaimuResponse> getList(@ModelAttribute MaimuSearch maimuSearch){
        return maimuService.getList(maimuSearch);
    }

    //수정 가능성 있음, MaimuDelete사용할지 말지 고민중
    @PostMapping("/maimu/{maimuId}/delete")
    public void delete(@PathVariable Long maimuId, @RequestBody @Valid MaimuDelete request){
        maimuService.deleteMaimu(maimuId, request);
    }

}
