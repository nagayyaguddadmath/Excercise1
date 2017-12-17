package ufo.util;

public enum Constants {

	TAB_DELIMITER("\\t"),
	FILENAME("ufo_awesome.tsv");
	
	String value;
	
	Constants(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
