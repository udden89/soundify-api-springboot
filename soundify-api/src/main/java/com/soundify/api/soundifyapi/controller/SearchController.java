package com.soundify.api.soundifyapi.controller;
import com.soundify.api.soundifyapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/{mediaType}")
    public String searchMusicAPI(@RequestParam(name="query") String query,
                                 @RequestParam(name="next") Optional<String> next,
                                 @PathVariable(value="mediaType") String mediaType) {

        String nextQuery = next.isPresent() ? "?next=" + next.get() : "";
        String result = searchService.fetch(mediaType, query, nextQuery);

        return result;
    }
}
