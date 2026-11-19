package runtime.hero.domain.exception;

public class HeroExperienceOutOfBoundsException extends RuntimeException {
    public HeroExperienceOutOfBoundsException() {

        super("The Hero's experience is out of bonds.");
    }
}
