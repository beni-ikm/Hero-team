package Combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Combat {
    private final String id;
    private final List<Combatant> participants;
    private int currentRound;
    private int currentTurnIndex;
    private boolean isFinished;

    public Combat(String id, List<Combatant> heroes, List<Combatant> creatures) {
        this.id = id;
        this.currentRound = 1;
        this.currentTurnIndex = 0;
        this.isFinished = false;

        this.participants = new ArrayList<>();
        this.participants.addAll(heroes);
        this.participants.addAll(creatures);

        rollInitiative();
    }

    private void rollInitiative() {
        for (Combatant combatant : participants) {
            int d20 = (int) (Math.random() * 20) + 1;
            int totalInitiative = d20 + combatant.getInitiativeBonus();
            combatant.setInitiativeScore(totalInitiative);
        }

        participants.sort(Comparator.comparingInt(Combatant::getInitiativeScore).reversed());
    }

    public Combatant getCurrentCombatant() {
        return participants.get(currentTurnIndex);
    }

    public void defendCurrentCombatant() {
        Combatant current = getCurrentCombatant();
        if (current.isHero() && !current.hasActedThisTurn()) {
            current.setDefending(true);
            current.setHasActedThisTurn(true);
        }
    }

    public void nextTurn() {
        if (checkCombatEnd()) {
            this.isFinished = true;
            return;
        }

        do {
            currentTurnIndex++;

            if (currentTurnIndex >= participants.size()) {
                currentTurnIndex = 0;
                currentRound++;
            }
        } while (getCurrentCombatant().isKnockedOut());

        Combatant nextCombatant = getCurrentCombatant();
        nextCombatant.resetTurnState();
        nextCombatant.setDefending(false);
    }

    public boolean checkCombatEnd() {
        boolean anyHeroAlive = participants.stream()
                .filter(Combatant::isHero)
                .anyMatch(c -> !c.isKnockedOut());

        boolean anyCreatureAlive = participants.stream()
                .filter(c -> !c.isHero())
                .anyMatch(c -> !c.isKnockedOut());

        return !anyHeroAlive || !anyCreatureAlive;
    }

    public String getId() { return id; }
    public int getCurrentRound() { return currentRound; }
    public List<Combatant> getParticipants() { return List.copyOf(participants); }
    public boolean isFinished() { return isFinished; }
}