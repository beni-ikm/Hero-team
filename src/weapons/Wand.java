package weapons;

public class Wand extends Weapons {

    private int bonusMagic;

    public Wand(String weaponName, int damage) {
        super("Wand",4);
        this.bonusMagic = 5;
    }

    @Override
    public void attack() {
        System.out.println("Casting with the wand!");
    }


}
