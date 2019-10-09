package wow.bot.wow.bot.mig.hunter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.bot.wow.bot.mig.hunter.dao.KillsDao;
import wow.bot.wow.bot.mig.hunter.models.Kill;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("kills")
public class KillController {

	@Autowired
	private KillsDao killsDao;

	@PostMapping("/add")
	public String add(HttpServletRequest request) {
		String user = request.getParameter("user");
		Kill kill = null;
		if (!killsDao.existsById(user)) {
			kill = new Kill();
			kill.setUserName(user);
			kill.setNumberOfKills(1);
		} else {
			kill = killsDao.getOne(user);
			kill.setNumberOfKills(kill.getNumberOfKills() + 1);
		}

		killsDao.save(kill);

		return Integer.toString(kill.getNumberOfKills());
	}

	@GetMapping("/count")
	public String count(HttpServletRequest request){
		String user = request.getParameter("user");

		if(!killsDao.existsById(user))
			return "0";

		return Integer.toString(killsDao.getOne(user).getNumberOfKills());
	}

}
