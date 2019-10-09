package wow.bot.wow.bot.channel.filter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wow.bot.wow.bot.channel.filter.dao.ChannelFilterDao;
import wow.bot.wow.bot.channel.filter.model.Channel;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/channels")
public class ChannelController {

	@Autowired
	private ChannelFilterDao channelFilterDao;

	@GetMapping("/filtered")
	public List<String> getFilteredChannels(){
		return channelFilterDao.findAll().stream().map(Channel::getChannelName).collect(Collectors.toList());
	}

	@GetMapping("/filtered/{channelName}")
	public boolean checkIsChannelFiltered(@PathVariable("channelName") String channelName){
		return channelFilterDao.existsByChannelName(channelName);
	}

	@PostMapping("/filtered/add/{channelName}")
	public String addFilteredChannel(@PathVariable("channelName") String channelName){
		Channel channel = new Channel();
		channel.setChannelName(channelName);

		channelFilterDao.save(channel);

		return "Successful";
	}

	@PostMapping("/filtered/remove/{channelName}")
	public String removeFilteredChannel(@PathVariable("channelName") String channelName){
		Channel channel = new Channel();
		channel.setChannelName(channelName);

		channelFilterDao.delete(channel);

		return "Successful";
	}


}
