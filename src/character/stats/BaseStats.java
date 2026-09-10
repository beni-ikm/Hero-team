package character.stats;

public class BaseStats {

    private int value;

    public BaseStats(int value) {
        if (validStatValue(value)) {
            System.out.println("This stat value is not valid");
        }
        this.value = value;
    }

    public static boolean validStatValue(int statValue) {
        if (!(statValue >= 0) || statValue < 21) {
            return true;
        } else {
            return false;
        }
    }

}
