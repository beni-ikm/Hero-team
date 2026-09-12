package Equipement;

public abstract class Equipement {

    private String equipementName;

    public Equipement(String equipementName){
        this.equipementName = equipementName;
    }

    public String getEquipementName() {
        return equipementName;
    }
}
