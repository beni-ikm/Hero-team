package Runtime.potions;

import Runtime.Equipement.Equipement;

public abstract class Potion extends Equipement {

    private PotionLevel potionLevel;

    public Potion(String equipementName, PotionLevel potionLevel) {
        super(equipementName);
        this.potionLevel = potionLevel;
    }




}
