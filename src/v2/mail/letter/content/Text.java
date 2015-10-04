package v2.mail.letter.content;

import v2.mail.letter.Content;

/**
 * A text that will be a content of some letter like SimpleLetter.
 */
public class Text implements Content {

	protected String text;
	
	/**
	 * Construct a lambda text.
	 */
	public Text(){
		this.text= "bla bla";
	}
	
	/**
	 * Construct a Text.
	 * @param text the text the letter will contains.
	 */
	public Text(String text){
		this.text = text;
	}
	
	public String getDescription() {
		return "("+this.text+")";
	}

}
