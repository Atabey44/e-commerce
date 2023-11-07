package com.atabey.eticaret.service;

import com.atabey.eticaret.dto.CreateUserRequest;
import com.atabey.eticaret.dto.UpdateUserRequest;
import com.atabey.eticaret.dto.UserDto;
import com.atabey.eticaret.dto.UserDtoConverter;
import com.atabey.eticaret.exception.UserNotFoundException;
import com.atabey.eticaret.repository.UserRepository;
import com.atabey.eticaret.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException("User couldn't be found by following id:" +id));
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setMiddleName(userRequest.getMiddleName());
        user.setMail(userRequest.getMail());
        user.setPostCode(userRequest.getPostCode());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User userFound = user.get();
            userFound.setFirstName(updateUserRequest.getFirstName());
            userFound.setLastName(updateUserRequest.getLastName());
            userFound.setMiddleName(updateUserRequest.getMiddleName());
            userFound.setMail(updateUserRequest.getMail());
            userFound.setPostCode(updateUserRequest.getPostCode());

            return userDtoConverter.convert(userRepository.save(userFound));
        } else {
            return null;
        }

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
