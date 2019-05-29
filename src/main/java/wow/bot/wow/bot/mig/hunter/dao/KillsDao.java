package wow.bot.wow.bot.mig.hunter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.mig.hunter.models.Kill;

public interface KillsDao extends JpaRepository<Kill, String> {
}
