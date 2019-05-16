package wow.bot.wow.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.bot.wow.bot.dao.QuoteDao;
import wow.bot.wow.bot.models.Quote;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteDao quoteDao;

    @GetMapping(value = "")
    public String getQuote(HttpServletRequest request){
        String userMention = request.getParameter("user");
        Quote quote = quoteDao.findAll().stream()
                .filter(q -> q.getUserMention().equals(userMention))
                .sorted(Comparator.comparing(Quote::getQuoteTimeStamp))
                .findFirst().get();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", quote.getUserMention());
        jsonObject.put("quote", quote.getQuote());
        jsonObject.put("timestamp", quote.getQuoteTimeStamp().toString());

        return jsonObject.toJSONString();
    }

    @GetMapping(value = "/random")
    public String getRandomQuote(HttpServletRequest request){
        String userMention = request.getParameter("user");
        List<Quote> quotes = quoteDao.findAll().stream()
                .filter(q -> q.getUserMention().equals(userMention))
                .sorted(Comparator.comparing(Quote::getQuoteTimeStamp))
                .collect(Collectors.toList());

        Random r = new Random();
        Quote quote = quotes.get(r.nextInt(quotes.size()));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", quote.getUserMention());
        jsonObject.put("quote", quote.getQuote());
        jsonObject.put("timestamp", quote.getQuoteTimeStamp().toString());

        return jsonObject.toJSONString();
    }

    @PostMapping
    public String postQuote(HttpServletRequest request){
        Quote quote = new Quote();
        quote.setUserMention(request.getParameter("user"));
        quote.setQuote(request.getParameter("quote"));
        quote.setQuoteTimeStamp(LocalDateTime.parse(request.getParameter("timestamp")));
        quoteDao.save(quote);

        return quote.getUserMention() + "'s quote was successfully saved!";
    }

}
