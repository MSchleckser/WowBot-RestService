package wow.bot.wow.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.models.Wow;

public interface WowDao extends JpaRepository<Wow, String>{
}
