package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public String handleHelloWord(){
        return "Hello from User service";
    }
    public User handleSaveUser(User user){
        return this.userRepo.save(user);
    }
    public List<User> handleListALlUser(){
        return this.userRepo.findAll();
    }
    public List <User> handleGetUserByEmail(String email){
        return this.userRepo.findByEmail(email);
    }
}
