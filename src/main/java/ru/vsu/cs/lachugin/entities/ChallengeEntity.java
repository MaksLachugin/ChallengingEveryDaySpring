package ru.vsu.cs.lachugin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "challenge")
public class ChallengeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "need", nullable = false)
    private Long need;
    @Column(name = "days", nullable = false)
    private Long days;
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "challenge")
    private List<RepetitionEntity> repetitionEntities;

    public ChallengeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNeed() {
        return need;
    }

    public void setNeed(Long need) {
        this.need = need;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    }
