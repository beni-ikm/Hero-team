<<<<<<<< HEAD:src/Runtime/armor/Robe.java
package runtime.armor;
========
package notusablerigthnow.armor;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/Robe.java

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
