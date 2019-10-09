package wow.bot.wow.bot.brother.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.brother.model.Brother;

public interface BrotherDao extends JpaRepository<Brother, Integer> {
}
