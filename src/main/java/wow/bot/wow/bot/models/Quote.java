package wow.bot.wow.bot.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Quotes")
public class Quote {

    @Id
    @GeneratedValue
    private int quoteIndex;

    private String userMention;

    private String quote;

    private LocalDateTime quoteTimeStamp;

    public int getQuoteIndex() {
        return quoteIndex;
    }

    public void setQuoteIndex(int quoteIndex) {
        this.quoteIndex = quoteIndex;
    }

    public String getUserMention() {
        return userMention;
    }

    public void setUserMention(String userMention) {
        this.userMention = userMention;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public LocalDateTime getQuoteTimeStamp() {
        return quoteTimeStamp;
    }

    public void setQuoteTimeStamp(LocalDateTime quoteTimeStamp) {
        this.quoteTimeStamp = quoteTimeStamp;
    }
}
