<<<<<<<< HEAD:src/Runtime/potions/Potion.java
package Runtime.potions;

import Runtime.Equipement.Equipement;
========
package notusablerigthnow.potions;

import notusablerigthnow.Equipement;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/potions/Potion.java

public abstract class Potion extends Equipement {

    private PotionLevel potionLevel;

    public Potion(String equipementName, PotionLevel potionLevel) {
        super(equipementName);
        this.potionLevel = potionLevel;
    }




}
