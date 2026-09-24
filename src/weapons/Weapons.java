package weapons;

import Equipement.Equipement;

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
