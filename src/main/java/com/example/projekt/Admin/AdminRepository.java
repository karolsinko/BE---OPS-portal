package com.example.projekt.Admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Long> {
    //Optional<AdminEntity> findByUsername(String username);
}
