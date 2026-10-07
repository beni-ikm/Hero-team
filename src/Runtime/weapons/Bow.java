<<<<<<<< HEAD:src/Runtime/weapons/Bow.java
package Runtime.weapons;

import Runtime.Equipement.Quiver;
========
package notusablerigthnow.weapons;

import notusablerigthnow.Quiver;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/weapons/Bow.java

public class Bow extends Weapons {

    private Quiver quiver;

    public Bow(String weaponName, int damage, Quiver quiver) {
        super("Bow", 8);
        this.quiver = quiver;
    }


}
