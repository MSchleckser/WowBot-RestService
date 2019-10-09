package wow.bot.wow.bot.mig.hunter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wow.bot.wow.bot.mig.hunter.dao.GameChannelDao;
import wow.bot.wow.bot.mig.hunter.models.GameChannel;

@RestController
@RequestMapping("gamechannel")
public class GameChannelController {

	@Autowired
	private GameChannelDao dao;

	@PostMapping
	public String setGameChannel(@RequestBody GameChannel gameChannel){
		dao.save(gameChannel);
		return "success";
	}

	@GetMapping
	public String getGameChannel(){
		GameChannel channel = dao.findAll().stream().sorted((l,r) -> r.getId() - l.getId()).findFirst().orElse(null);

		if(channel == null)
			return "";

		return channel.getChannelName();
	}
}
