package potions.healing;

import potions.Potion;
import potions.PotionLevel;


public class HealingPotion extends Potion {

    private int heal;

    public HealingPotion(String equipementName, PotionLevel potionLevel) {
        super(potionName(potionLevel), potionLevel);
        this.heal = getHealAmount(potionLevel);
    }


    private static String potionName(PotionLevel potionLevel){
        return switch (potionLevel) {
            case LESSER -> "Lesser Healing Potion";
            case REGULAR -> "Regular Healing Potion";
            case GREATER -> "Greater Healing Potion";
            default -> "Unknown Healing Potion";
        };
    }

    public int getHealAmount(PotionLevel potionLevel) {
        return switch (potionLevel) {
            case LESSER -> 25;
            case REGULAR -> 50;
            case GREATER -> 100;
            default -> 0;
        };
    }

}
