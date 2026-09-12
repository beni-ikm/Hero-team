package armor;

import Equipement.Equipement;

public abstract class Armor extends Equipement {

    private int defence;

    public Armor(String name, int defence){
        super(name);
        this.defence = defence;
    }

    public void showBonus() {
        System.out.println("Armor Bonus: Defence +" + defence);
    }

}
