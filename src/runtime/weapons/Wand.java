<<<<<<<< HEAD:src/Runtime/weapons/Wand.java
package runtime.weapons;
========
package notusablerigthnow.weapons;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/weapons/Wand.java

public class Wand extends Weapons {

    private int bonusMagic;

    public Wand(String weaponName, int damage) {
        super("Wand",4);
        this.bonusMagic = 5;
    }




}
