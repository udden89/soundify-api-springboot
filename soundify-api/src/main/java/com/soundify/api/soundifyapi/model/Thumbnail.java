package com.soundify.api.soundifyapi.model;

import lombok.Data;

@Data
public class Thumbnail {

    private Integer height;
    private Integer width;
    private String url;

    public Thumbnail() {
    }

    public Thumbnail(Integer height, Integer width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }
}
