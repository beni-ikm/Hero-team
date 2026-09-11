package armor;

public class ChainMailArmor extends Armor{

    public int strengthBonus;
    public int constitutionBonus;

    public ChainMailArmor(String armorName, int defence) {
        super(armorName, defence);
    }

    @Override
    public void showBonus() {
        System.out.println("Chain Mail Armor Bonus: Strength +" + strengthBonus + ", Constitution +" + constitutionBonus);
    }

    @Override
    public void equip(Character character) {

    }

    @Override
    public void unequip(Character character) {

    }
}
