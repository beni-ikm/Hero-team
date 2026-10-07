<<<<<<<< HEAD:src/Runtime/armor/Equipable.java
package Runtime.armor;
========
package notusablerigthnow.armor;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/armor/Equipable.java

public interface Equipable {
    /*Pour le moment puisqu'il n'y a pas de class character*/
    void equip(Character character);
    void unequip(Character character);

}
