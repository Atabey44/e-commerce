package com.atabey.eticaret.dto;

import com.atabey.eticaret.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convert(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMail(user.getMail());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setPostCode(user.getPostCode());

        return userDto;

    }
}
