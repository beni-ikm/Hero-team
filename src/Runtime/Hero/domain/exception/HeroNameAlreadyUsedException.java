package Runtime.Hero.domain.exception;

public class HeroNameAlreadyUsedException extends RuntimeException {

    public HeroNameAlreadyUsedException(String name){
        super("Runtime.Hero name "+ name + " is already taken");
    }

}
