package com.soundify.api.soundifyapi.mapper;

import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.User;
import java.util.Optional;

public class UserMapper {


    public UserDTO UserToDTO(Optional<User> user) {
        var u = user.get();
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name(u.getUsername());
        userDTO.setId(u.get_id());
        userDTO.setPlaylists(u.getPlaylists());
        return userDTO;
    }
}
