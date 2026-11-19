package runtime.hero.domain;

import runtime.hero.domain.exception.HeroNameAlreadyUsedException;
import runtime.hero.domain.exception.HeroNameIsEmptyException;
import runtime.hero.domain.exception.HeroNameIsTooLongException;
import runtime.hero.domain.exception.HeroNameIsTooShortException;

public record Name(String name) {

    public Name{

        if (isInvalid(name)) {
            throw new HeroNameAlreadyUsedException();
        }
        if(name.length() < 3) {
            throw new HeroNameIsTooShortException();
        }
        if (name.length() > 20) {
            throw new HeroNameIsTooLongException();
        }
    }

    public boolean isInvalid(String input) {
        if (input == null || input.isEmpty()) {
            throw new HeroNameIsEmptyException();
        }
        return !input.matches("^[a-zA-Z]{2,20}$");
    }

}
