package runtime.hero.domain;

import runtime.hero.domain.exception.HeroExperienceOutOfBoundsException;

public record HeroExperience(int value) {

    public static final int MIN_EXPERIENCE = 0;

    public HeroExperience {
        if (value < MIN_EXPERIENCE) {
            throw new HeroExperienceOutOfBoundsException();
        }
    }

    public static HeroExperience of(int value) {
        return new HeroExperience(value);
    }

    public HeroExperience add(int amount) {
        if (amount < MIN_EXPERIENCE) {
            throw new HeroExperienceOutOfBoundsException();
        }
        return new HeroExperience(this.value + amount);
    }

//    public HeroExperience substract(int amount) {
//        if (this.value - amount < MIN_EXPERIENCE) {
//            return new HeroExperience(MIN_EXPERIENCE);
//        }
//        return new HeroExperience(this.value - amount);
//    }
    public boolean isAtLeast(int requiredTotalExperience) {
        return this.value >= requiredTotalExperience;
    }
}
