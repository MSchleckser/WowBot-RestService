package wow.bot.wow.bot.meme.enumerations;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.function.BiFunction;

public enum SearchMethod {
	CONTAINED((meme, key) -> {
		return key.toLowerCase().contains(meme.toLowerCase());
	}),
	ALONE((meme, key) -> {
		return key.toLowerCase().equals(meme.toLowerCase());
	});

	private BiFunction<String, String, Boolean> matchFunction;

	private SearchMethod(BiFunction<String, String, Boolean> matchFunction){
		this.matchFunction = matchFunction;
	}

	public Boolean match(String meme, String key){
		return matchFunction.apply(meme, key);
	}
}
