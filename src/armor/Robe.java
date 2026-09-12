package armor;

public class Robe extends Armor {

    public int intelligenceBonus;
    public int wisdomBonus;

    public Robe(String armorName, int defence) {
        super("Robe", 4);
        this.intelligenceBonus = 10;
        this.wisdomBonus = 8;
    }

    @Override
    public void showBonus() {
        System.out.println("Robe Bonus: Intelligence +" + intelligenceBonus + ", Wisdom +" + wisdomBonus);
    }


}
