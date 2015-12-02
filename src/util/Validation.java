package util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Input validation class
 * @author Nikola
 *
 */
public class Validation {
	Pattern pattern;
	Matcher matcher;

	public Validation() {
		this.pattern = null;
		this.matcher = null;
	}

	/**
	 * Check if the string contains only letters and digits
	 * @param str  string to check
	 * @return  true if it does, otherwise false
	 */
	public boolean areLettersAndDigits(String str) {
		this.pattern = Pattern.compile("^[a-zA-Z0-9]*$");
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}

	/**
	 * Check if the string contains only letters, digits and spaces
	 * First three chars must be letters
	 * @param str  string to check
	 * @return  true if it does, otherwise false
	 */
	public boolean areLettersDigitsAndSpaces(String str) {
		this.pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9 //]*$");
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	/**
	 * Check if the string contains only letters
	 * @param str  string to check
	 * @return  true if it does, otherwise false
	 */
	public boolean areLetters(String str) {
		this.pattern = Pattern.compile("^[a-zA-Z]*$");
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	/**
	 * Check if the string contains only digits
	 * @param str  string to check
	 * @return  true if it does, otherwise false
	 */
	public boolean areDigits(String str) {
		this.pattern = Pattern.compile("^[0-9]*$");
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}

	/**
	 * Check if the string is a valid email address
	 * @param str  email address to check
	 * @return  true if it does, otherwise false
	 */
	public boolean isValidEmail(String str) {
		this.pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	/**
	 * Check if the string contains only letters and spaces
	 * @param str  string to check
	 * @return  true if it does, otherwise false
	 */
	public boolean areLettersAndSpaces(String str) {
		this.pattern = Pattern.compile("^[a-zA-Z ]*$");
		this.matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	/**
	 * Converting lowercase or uppercase words to titlecase(capitalized first letter) words 
	 * @param str  string which contains words to be converted to title case
	 * @return   string with titlecase words
	 */
	public String toTitleCase(String str){
		if(str.length()==0){
			return null;
		} else {
			String[] words = str.split(" ");
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<words.length;i++){
				sb.append(Character.toUpperCase(words[i].charAt(0)));
				sb.append(words[i].substring(1));
				sb.append(" ");
			}
			
			return sb.toString().trim();
		}
		
	}
}
