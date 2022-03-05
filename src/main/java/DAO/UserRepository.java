package DAO;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u")
    List<User> findAllUser();

    @Query("select u.nom from User u")
    List<String> findName();

    @Query("select u.prenom from User u")
    List<String> findPrenom();

    @Query("select u from User u where age%2=1 " )
    List<String> findAllUserByAgeImpair();

}
