package Runtime.armor;

public class LeatherArmor extends Armor {

    public int dexterityBonus;
    public int charismaBonus;

    public LeatherArmor(String armorName, int defence) {
        super("Leather Runtime.armor", 6);
        this.charismaBonus = 8;
        this.dexterityBonus = 6;

    }

    @Override
    public void showBonus() {
        System.out.println("Leather Armor Bonus: Dexterity +" + dexterityBonus + ", Charisma +" + charismaBonus);
    }

}
