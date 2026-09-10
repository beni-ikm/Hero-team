package classes;

import java.util.ArrayList;
import java.util.List;

public class Ranger {

    private int baseHealth;
    private int mana;
    private List<String> initialEquipement = new ArrayList<>();

    public Ranger() {

        this.baseHealth = 10;
        this.mana = 0;
        this.initialEquipement.add("Bow");
        this.initialEquipement.add("Leather Armor");

    }

}
