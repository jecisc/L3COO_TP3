package v3test;

import v3.mail.city.inhabitant.Inhabitant;
import v3.mail.letter.BasicLetter;
import v3.mail.letter.Content;
import v3.mail.letter.content.Text;

//This MockLetter will have a boolean. The boolean is false and will pass to True if the "action" method is execute.
public class MockLetter extends BasicLetter<Text> implements Content {

	private boolean finish = false;
	
	public MockLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	public void action(){
		this.finish = true;
	}
	
	public boolean getState(){
		return this.finish;
	}

	public double getCost() {
		return BasicLetter.BASICCOST;
	}

	public String getType() {
		return "A MockLetter";
	}
	
}
