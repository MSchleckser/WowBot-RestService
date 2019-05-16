package wow.bot.wow.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.models.Quote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuoteDao extends JpaRepository<Quote, Integer> {

}
