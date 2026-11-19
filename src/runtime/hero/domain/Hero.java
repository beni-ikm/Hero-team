package runtime.hero.domain;

import java.util.Objects;
import java.util.UUID;

public class Hero {

    private Name name;
    UUID uuid;
    private HeroAttribute strength;
    private HeroAttribute dexterity;
    private HeroAttribute constitution;
    private HeroAttribute intelligence;
    private HeroAttribute wisdom;
    private HeroAttribute charm;
    private HeroLevel level;
    private HeroExperience experience;

    private static final HeroLevel START_LEVEL = HeroLevel.of(1);
    private static final HeroExperience START_EXPERIENCE = HeroExperience.of(0);

    public UUID uuid() {
        return uuid;
    }

    public Hero(Name name,
                HeroAttribute strength,
                HeroAttribute dexterity,
                HeroAttribute constitution,
                HeroAttribute intelligence,
                HeroAttribute wisdom,
                HeroAttribute charm){
        this.name = Objects.requireNonNull(name);
        this.strength = Objects.requireNonNull(strength);
        this.dexterity = Objects.requireNonNull(dexterity);
        this.constitution = Objects.requireNonNull(constitution);
        this.intelligence = Objects.requireNonNull(intelligence);
        this.wisdom = Objects.requireNonNull(wisdom);
        this.charm = Objects.requireNonNull(charm);
        this.level = Objects.requireNonNull(START_LEVEL);
        this.experience = Objects.requireNonNull(START_EXPERIENCE);

    }

    public void gainExperience(int amount) {
        this.experience = this.experience.add(amount);

        while (this.experience.isAtLeast(this.level.totalExperienceForNextLevel())) {
            this.level = this.level.next();
        }
    }

}
