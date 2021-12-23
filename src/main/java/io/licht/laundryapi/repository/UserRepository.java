package io.licht.laundryapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.licht.laundryapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{

    Optional<User> findByUserName(String userName);
    
}
