package com.nabil.blogapp.reposatories;

import com.nabil.blogapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
