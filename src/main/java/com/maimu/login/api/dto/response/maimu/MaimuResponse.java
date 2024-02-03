package com.maimu.login.api.dto.response.maimu;

import com.maimu.login.api.domain.Maimu;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MaimuResponse {

    private final Long id;
    private final String message;
    private final String maimuColor;
    private final String writerName;

    public MaimuResponse(Maimu maimu){
        this.id = maimu.getId();
        this.message = maimu.getMessage();
        this.maimuColor = maimu.getMaimuColor();
        this.writerName = maimu.getWriterName();
    }

    @Builder
    public MaimuResponse(Long id, String message, String maimuColor, String writerName){
        this.id = id;
        this.message = message;
        this.maimuColor = maimuColor;
        this.writerName = writerName;
    }
}
