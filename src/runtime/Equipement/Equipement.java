<<<<<<<< HEAD:src/Runtime/Equipement/Equipement.java
package runtime.Equipement;
========
package notusablerigthnow;
>>>>>>>> 26fca02 (refactor(equipement): restructure package equipement to be more inline with DDD):src/notusablerigthnow/Equipement.java

public abstract class Equipement {

    private String equipementName;

    public Equipement(String equipementName){
        this.equipementName = equipementName;
    }

    public String getEquipementName() {
        return equipementName;
    }
}
