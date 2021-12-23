package io.licht.laundryapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.User;
import io.licht.laundryapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    public User createUser(User user)
    {
        user.setCreateAt(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User checkLogin(User user) throws Exception
    {
        User userExists = userRepository.findByUserName(user.getUserName()).get();

        // Check if password is valid
        if (passwordEncoder().matches(user.getPassword(), userExists.getPassword()))
        {
            return userExists;
        }
        else
            throw new Exception("failed, username or password not match");
    }
}
