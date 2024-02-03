package com.maimu.login.api.dto.request.maimu;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MaimuCreate {

    @NotBlank(message = "please write message")
    private String message;

    @NotBlank(message = "please write maimuColor")
    private String maimuColor;

    @NotBlank(message = "please write writerName")
    private String writerName;

    @Builder
    public MaimuCreate(String message, String maimuColor, String writerName){
        this.message = message;
        this.maimuColor = maimuColor;
        this.writerName = writerName;
    }

}
