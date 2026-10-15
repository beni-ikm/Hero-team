<<<<<<<< HEAD:src/Runtime/armor/LeatherArmor.java
package Runtime.armor;
========
package notusablerigthnow.armor;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/LeatherArmor.java

public class LeatherArmor extends Armor {

    public int dexterityBonus;
    public int charismaBonus;

    public LeatherArmor(String armorName, int defence) {
<<<<<<<< HEAD:src/Runtime/armor/LeatherArmor.java
        super("Leather Runtime.armor", 6);
========
        super("Leather Runtime.Equipement.armor", 6);
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/LeatherArmor.java
        this.charismaBonus = 8;
        this.dexterityBonus = 6;

    }

    @Override
    public void showBonus() {
        System.out.println("Leather Armor Bonus: Dexterity +" + dexterityBonus + ", Charisma +" + charismaBonus);
    }

}
