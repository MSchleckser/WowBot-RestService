package wow.bot.wow.bot.welcomer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.welcomer.model.WelcomeChannel;

public interface WelcomeChannelDao extends JpaRepository<WelcomeChannel, Long> {
}
