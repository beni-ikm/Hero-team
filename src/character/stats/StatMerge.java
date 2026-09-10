package character.stats;
import species.CharacterSpecies;
import species.CharacterSpecies;
import classes.Job;

public class StatMerge {

    private int totalHealth;
    private int totalStrength;

    public void applySpeciesBonusAndChosenStats(CharacterSpecies speciesStat, StrengthStat additionalStrength, Job jobStat) {

        this.totalHealth = speciesStat.getHealthBonusSpecies() + jobStat.getBaseHealth();
        this.totalStrength = speciesStat.getStrengthBonusSpecies() + additionalStrength.getStrengthStat();

    }

}
