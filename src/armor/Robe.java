package armor;

public class Robe extends Armor {

    public int intelligenceBonus;
    public int wisdomBonus;

    public Robe(String armorName, int defence) {
        super(armorName, defence);
    }

    @Override
    public void showBonus() {
        System.out.println("Robe Bonus: Intelligence +" + intelligenceBonus + ", Wisdom +" + wisdomBonus);
    }

    @Override
    public void equip(Character character) {

    }

    @Override
    public void unequip(Character character) {

    }
}
