package Combat;

public interface Combatant {
    String getId();
    String getName();
    int getArmorClass();
    int getInitiativeBonus();
    int getInitiativeScore();
    void setInitiativeScore(int score);
    boolean isHero();
    boolean isKnockedOut();
    void takeDamage(int amount);
    boolean isDefending();
    void setDefending(boolean defending);
    boolean hasActedThisTurn();
    void setHasActedThisTurn(boolean hasActed);
    void resetTurnState();

    int getWeaponDiceCount();
    int getWeaponDiceFaces();
    String getWeaponAssociatedStat();

    int getStatModifier(String statName);
    int getProficiencyBonus();
}