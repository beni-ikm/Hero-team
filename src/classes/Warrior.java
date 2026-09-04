package classes;

import java.util.ArrayList;
import java.util.List;

public class Warrior {

    private int baseHealth;
    private int mana;
    private List<String> initialEquipement = new ArrayList<>();

    public Warrior() {

        this.baseHealth = 12;
        this.mana = 0;
        this.initialEquipement.add("Long Sword");
        this.initialEquipement.add("Chainmail Armor");

    }

}
