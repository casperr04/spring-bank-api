package com.bank.bankapi.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank
    @Length(min = 28, max = 28)
    @Column(unique = true)
    private String accountNumber;
    @NotBlank
    @Length(min = 1, max = 35)
    private String firstName;
    @NotBlank
    @Length(min = 1, max = 35)
    private String middleName;

    @NotBlank
    @Column(unique = true)
    @Length(min = 1, max = 35)
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Length(min = 4, max = 16)
    @Column(unique = true)
    private String phoneNumber;
    @NotBlank
    @Past
    private Date dateOfBirth;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<CardEntity> cards;
    @CreationTimestamp
    @PastOrPresent
    private Date creationDate;
}
