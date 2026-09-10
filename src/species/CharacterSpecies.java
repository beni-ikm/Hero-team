package species;

public enum CharacterSpecies {
    HUMAN(0, 1, 1, 1, 1,1, 1),
    ELF(0, 0, 2, 0, 1, 0, 0),
    DWARF(0, 1, 0, 2, 0, 0 ,0),
    ORC(0, 2, 1, 0, -1, 0, 0);

    private int health;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    CharacterSpecies(int health, int strength, int dexterity, int constitution,
                               int intelligence, int wisdom, int charisma) {
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getHealthBonusSpecies() {
        return health;
    }
    public int getStrengthBonusSpecies() {
        return strength;
    }
    public int getDexterityBonusSpecies() {
        return dexterity;
    }
    public int getConstitutionBonusSpecies() {
        return constitution;
    }
    public int getIntelligenceBonusSpecies() {
        return intelligence;
    }
    public int getWisdomBonusSpecies() {
        return wisdom;
    }
    public int getCharismaBonusSpecies(){
        return charisma;
    }
}
