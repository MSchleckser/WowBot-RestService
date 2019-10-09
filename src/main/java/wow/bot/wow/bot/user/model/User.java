package wow.bot.wow.bot.user.model;

import wow.bot.wow.bot.user.enums.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private String userMention;

	@NotNull
	@Column
	private UserRole userRole = UserRole.USER;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserMention() {
		return userMention;
	}

	public void setUserMention(String userMention) {
		this.userMention = userMention;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
