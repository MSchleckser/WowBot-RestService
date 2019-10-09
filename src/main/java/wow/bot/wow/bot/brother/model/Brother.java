package wow.bot.wow.bot.brother.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brother")
public class Brother {

	@Id
	@GeneratedValue
	private Integer id;

	private String brother;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrother() {
		return brother;
	}

	public void setBrother(String brother) {
		this.brother = brother;
	}
}
