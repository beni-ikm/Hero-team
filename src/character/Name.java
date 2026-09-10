package character;

public class Name {

    private String name;

    public Name(String name){

        if (rejects(name)) {
            System.out.println("This name is not valid");
        }

        this.name = name;

    }

    public boolean rejects(String input) {
        // Returns true if the input is null, empty, or contains anything other than letters
        if (input == null || input.isEmpty()) {
            return true;
        }
        return !input.matches("^[a-zA-Z]+$");
    }


}
