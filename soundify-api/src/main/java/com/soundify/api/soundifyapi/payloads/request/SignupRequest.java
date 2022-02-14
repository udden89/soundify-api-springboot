package com.soundify.api.soundifyapi.payloads.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String user_name;

}
