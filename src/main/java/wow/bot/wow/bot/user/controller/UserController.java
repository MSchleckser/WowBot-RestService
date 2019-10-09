package wow.bot.wow.bot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wow.bot.wow.bot.user.dao.UserDao;
import wow.bot.wow.bot.user.enums.UserRole;
import wow.bot.wow.bot.user.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/insert")
	public String updateUser(@RequestBody User user) {
		if(StringUtils.isEmpty(user.getUserMention()))
			return null;

		if(userDao.existsByUserMention(user.getUserMention()))
			user.setId(userDao.findByUserMention(user.getUserMention()).getId());

		userDao.save(user);

		return "Success";
	}

	@GetMapping("/find/role/mention/{mention}")
	public String findRoleByMention(@PathVariable String mention){
		User user = userDao.findByUserMention(mention);

		if(user == null){
			user = new User();
			user.setUserRole(UserRole.USER);
			user.setUserMention(mention);
			userDao.save(user);
		}

		return	user.getUserRole().name();
	}
}
