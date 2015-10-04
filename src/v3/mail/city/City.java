package v3.mail.city;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import v3.mail.city.inhabitant.Inhabitant;
import v3.mail.letter.Content;
import v3.mail.letter.Letter;

/**
 * A city manage some {@link v1.mail.city.inhabitant.Inhabitant} and their mails.
 */
public class City {
	
	/**
	 * The name of the city.
	 */
	protected final String name;
	
	/**
	 * The list of all the inhabitants in the city.
	 */
	protected List<Inhabitant> listInhabitant = new LinkedList<Inhabitant>();
	
	/**
	 * The list of letter actually on the postbox.
	 */
	protected Set<Letter<Content>> postBox =new HashSet<Letter<Content>>();

	/**
	 * Constructor of a city. Create a new city with a name and without any inhabitant.
	 * @param name the name of the city.
	 */
	public City(String name) {
		this.name= name;
	}
	
	/**
	 * Constructor of a city. Create a new city with a name and some inhabitant in parameter.
	 * @param name the name of the city.
	 * @param inhab a list of inhabitant of the city.
	 */
	public City(String name, Inhabitant ... inhab){
		this.name = name;
		for(Inhabitant i: inhab)
			this.listInhabitant.add(i);
	}
	
	/**
	 * addInhabitant add an inhabitant to a city.  
	 * @param inhabitant the inhabitant we want to add.
	 * @return true if the inhabitant is add. Else false.
	 */
	public boolean addInhabitant(Inhabitant inhabitant){
		inhabitant.setCity(this);
		return this.listInhabitant.add(inhabitant);
	}
	
	/**
	 * distributeLetters distribute all the letters on the postbox and execute the action of the letter.
	 */
	public void distributeLetters(){
		Set<Letter<Content>> tempPostBox =this.postBox;
		this.postBox = new HashSet<Letter<Content>>();
		for(Letter<Content> letter : tempPostBox){
			letter.getReceiver().receiveLetter(letter);
		}
		tempPostBox= null;
	}
	
	/**
	 * Add a letter in the postbox.
	 * @param letter we want to add to the postbox.
	 */
	public void sendLetter(Letter<Content> letter){
		this.postBox.add(letter);
	}
	
	/**
	 * @return the name of the city.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the listInhabitant which is the list of inhabitant on the city.
	 */
	public List<Inhabitant> getListInhabitant() {
		return listInhabitant;
	}

	/**
	 * @return the postBox of the city.
	 */
	public Set<Letter<Content>> getPostBox() {
		return this.postBox;
	}
	
}
