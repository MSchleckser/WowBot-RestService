package wow.bot.wow.bot.channel.filter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "FilteredChannels")
public class Channel {

	@Id
	private String channelName;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Channel channel = (Channel) o;
		return Objects.equals(channelName, channel.channelName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(channelName);
	}
}
