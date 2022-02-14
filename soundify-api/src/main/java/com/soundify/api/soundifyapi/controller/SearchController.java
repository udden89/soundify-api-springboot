package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.service.SearchService;
import com.soundify.api.soundifyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public void getAllUsers() {

        return ;
    }


 /*
    router.get('/:mediaType', async (req: Request, res: Response) => {

  const mediaType = req.params.mediaType
  const query = req.query.query
  const next = req.query?.next

  const result = await searchService(mediaType, query, next)

        if (result) {
            return res.json(result)
        } else {
            return res.sendStatus(500).json(result.message)
        }
    })*/


}
