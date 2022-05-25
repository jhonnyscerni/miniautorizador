package br.com.vr.miniautorizador.domain.repositories;

import br.com.vr.miniautorizador.domain.models.Card;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByNumberCard(String numberCard);

}
