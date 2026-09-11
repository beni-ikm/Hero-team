package armor;

public class LeatherArmor extends Armor {

    public int dexterityBonus;
    public int charismaBonus;

    public LeatherArmor(String armorName, int defence) {
        super(armorName, defence);
    }

    @Override
    public void showBonus() {
        System.out.println("Leather Armor Bonus: Dexterity +" + dexterityBonus + ", Charisma +" + charismaBonus);
    }

    @Override
    public void equip(Character character) {

    }

    @Override
    public void unequip(Character character) {

    }
}
