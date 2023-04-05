package com.bank.bankapi.model.entity;

import com.bank.bankapi.constants.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank
    private long balance = 0;
    @NotBlank
    @Future
    private Date expirationDate;
    @NotBlank
    @Length(min=3,max=3)
    private String cvv;
    @NotBlank
    private String primaryAccountNumber;

    /**
     * If card has been blocked, this will be false.
     */
    @NotBlank
    private boolean isValid = true;
    @NotBlank
    private int spendingLimit = 0;
    @CreationTimestamp
    @PastOrPresent
    private Date creationDate;
}
