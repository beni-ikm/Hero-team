<<<<<<<< HEAD:src/Runtime/armor/ChainMailArmor.java
package Runtime.armor;
========
package notusablerigthnow.armor;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/ChainMailArmor.java

public class ChainMailArmor extends Armor{

    public int strengthBonus;
    public int constitutionBonus;

    public ChainMailArmor(String armorName, int defence) {
        super("Chain Mail", 10);
        this.constitutionBonus = 5;
        this.strengthBonus = 4;
    }

    @Override
    public void showBonus() {
        System.out.println("Chain Mail Armor Bonus: Strength +" + strengthBonus + ", Constitution +" + constitutionBonus);
    }


}
