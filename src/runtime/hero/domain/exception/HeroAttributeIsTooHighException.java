package runtime.hero.domain.exception;

public class HeroAttributeIsTooHighException extends RuntimeException {
    public HeroAttributeIsTooHighException() {

        super("Your hero's maximum attribute value should be 18 or lower");
    }
}
