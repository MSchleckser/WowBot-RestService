package wow.bot.wow.bot.meme.models;

import org.springframework.beans.factory.annotation.Value;
import wow.bot.wow.bot.meme.enumerations.SearchMethod;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "memes")
public class Meme {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String key;

	@NotNull
	private String memeUrl;

	@Enumerated(EnumType.STRING)
	private SearchMethod method = SearchMethod.ALONE;

	private int probability = 100;

	public Meme() {

	}

	public Meme(String key, String meme) {
		this.key = key;
		this.memeUrl = meme;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMemeUrl() {
		return memeUrl;
	}

	public void setMemeUrl(String memeUrl) {
		this.memeUrl = memeUrl;
	}

	public SearchMethod getMethod() {
		return method;
	}

	public void setMethod(SearchMethod method) {
		this.method = method;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}
}
