package controller;

import DAO.UserRepository;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import service.UserService;
import java.util.List;

import java.awt.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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

}