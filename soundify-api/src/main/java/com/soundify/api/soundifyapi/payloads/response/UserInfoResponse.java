package com.soundify.api.soundifyapi.payloads.response;

import lombok.Data;

@Data
public class UserInfoResponse {
    private String id;
    private String username;
    private String email;

    public UserInfoResponse(String id, String username, String email) {

    }

}
