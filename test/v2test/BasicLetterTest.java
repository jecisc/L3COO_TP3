package v2test;

import v2.mail.letter.Content;
import v2.mail.letter.Letter;

public abstract class BasicLetterTest {

	public abstract Letter<Content> create();
}
