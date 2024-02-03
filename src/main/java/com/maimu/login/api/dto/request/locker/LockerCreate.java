package com.maimu.login.api.dto.request.locker;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class LockerCreate {

    @NotBlank(message = "write locker name.")
    private String lockerName;

    @Builder
    public LockerCreate(String lockerName){
        this.lockerName = lockerName;
    }

}
