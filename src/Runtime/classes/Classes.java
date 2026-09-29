package Runtime.classes;

public enum Classes {

    WARRIOR(12, 0),
    RANGER(10, 0),
    MAGE(6, 10),
    PRIEST(10, 8);

    private final int baseJobHealth;
    private final int baseJobMana;

    private Classes(int baseJobHealth, int baseJobMana){
        this.baseJobHealth = baseJobHealth;
        this.baseJobMana = baseJobMana;
    }

    public int getBaseJobHealth() {
        return baseJobHealth;
    }
    public int getBaseJobMana() {
        return baseJobMana;
    }
}
