package com.soundify.api.soundifyapi.payloads.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String text;

    public MessageResponse(String text) {
        this.text = text;
    }
}
