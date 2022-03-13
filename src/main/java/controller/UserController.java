package controller;

import DAO.UserRepository;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import service.UserService;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/allUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> findAllUser() {
        System.out.println("con");
        return userService.findUser();

    }

    @GetMapping(path = "/allName", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> findName() {
        return userService.findNom();
    }

    @GetMapping(path = "/allVorname", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> findVorname() {
        return userService.findVorname();
    }

    @GetMapping(path = "/allUserWithAgeImpair", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> findUserAgeImpair() {
        return userService.findUserAgeImpair();
    }

    @PostMapping(path = "/create" , produces = {MediaType.APPLICATION_JSON_VALUE} )
    public User createUser (@RequestBody User user){
       return userRepository.save(user);
    }

    @PutMapping(path = "/update/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE} )
    public User updateUser (@RequestBody User user1, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUserId(user1.getUserId());
                    user.setNom(user1.getNom());
                    user.setPrenom(user1.getPrenom());
                    user.setAge(user1.getAge());
                    return userRepository.save(user);
                } )
                .orElseGet(() -> {
                    user1.setUserId(id);
                    return userRepository.save(user1);
        });
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);

    }

    @GetMapping(path = "/findUser/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public <User> java.util.Optional<entities.User> findUser (@PathVariable Long id){
        return userRepository.findById(id);

    }
}