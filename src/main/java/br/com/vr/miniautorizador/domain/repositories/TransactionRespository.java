package br.com.vr.miniautorizador.domain.repositories;

import br.com.vr.miniautorizador.domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRespository extends JpaRepository<Transaction, Long> {

}
