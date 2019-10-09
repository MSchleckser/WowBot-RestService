package wow.bot.wow.bot.meme.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import wow.bot.wow.bot.meme.models.Meme;

import java.util.List;

public interface MemeDao extends JpaRepository<Meme, Integer> {
	public List<Meme> findByKeyIgnoreCase(String key);
}
