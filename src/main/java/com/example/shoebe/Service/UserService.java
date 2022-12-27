package com.example.shoebe.Service;

import com.example.shoebe.model.CustomUserDetails;

import com.example.shoebe.model.User;
import com.example.shoebe.model.request.userRequest.CreateUserRequest;
import com.example.shoebe.model.request.userRequest.EditUserRequest;
import com.example.shoebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    public UserDetails loadUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(userId.toString());
        }
        return new CustomUserDetails(user.get());
    }
    public boolean createUser(CreateUserRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getUsername()) || StringUtils.isEmpty(request.getPassword())) {
            throw new Exception("Invalid User Request");
        }

        User user = new User(request.getUsername(), passwordEncoder.encode(request.getPassword()),request.getEmail());
        userRepository.save(user);

        return true;
    }
    public boolean delUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    public User editUser(EditUserRequest request) {
        var optionalUser = userRepository.findById(request.getId());
        if (optionalUser.isPresent()) {
            var editUser = optionalUser.get();
            editUser.setUsername(request.getUsername());
            editUser.setPassword(request.getPassword());
            return userRepository.save(editUser);
        }
        return null;
    }

    public List<User> getListUser() {
        return userRepository.findByIsDelete(false);
    }
}

