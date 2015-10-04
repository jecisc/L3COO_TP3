package v1;

import java.util.Random;

import v1.mail.city.City;
import v1.mail.city.inhabitant.Inhabitant;
import v1.mail.city.inhabitant.bankaccount.BankAccount;
import v1.mail.letter.Content;
import v1.mail.letter.Letter;
import v1.mail.letter.concreteletters.PromissoryNote;
import v1.mail.letter.concreteletters.SimpleLetter;
import v1.mail.letter.content.Money;
import v1.mail.letter.content.Text;

/**
 * An example a mail's simulation.
 */
public class MailSimulation {

	private static City initCity(String name){
		System.out.println("Creating "+name+" city.");
		return new City(name);
	}
	
	private static void initInhabitant(int numberInhab, City city){
		if(numberInhab<2)
			throw new IllegalArgumentException("The number of inhabitants should be at least 2 !");

		System.out.println("Creating "+numberInhab+" inhabitants.");
		for(int i = 0; i < numberInhab ; i++)
			city.addInhabitant(new Inhabitant(Integer.toString(i), new BankAccount(5000)));
	}
	
	private static void initDays(int numberDays){
		if(numberDays<1)
			throw new IllegalArgumentException("The number of day should be at least 1 !");
		
		System.out.println("Mailing letters for "+ numberDays +" days");
	}
	
	private static Inhabitant RandomInhab(City city){
		Random randInhabitant = new Random();
		return city.getListInhabitant().get(randInhabitant.nextInt(city.getListInhabitant().size()));
	}
	
	private static Letter<Content> TypeOfLetter(Inhabitant s, Inhabitant r){
		Random randLetter = new Random();
		int randomInt = randLetter.nextInt(2);
		if (randomInt == 0)
			return new SimpleLetter(s, r, new Text());
		else{
				Random randMoney = new Random();
				return new PromissoryNote(s, r, new Money(randMoney.nextInt(1000)));
			}
	}

	/**
	 * An example of mail's simulation. 
	 * @param args in this order : the name of the city, the number of inhabitant, the number of day the city work.
	 */
	public static void main(String[] args) {
		if(args.length != 3)
			System.out.println("Hello here ! For use this software you need 3 parameters !\n 1) The name of your city\n 2) the number of inhabitants (number >= 2)\n 3) The number of day the simulation should run (number >= 1).\n Try Again !");

		City city = initCity(args[0]);
		
		int numberInhab = Integer.parseInt(args[1]);

		initInhabitant(numberInhab, city);
		
		int numberDays = Integer.parseInt(args[2]);
		
		initDays(numberDays);
		
		Random rand = new Random();
		for(int Day=1;Day <= numberDays; Day++){
			System.out.println("**************************************************\nDay"+Day);
			city.distributeLetters();
			int numberActions = rand.nextInt(5)+1;
			while(numberActions != 0){
				Inhabitant sender = RandomInhab(city);
				Inhabitant receiver = RandomInhab(city);
				Letter<Content> letter = TypeOfLetter(sender, receiver);
				sender.sendLetter(letter);
				numberActions--;
			}
		}
	}

}
