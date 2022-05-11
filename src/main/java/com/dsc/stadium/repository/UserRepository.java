package com.dsc.stadium.repository;

import com.dsc.stadium.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneNumberEqualsOrLoginEquals(@Nullable String phoneNumber, String login);
}
