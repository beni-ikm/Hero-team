package potions.mana;

import potions.Potion;
import potions.PotionLevel;

public class ManaPotion extends Potion {

    private int manaRestore;

    public ManaPotion(String equipementName, PotionLevel potionLevel) {
        super(potionName(potionLevel), potionLevel);
        this.manaRestore = getManaPotionAmount(potionLevel);
    }

    private static String potionName(PotionLevel potionLevel){
        return switch (potionLevel) {
            case LESSER -> "Lesser Mana Potion";
            case REGULAR -> "Regular Mana Potion";
            case GREATER -> "Greater Mana Potion";
            default -> "Unknown Mana Potion";
        };
    }

    public int getManaPotionAmount(PotionLevel potionLevel) {
        return switch (potionLevel) {
            case LESSER -> 25;
            case REGULAR -> 50;
            case GREATER -> 100;
            default -> 0;
        };
    }


}
