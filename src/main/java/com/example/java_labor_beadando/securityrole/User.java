package com.example.java_labor_beadando.securityrole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String név;
    private String Jelszó;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name ="USER_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")})
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getJelszó() {
        return Jelszó;
    }

    public void setJelszó(String jelszó) {
        Jelszó = jelszó;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
