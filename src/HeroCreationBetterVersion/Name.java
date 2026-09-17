package HeroCreationBetterVersion;

public class Name {

    private String name;

    public Name(String name){

        if (isInvalid(name)) {
            System.out.println("This name is not valid");
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

}
