package com.nabil.blogapp.services.impl;

import com.nabil.blogapp.exceptions.ResourceNotFoundException;
import com.nabil.blogapp.model.User;
import com.nabil.blogapp.payloads.UserDto;
import com.nabil.blogapp.reposatories.UserRepo;
import com.nabil.blogapp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
       User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","UserId",id));
       user.setUsername(userDto.getUsername());
       user.setPassword(userDto.getPassword());
       user.setEmail(userDto.getEmail());
       User savedUser = this.userRepo.save(user);
       return this.userToDto(savedUser);
    }

    @Override
    public UserDto getUser(Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));
        return userToDto(user);
    }

    @Override
    public void deleteUser(Integer id) {
       User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));
       this.userRepo.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users  = this.userRepo.findAll();
        List<UserDto> dto = users.stream().map(user->userToDto(user)).collect(Collectors.toList());
        return dto;
    }

    public User dtoToUser(UserDto user){
        User userDto = new User();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
