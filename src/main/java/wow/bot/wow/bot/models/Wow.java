package wow.bot.wow.bot.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wows")
public class Wow {

    @Id
    private String wowMessage;

    public String getWowMessage() {
        return wowMessage;
    }

    public void setWowMessage(String wowMessage) {
        this.wowMessage = wowMessage;
    }
}
