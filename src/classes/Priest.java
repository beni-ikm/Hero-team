package classes;

import java.util.ArrayList;
import java.util.List;

public class Priest {

    private int baseHealth;
    private int mana;
    private List<String> initialEquipement =  new ArrayList<>();

    public Priest() {
        this.baseHealth = 10;
        this.mana = 8;
        this.initialEquipement.add("Mase");
        this.initialEquipement.add("Chainmail Armor");
    }

}
