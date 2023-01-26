package com.example.projekt.Uloha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UlohaRepository extends JpaRepository<UlohaEntity, Long>{
}
