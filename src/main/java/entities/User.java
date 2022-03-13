package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    private String nom, prenom;
  private int age;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;

   @ManyToMany
   @JoinTable(
           name = "user_address",
             joinColumns = @JoinColumn(name =  "user_id"),
             inverseJoinColumns = @JoinColumn(name = "address_id")
   )
   List<Adresse> adresseList = new ArrayList<>();


    public User() {
    }

    public User(String nom, String prenom, int age, Long userId) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.userId = userId;
    }

    public void addAdresse(Adresse adresse){
        adresseList.add(adresse);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
