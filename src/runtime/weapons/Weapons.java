<<<<<<<< HEAD:src/Runtime/weapons/Weapons.java
package runtime.weapons;

import runtime.Equipement.Equipement;
========
package notusablerigthnow.weapons;

import notusablerigthnow.Equipement;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/weapons/Weapons.java

public abstract class Weapons extends Equipement implements AttackBehavior {

    private int damage;

    public Weapons(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with weapon!");
    }


}
