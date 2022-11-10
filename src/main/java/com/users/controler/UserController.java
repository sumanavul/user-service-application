package com.users.controler;

import com.users.model.User;
import com.users.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> createUser(@Body User user){
     return HttpResponse.created(userService.createUser(user));
    }
    @Get
    public HttpResponse<List<User>> getAllUsers(){
     return HttpResponse.ok(userService.getAllUsers());
    }
    @Get("/{id}")
    public HttpResponse<User> getUser(@PathVariable int id){
     return HttpResponse.ok(userService.getUser(id));
    }

}
