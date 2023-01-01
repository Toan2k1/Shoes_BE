package com.example.shoebe.Controller;

import com.example.shoebe.Service.UserService;
import com.example.shoebe.config.JwtTokenProvider;
import com.example.shoebe.exception.ResourceNotFoundException;
import com.example.shoebe.model.CustomUserDetails;
import com.example.shoebe.model.User;
import com.example.shoebe.model.request.userRequest.CreateUserRequest;
import com.example.shoebe.model.request.userRequest.EditUserRequest;
import com.example.shoebe.model.request.userRequest.LoginRequest;
import com.example.shoebe.model.response.LoginResponse;
import com.example.shoebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    /*@PreAuthorize("hasAuthority('User.Write')")*/
    @PostMapping("/registration")
    public Boolean createUser( @RequestBody CreateUserRequest request) throws Exception {
        return userService.createUser(request);
    }

    /*@PreAuthorize("hasAuthority('User.Delete')")*/
    @DeleteMapping("/DeleteUser/{userId}")
    Boolean delUser(@PathVariable long userId) {
        return userService.delUser(userId);
    }

    /*@PreAuthorize("hasAuthority('User.Read')")*/
    @GetMapping("/getListUser")
    public List<User> getListUser() {
        return   userService.getListUser();
    }

    /*@PreAuthorize("hasAuthority('User.Write')")*/
    @PutMapping("/editUser/{id}")
    public User editUser(@PathVariable long id,@RequestBody EditUserRequest request){
        request.setId(id);
        return userService.editUser(request);}
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }
}
