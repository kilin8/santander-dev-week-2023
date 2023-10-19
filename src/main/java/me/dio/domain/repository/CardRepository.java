package me.dio.domain.repository;

import me.dio.domain.model.Card;
import me.dio.domain.model.TypeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByAtiveIsTrueAndDateHourExpireIsBefore(LocalDateTime dateHourExpire);

    @Query(value = "SELECT c.* FROM TB_CARD c JOIN TB_USER_CARD uc ON c.ID = uc.CARD_ID WHERE uc.TB_USER_ID = :userid AND c.TYPE = :type AND c.ATIVE is true", nativeQuery = true)
    Card findCardToCreate(@Param("userid") Long userId, @Param("type") String type);

}
