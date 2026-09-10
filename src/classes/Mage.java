package classes;

import java.util.ArrayList;
import java.util.List;

public class Mage {

    private int baseHealth;
    private int mana;
    private List<String> initialEquipement = new ArrayList<>();

    public Mage() {
        this.baseHealth = 6;
        this.mana = 10;

    }

}
