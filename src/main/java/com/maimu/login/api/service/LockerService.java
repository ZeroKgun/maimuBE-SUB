package com.maimu.login.api.service;

import com.maimu.login.api.domain.Locker;
import com.maimu.login.api.domain.Users;
import com.maimu.login.api.dto.request.locker.LockerCreate;
import com.maimu.login.api.repository.LockerRepository;
import com.maimu.login.api.repository.UserRepository;
import com.maimu.login.api.exception.UserNotFound;
import com.maimu.login.api.exception.LockerNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LockerService {

    private final LockerRepository lockerRepository;
    private final UserRepository userRepository;

    //User가 만들어질 때 호출해서 Locker만들기
    //Locker field가 더 추가될 가능성 있어서 LockerCreate DTO 사용
    public void save(Long id, LockerCreate lockerCreate){
        Users users = userRepository.findById(id)
                        .orElseThrow(UserNotFound::new);
        
        Locker locker = Locker.builder()
                .lockerName(lockerCreate.getLockerName())
                .build();
        locker.setUsers(users);

        lockerRepository.save(locker);
    }
    
    //사용할 일은 없을듯 하지만 일단 만듦, Locker삭제 기능
    public void delete(Long id){
        Locker locker = lockerRepository.findById(id)
                .orElseThrow(LockerNotFound::new);
        lockerRepository.delete(locker);
    }
    


}
