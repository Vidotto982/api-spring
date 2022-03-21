package com.example.demo.person;

import javax.persistence.*;
@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name ="person_sequence",
            sequenceName= "person_sequence",
            allocationSize= 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    private Long id;
    private String name;
    private String lastname;
    private String country;


    public Person(Long id,
                  String name,
                  String lastname,
                  String country) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }


    public Person() {
    }


    public Person (String name, String lastname, String country) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }

    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setName(String name) {this.name = name;}

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public Long getId() {return id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
