package com.nabil.blogapp.services;

import com.nabil.blogapp.payloads.UserDto;

import java.util.List;

public interface UserServices {
    public UserDto createUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto,Integer id);
    public UserDto getUser(Integer id);
    public void deleteUser(Integer id);
    public List<UserDto> getAllUsers();
}
