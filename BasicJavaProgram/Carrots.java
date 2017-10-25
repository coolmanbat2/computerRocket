package playground;
import java.util.Scanner;

/**
 * This program is going to return the number of awards
 * dependent on the number of huffle-puff problems solved.
 * @author ProgrammerA
 * @since 2017
 */
public class Carrots {
	public static void main(String args[]) {
		// Setup input
		Scanner get = new Scanner(System.in);
		// Get contestants and problems solved
		int cont = get.nextInt(), prob_solv = get.nextInt();
		// Description of each person.
		String[] desc_of_cont = new String[cont];
		// Now get the description of all contestants
		for (int contestant  = 0; contestant < cont; contestant++) {
				// Description of each contestant.
				desc_of_cont[contestant] = get.nextLine();
		}
		
		// Huffle puffle awards are dependent on the number of problems solved. 
		int huffle_puff_awards = prob_solv;
		System.out.println(huffle_puff_awards);
	}
}
