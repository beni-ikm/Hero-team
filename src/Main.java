import character.BaseCharacter;
import character.Name;
import classes.Job;
import species.CharacterSpecies;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please assign your hero a name : ");
        String characterName = scan.nextLine();
        System.out.print("Please choose your hero's species\n" +
                "There are 4 possible options (please write the as they are displayed) : \n" +
                "- HHUMAN : Bonus stats : - Strength +1 - Dexterity +1 - Constitution +1 - Intelligence +1 - Wisdom +1 - Charisma +1\n" +
                "- ELF : Bonus stats : - Dexterity +2 - Intelligence +1\n" +
                "- DWARF : Bonus stats : - Strength +1 - Constitution +2\n " +
                "- ORC : Bonus stats : - Strength +2 - Dexterity +1 - Intelligence -1\n" +
                "-> ");
        String heroSpecies = scan.nextLine();
        System.out.print("\nPlease choose between one of these classes for your hero :\n " +
                "- MAGE : HP= 6 MP= 10 \n " +
                "- PRIEST : HP=10 MP= 8\n " +
                "- WARRIOR : HP= 12 MP= 0\n " +
                "- RANGER : HP= 10 MP= 0\n" +
                "-> ");
        String heroClass = scan.nextLine();

        scan.close();


        Name name = new Name(characterName);

        BaseCharacter mage = new BaseCharacter(name, CharacterSpecies.valueOf(heroSpecies), Job.valueOf(heroClass), 10, 7, 12, 18, 8, 5, 15);

        System.out.println(mage);

    }
}