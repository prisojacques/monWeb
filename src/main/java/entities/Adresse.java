package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private Long id;
    private String strasse;
    private int numero;

    @ManyToMany
     List<User> userList = new ArrayList<>();

    public Adresse(String strasse, int numero, Long id) {
        this.strasse = strasse;
        this.numero = numero;
        this.id = id;
    }

    public Adresse() {
    }

   public void addUser(User user){
        userList.add(user);
   }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
