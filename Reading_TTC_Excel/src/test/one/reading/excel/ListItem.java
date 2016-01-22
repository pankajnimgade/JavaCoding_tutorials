package test.one.reading.excel;

import java.io.Serializable;

public class ListItem implements Serializable{

	private Place japanesePlace;
	
	private Place englishPlace;
	
	private Place chinesePlace;

	public Place getJapanesePlace() {
		return japanesePlace;
	}

	public void setJapanesePlace(Place japanesePlace) {
		this.japanesePlace = japanesePlace;
	}

	public Place getEnglishPlace() {
		return englishPlace;
	}

	public void setEnglishPlace(Place englishPlace) {
		this.englishPlace = englishPlace;
	}

	public Place getChinesePlace() {
		return chinesePlace;
	}

	public void setChinesePlace(Place chinesePlace) {
		this.chinesePlace = chinesePlace;
	}

}
