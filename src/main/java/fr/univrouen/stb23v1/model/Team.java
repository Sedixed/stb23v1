package fr.univrouen.stb23v1.model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // DEPENDENCIES

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
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

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }
}
