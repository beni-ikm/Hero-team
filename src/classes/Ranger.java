package classes;

import java.util.ArrayList;
import java.util.List;

public class Ranger {

    private int basehealth;
    private int mana;
    private List<String> initialEquipement = new ArrayList<>();

    public Ranger() {

        this.basehealth = 6;
        this.mana = 10;
        this.initialEquipement.add("Bow");
        this.initialEquipement.add("Leather Armor");

    }

}
