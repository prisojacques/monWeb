package service;

import DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.User;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findUser(){
        return userRepository.findAllUser();
    }
    public List<String> findNom(){
        return userRepository.findName();
    }
    public List<String> findVorname(){
        return userRepository.findPrenom();
    }

    public List<String> findUserAgeImpair() {
        return userRepository.findAllUserByAgeImpair();
    }

    }