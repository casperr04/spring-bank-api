package com.bank.bankapi.repository;

import com.bank.bankapi.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
    CardEntity findById(long id);
    CardEntity findByPrimaryAccountNumber(String pan);
}
