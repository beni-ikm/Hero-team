package weapons;

public class Mace extends Weapons {

    public Mace(String weaponName, int damage) {
        super("Mace", 15);
    }

    @Override
    public void attack() {
        System.out.println("Swinging the mace!");
    }
}
