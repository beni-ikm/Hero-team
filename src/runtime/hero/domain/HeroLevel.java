package runtime.hero.domain;

import runtime.hero.domain.exception.HeroLevelOutOfBoundsException;

public record HeroLevel(int value) {

    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 5;

    public HeroLevel {
        if (value < MIN_LEVEL || value > MAX_LEVEL) {
            throw new HeroLevelOutOfBoundsException();
        }
    }

    public static HeroLevel of(int value) {
        return new HeroLevel(value);
    }

    public static HeroLevel initial() {
        return of(MIN_LEVEL);
    }

    public boolean isMaxLevel() {
        return (value == MAX_LEVEL);
    }

    public int totalExperienceRequired() {
        return (switch (value) {
            case 1 -> 0;
            case 2 -> 300;
            case 3 -> 900;
            case 4 -> 2700;
            case 5 -> 6500;
            default -> throw new IllegalStateException("Unexpected level: " + value);
        });
    }

    public int totalExperienceForNextLevel() {
        return isMaxLevel() ? Integer.MAX_VALUE : of(value + 1).totalExperienceRequired();
    }

    public HeroLevel next() {
        return isMaxLevel() ? this : of(value + 1);
    }
}
