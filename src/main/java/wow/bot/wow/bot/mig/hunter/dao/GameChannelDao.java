package wow.bot.wow.bot.mig.hunter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.mig.hunter.models.GameChannel;

public interface GameChannelDao extends JpaRepository<GameChannel, String> {
}
