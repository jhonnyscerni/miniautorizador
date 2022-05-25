package br.com.vr.miniautorizador.domain.models;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cards")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String numberCard;

    @Column(nullable = false)
    private String password;

    private BigDecimal balance = new BigDecimal("500.00");

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;

    public Card(Long id, String numberCard, String password, BigDecimal balance) {
        this.id = id;
        this.numberCard = numberCard;
        this.password = password;
        this.balance = balance;
    }
}
