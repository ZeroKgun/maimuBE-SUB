package com.maimu.login.api.service;

import com.maimu.login.api.domain.Maimu;
import com.maimu.login.api.domain.group.Group;
import com.maimu.login.api.dto.request.maimu.MaimuCreate;
import com.maimu.login.api.dto.request.maimu.MaimuDelete;
import com.maimu.login.api.dto.request.maimu.MaimuSearch;
import com.maimu.login.api.dto.response.maimu.MaimuResponse;
import com.maimu.login.api.repository.group.GroupRepository;
import com.maimu.login.api.repository.maimu.MaimuRepository;
import com.maimu.login.api.exception.GroupNotFound;
import com.maimu.login.api.exception.MaimuNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaimuService {

    private final MaimuRepository maimuRepository;
    private final GroupRepository groupRepository;

    @Transactional
    public void writeMaimu(Long groupId, MaimuCreate maimuCreate){
        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFound::new);

        Maimu maimu = Maimu.builder()
                .message(maimuCreate.getMessage())
                .maimuColor(maimuCreate.getMaimuColor())
                .writerName(maimuCreate.getWriterName())
                .build();
        group.addMaimu(maimu);
    }

    public MaimuResponse get(Long id){
        Maimu maimu = maimuRepository.findById(id)
                .orElseThrow(MaimuNotFound::new);

        return MaimuResponse.builder()
                .id(maimu.getId())
                .message(maimu.getMessage())
                .maimuColor(maimu.getMaimuColor())
                .writerName(maimu.getWriterName())
                .build();
    }

    public List<MaimuResponse> getList(MaimuSearch maimuSearch){
        return maimuRepository.getList(maimuSearch).stream()
                .map(MaimuResponse::new)
                .collect(Collectors.toList());
    }


//    maimuDelete를 활용할 수 있는 방법 생각해봐야 할듯
    public void deleteMaimu(Long maimuId, MaimuDelete maimuDelete){
        Maimu maimu = maimuRepository.findById(maimuId)
                .orElseThrow(MaimuNotFound::new);

        maimuRepository.delete(maimu);
    }


}
