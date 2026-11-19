package runtime.hero.domain.exception;

public class HeroAttributeIsTooLowException extends RuntimeException {
    public HeroAttributeIsTooLowException() {
        super("Your hero's attribute value should at least be 3 or higher");
    }
}
