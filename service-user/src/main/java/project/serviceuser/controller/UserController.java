package project.serviceuser.controller;


import project.serviceuser.controller.request.ProfileRequest;
import project.serviceuser.controller.request.UpdatePasswordRequest;
import project.serviceuser.controller.request.UserJoinRequest;
import project.serviceuser.controller.request.UserLoginRequest;
import project.serviceuser.controller.response.ProfileResponse;
import project.serviceuser.controller.response.Response;
import project.serviceuser.controller.response.UserJoinResponse;
import project.serviceuser.controller.response.UserLoginResponse;
import project.serviceuser.model.User;
import project.serviceuser.service.UserService;
import project.serviceuser.utils.ClassUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        return Response.success(UserJoinResponse.fromUser(userService.join(request.getUserName(), request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword())));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }

    @GetMapping("/me")
    public Response<UserJoinResponse> me(Authentication authentication) {
        return Response.success(UserJoinResponse.fromUser(userService.loadUserByUsername(authentication.getName())));
    }

    @PostMapping("/profile")
    public Response<ProfileResponse> createProfile(@RequestBody ProfileRequest request, Authentication authentication) {
        User user = ClassUtils.getSafeCastInstance(authentication.getPrincipal(), User.class);
        return Response.success(ProfileResponse.fromProfile(userService.create(user.getId(), request.getProfileImgUrl(), request.getDescription())));
    }

    @PutMapping("/profile/{userId}")
    public Response<ProfileResponse> modifyProfile(@PathVariable Integer userId, @RequestBody ProfileRequest request) {
        return Response.success(ProfileResponse.fromProfile(userService.modify(userId, request.getProfileImgUrl(), request.getDescription())));
    }

    @PostMapping("/logout")
    public void logout(Authentication authentication) {
        User user = ClassUtils.getSafeCastInstance(authentication.getPrincipal(), User.class);
        userService.logout(user);
    }

    @PutMapping("/{userId}/password")
    public Response<String> updatePassword(@PathVariable("userId") Integer userId, @RequestBody UpdatePasswordRequest request, Authentication authentication) {
        User user = ClassUtils.getSafeCastInstance(authentication.getPrincipal(), User.class);
        userService.updatePassword(user, userId, request.getNewPassword());
        return Response.success("Password updated successfully");
    }

    @GetMapping("/{userId}")
    public String getUserName(@PathVariable("userId") Integer userId, Authentication authentication) {
        return userService.getUserNameById(userId);
    }

}