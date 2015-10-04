package v2.mail.letter;

/**
 *	Interface of the content of a letter.
 */
public interface Content {

	/**
	 * Return a description of the content. This description is us for print some information about the content of a mail.
	 * @return a description of the content.
	 */
	public String getDescription();
}
