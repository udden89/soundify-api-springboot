package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapperService {

    public UserDTO UserToDTO(Optional<User> user) {
        var u = user.get();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(u.getUsername());
        userDTO.setId(u.get_id());
        userDTO.setPlaylists(u.getPlaylists());
        return userDTO;
    }
}
