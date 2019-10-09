package wow.bot.wow.bot.welcomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wow.bot.wow.bot.welcomer.model.WelcomeChannel;
import wow.bot.wow.bot.welcomer.dao.WelcomeChannelDao;

@RestController
@RequestMapping("/welcomechannel")
public class WelcomeChannelController {

	@Autowired
	public WelcomeChannelDao dao;

	@PostMapping
	public String updateWelcomeChannel(@RequestBody WelcomeChannel welcomeChannel) {
		dao.save(welcomeChannel);
		return "Success";
	}

	@GetMapping
	public String getWelcomeChannel(){
		WelcomeChannel welcomeChannel = dao.findAll().stream().sorted((l,r) -> r.getId() - l.getId()).findFirst().orElse(null);

		if(welcomeChannel == null)
			return "";

		return welcomeChannel.getChannelName();
	}
}
