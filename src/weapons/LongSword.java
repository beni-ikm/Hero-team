package weapons;

public class LongSword extends Weapons {

    public LongSword(String weaponName, int damage) {
        super("Long Sword", 10);
    }

    @Override
    public void attack() {
        System.out.println("Swinging the longsword!");
    }
}
