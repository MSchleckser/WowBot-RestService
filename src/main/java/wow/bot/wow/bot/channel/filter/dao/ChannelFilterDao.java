package wow.bot.wow.bot.channel.filter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.channel.filter.model.Channel;

public interface ChannelFilterDao extends JpaRepository<Channel, String> {

	boolean existsByChannelName(String channelName);

}
