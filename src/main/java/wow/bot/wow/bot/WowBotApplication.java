package wow.bot.wow.bot;
import org.springframework.stereotype.Service;
import wow.bot.wow.bot.dao.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@Service
@SpringBootApplication
public class WowBotApplication {

	@Autowired
	private QuoteDao quoteDao;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WowBotApplication.class);
		application.run(args);
	}
}