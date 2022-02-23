package com.soundify.api.soundifyapi.dto;

import lombok.Data;

@Data
public class DeleteIdDTO {

    public String id;

    public DeleteIdDTO() {
    }

    public DeleteIdDTO(String id) {
        this.id = id;
    }
}
