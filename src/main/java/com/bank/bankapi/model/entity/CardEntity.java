package com.bank.bankapi.model.entity;

import com.bank.bankapi.constants.CardType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "card")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @ToString.Exclude
    private UserEntity owner;
    @Enumerated(EnumType.STRING)
    private CardType type;
    @Column(nullable = false)
    private long balance;
    @Column(nullable = false)
    private Date expirationDate;
    @Column(nullable = false)
    private String cvv;
    @Column(nullable = false)
    private String primaryAccountNumber;
    @Column(nullable = false)
    private boolean isValid = true;
    @Column(nullable = false)
    private int spendingLimit = 0;
}