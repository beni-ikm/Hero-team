package runtime.hero.domain.exception;

public class HeroNameAlreadyUsedException extends RuntimeException {

    public HeroNameAlreadyUsedException(){
        super("Hero name is already taken");
    }

}
