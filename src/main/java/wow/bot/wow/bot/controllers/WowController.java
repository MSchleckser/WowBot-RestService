package wow.bot.wow.bot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.bot.wow.bot.dao.WowDao;
import wow.bot.wow.bot.models.Wow;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/wow")
public class WowController {

    private static int index = 0;

    @Autowired
    private WowDao wowDao;

    @GetMapping
    public String getWow(){
        List<Wow> wows = wowDao.findAll();

        if(wows.size() == 0)
            return "Fail";

        Wow wow = wows.get(index++);

        if(index >= wows.size())
            index = 0;

        return wow.getWowMessage();
    }

}
