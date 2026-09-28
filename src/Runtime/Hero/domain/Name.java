package Runtime.Hero.domain;

import Runtime.Hero.domain.exception.HeroNameAlreadyUsedException;
import Runtime.Hero.domain.exception.HeroNameInvalidException;

public class Name {

    private String name;

    public Name(String name){

        if (isInvalid(name)) {
            System.out.printf("The name %s is not valid\n", name);
            throw new HeroNameInvalidException("The name "+ name +" is not valid");
        } else if (nameAlreadyUsed(name)) {
            System.out.printf("The name ' %s ' is already in use\n", name);
            throw new HeroNameAlreadyUsedException("The name "+ name +" is already in use");
        }

        this.name = name;

    }

    public boolean isInvalid(String input) {
        // Rend vrai si l'entrée est nulle, vide, fait moins de 2 caractères,
        // plus de 20 caractères, ou contient autre chose que des lettres.
        if (input == null || input.isEmpty()) {
            return true;
        }
        return !input.matches("^[a-zA-Z]{2,20}$");
    }

    public boolean nameAlreadyUsed(String input) {
        // Chercher dans le JSON qui va etre cree dans l'issue journalisation
        return false;
    }

}
