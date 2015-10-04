package v3test;

import v3.mail.letter.Content;
import v3.mail.letter.Letter;

public abstract class BasicLetterTest {

	public abstract Letter<Content> create();
}
