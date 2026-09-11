package armor;

public abstract class Armor implements Equipable{

    public String armorName;
    public int defence;

    public Armor(String armorName, int defence){
        this.armorName = armorName;
        this.defence = defence;
    }

    public abstract void showBonus();
}
