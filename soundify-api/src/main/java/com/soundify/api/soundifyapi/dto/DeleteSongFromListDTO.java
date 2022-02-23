package com.soundify.api.soundifyapi.dto;

import lombok.Data;

@Data
public class DeleteSongFromListDTO {
    private String id;

    public DeleteSongFromListDTO() {
    }

    public DeleteSongFromListDTO(String id) {
        this.id = id;
    }
}
