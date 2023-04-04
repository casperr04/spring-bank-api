package com.bank.bankapi.repository;

import com.bank.bankapi.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(long id);
    UserEntity findByEmail(String email);
    UserEntity findByPhoneNumber(String phoneNumber);
}
