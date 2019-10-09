package wow.bot.wow.bot.meme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wow.bot.wow.bot.meme.dao.MemeDao;
import wow.bot.wow.bot.meme.models.Meme;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("meme")
public class MemeController {

	@Autowired
	private MemeDao memeDao;

	@GetMapping("/key/{key}")
	public List<Meme> getMemesBykey(@PathVariable String key) {
		return memeDao.findByKeyIgnoreCase(key);
	}

	@GetMapping("/key/{key}/random")
	public Meme getRandomMemeBykey(@PathVariable String key) {
		List<Meme> memes = memeDao.findAll();
		System.out.println(memes.size());
		Random rand = new Random();
		int probability = rand.nextInt(100);
		System.out.println(probability);
		memes = memes.stream()
				.filter(m -> m.getMethod().match(m.getKey(), key))
				.filter(m -> m.getProbability() > probability)
				.collect(Collectors.toList());
		System.out.println(memes.size());
		return memes.isEmpty() ? null : memes.get(rand.nextInt(memes.size()));
	}

	@PostMapping("/key/{key}")
	public void putMemesBykey(@PathVariable String key, @RequestBody String memeUrl) {
		Meme meme = new Meme(key, memeUrl);
		memeDao.save(meme);
	}

}
