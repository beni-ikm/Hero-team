package runtime.hero.domain;

import runtime.hero.domain.exception.HeroAttributeIsTooHighException;
import runtime.hero.domain.exception.HeroAttributeIsTooLowException;

public record HeroAttribute(int value) {

    public HeroAttribute {
        if (value > 18) {
            throw new HeroAttributeIsTooHighException();
        }
        if (value < 3) {
            throw new HeroAttributeIsTooLowException();
        }
    }
}


