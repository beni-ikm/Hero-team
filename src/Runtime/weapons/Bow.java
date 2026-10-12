package Runtime.weapons;

import Runtime.equipment.Quiver;

public class Bow extends Weapons {

    private Quiver quiver;

    public Bow(String weaponName, int damage, Quiver quiver) {
        super("Bow", 8);
        this.quiver = quiver;
    }


}
