package wow.bot.wow.bot.brother.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.bot.wow.bot.brother.dao.BrotherDao;
import wow.bot.wow.bot.brother.model.Brother;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/brother")
public class BrotherController {

	private static int index = 0;

	@Autowired
	private BrotherDao brotherDao;

	@PostMapping("/add")
	public String add(HttpServletRequest request){
		Brother nBrother = new Brother();
		nBrother.setBrother(request.getParameter("brother"));
		brotherDao.save(nBrother);

		return "Brother added";
	}

	@GetMapping("")
	public String brother(){
		List<Brother> brothers = brotherDao.findAll();

		if(brothers.isEmpty())
			return "There is a lack of brothers";

		if(index >= brothers.size())
			index = 0;

		return brothers.get(index++).getBrother();
	}


}
