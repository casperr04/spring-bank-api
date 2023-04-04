package com.bank.bankapi.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, length = 35)
    private String firstName;
    @Column(length = 35)
    private String middleName;
    @Column(nullable = false, length = 35)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 16, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<CardEntity> cards;
    @CreationTimestamp
    private Date creationDate;
}
