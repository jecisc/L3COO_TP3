package v1test;

import v1.mail.letter.Content;
import v1.mail.letter.Letter;

public abstract class BasicLetterTest {

	public abstract Letter<Content> create();
}
