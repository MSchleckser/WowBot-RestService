package wow.bot.wow.bot.welcomer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WelcomeChannel")
public class WelcomeChannel {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Column
	public String channelName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
