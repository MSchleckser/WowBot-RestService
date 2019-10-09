package wow.bot.wow.bot.mig.hunter.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kills")
public class Kill {

	@Id
	private String userName;

	private int numberOfKills;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNumberOfKills() {
		return numberOfKills;
	}

	public void setNumberOfKills(int numberOfKills) {
		this.numberOfKills = numberOfKills;
	}
}
