package fr.univrouen.stb23v1.model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Integer id;

    // Team members
    @XmlElement
    @OneToMany(targetEntity=Member.class, cascade=CascadeType.ALL)
    private List<Member> member = new ArrayList<>();

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public List<Member> getMember() {
        return member;
    }

}
