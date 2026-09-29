package Runtime.species;

public enum Species {
    HUMAN(+1, +1, +1, +1, +1, +1),
    ELF(0,+2,+1,0,0,0),
    DWARF(+1,0,0,+2,0,0),
    ORC(+2,0,-1,+1,0,0);

    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int constitution;
    private final int charisma;
    private final int wisdom;

    private Species(int strength, int dexterity, int intelligence,
                   int constitution, int charisma, int wisdom) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.charisma = charisma;
        this.wisdom = wisdom;
    }

    public int getSpeciesStrength() {
        return strength;
    }
    public int getSpeciesDexterity() {
        return dexterity;
    }
    public int getSpeciesIntelligence() {
        return intelligence;
    }
    public int getSpeciesConstitution() {
        return constitution;
    }
    public int getSpeciesCharisma() {
        return charisma;
    }
    public int getSpeciesWisdom() {
        return wisdom;
    }
}
