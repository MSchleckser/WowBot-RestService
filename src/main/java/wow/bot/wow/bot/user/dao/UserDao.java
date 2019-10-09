package wow.bot.wow.bot.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.user.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUserMention(String userMention);

	boolean existsByUserMention(String userMention);

}
