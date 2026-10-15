<<<<<<<< HEAD:src/Runtime/armor/Armor.java
package runtime.armor;

import runtime.Equipement.Equipement;
========
package notusablerigthnow.armor;

import notusablerigthnow.Equipement;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/Armor.java

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
