package me.dio.domain.repository;

import me.dio.domain.model.Card;
import me.dio.domain.model.TypeCard;
import me.dio.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
    @Query("SELECT c FROM User u WHERE u.id = :id AND c.type = :type AND c.active = true")
    Card findActiveCardByUserIdAndType(Long id, TypeCard type);
}
