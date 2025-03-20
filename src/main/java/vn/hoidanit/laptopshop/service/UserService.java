package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.registerDTO;
import vn.hoidanit.laptopshop.repository.RoleRepo;
import vn.hoidanit.laptopshop.repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    UserService(UserRepo userRepo, RoleRepo roleRepo ){
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
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
    public User handleGetUserByEmail(String email){
        return this.userRepo.findByEmail(email);
    }
    public void handleDeleteById(long Id){
        this.userRepo.deleteById(Id);
    }
    public List<User>handleGetUserSortedByCreated(){
        return this.userRepo.findAllByOrderByCreatedAtDesc();
    }
    public User handleGetUserById(long id){
        return this.userRepo.findById(id);
    }
    public Role handleGetRoleByName(String name){
        return this.roleRepo.findByroleName(name);
    }

    public User registerDTOtoUser(registerDTO rDTO){
        User user = new User();
        user.setFullName(rDTO.getFirstName() + " " + rDTO.getLastName());
        user.setPassword(rDTO.getPassword());
        user.setEmail(rDTO.getEmail());
        user.setPhone(rDTO.getPhone());
        return user;
    }
    public boolean handleCheckExistByEmail(String Email){
        return this.userRepo.existsByEmail(Email);
    }
}
