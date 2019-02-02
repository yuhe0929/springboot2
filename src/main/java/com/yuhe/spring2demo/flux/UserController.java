package com.yuhe.spring2demo.flux;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    @ExceptionHandler(ResourceNotFoundException.class)
    public void notFound() {

    }

    @GetMapping("")
    public Flux<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody User user) {
        return userService.createOrUpdate(user);
    }

    @PostMapping("/{id}")
    public Mono<User> update(@PathVariable("id") Integer id, @RequestBody User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User> delete(@PathVariable("id") final Integer id) {
        return this.userService.delete(id);
    }
}
