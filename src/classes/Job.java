package classes;

import java.util.ArrayList;
import java.util.List;

public enum Job {

    WARRIOR(12, 0, List.of("Long Sword", "Chainmail Armor")),
    RANGER(10, 0, List.of("Bow", "Leather Armor")),
    MAGE(6, 10, List.of("Wand", "Robe")),
    PRIEST(10, 8, List.of("Mase", "Chainmail Armor"));

    private int baseHealth;
    private int mana;
    private List<String> initialEquipement = new ArrayList<>();

    Job(int baseHealth, int mana, List<String> initialEquipement) {
        this.baseHealth = baseHealth;
        this.mana = mana;
        this.initialEquipement = initialEquipement;
    }

    public int getBaseHealth() {
        return baseHealth;
    }
    public int getMana() {
        return mana;
    }

}
