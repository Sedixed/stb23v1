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

    // DEPENDENCIES
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @XmlTransient
    private STB stb;

    // Team members
    @XmlElement
    @OneToMany(mappedBy = "team", cascade=CascadeType.ALL)
    private List<Member> member = new ArrayList<>();

    public Team(List<Member> member) {
        this.member = member;
    }

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public STB getStb() {
        return stb;
    }

    public List<Member> getMember() {
        return member;
    }

}
