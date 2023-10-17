package me.dio.domain.repository;

import me.dio.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByAtiveIsTrueAndDateHourExpireIsBefore(LocalDateTime dateHourExpire);

}
