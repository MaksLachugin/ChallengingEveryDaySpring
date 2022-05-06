package ru.vsu.cs.lachugin.entities;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "pass", nullable = false)
    private String pass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<ChallengeEntity> challengeEntities;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<ChallengeEntity> getChallengeEntities() {
        return challengeEntities;
    }

    public void setChallengeEntities(List<ChallengeEntity> challengeEntities) {
        this.challengeEntities = challengeEntities;
    }

    public ClientEntity() {
    }
}
