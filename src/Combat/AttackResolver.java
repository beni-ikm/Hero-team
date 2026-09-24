package Combat;

public class AttackResolver {

    public record AttackResult(boolean isHit, boolean isCritical, int damage, String message) {}

    public AttackResult resolveAttack(Combatant attacker, Combatant target) {
        if (attacker.isKnockedOut() || target.isKnockedOut() || attacker.hasActedThisTurn()) {
            return new AttackResult(false, false, 0, "Action invalide.");
        }

        int naturalRoll = (int) (Math.random() * 20) + 1;
        attacker.setHasActedThisTurn(true);

        if (naturalRoll == 1) {
            return new AttackResult(false, false, 0, attacker.getName() + " fait un échec critique !");
        }

        String associatedStat = attacker.getWeaponAssociatedStat();
        int statMod = attacker.getStatModifier(associatedStat);
        int proficiency = attacker.isHero() ? attacker.getProficiencyBonus() : 0;

        int diceCount = attacker.getWeaponDiceCount();
        int diceFaces = attacker.getWeaponDiceFaces();

        if (naturalRoll == 20) {
            int damage = rollDice(diceCount * 2, diceFaces) + statMod;
            target.takeDamage(damage);
            return new AttackResult(true, true, damage, attacker.getName() + " inflige un coup critique de " + damage + " dégâts !");
        }

        int totalAttackRoll = naturalRoll + statMod + proficiency;
        int targetAC = target.getArmorClass() + (target.isDefending() ? 2 : 0);

        if (totalAttackRoll >= targetAC) {
            int damage = rollDice(diceCount, diceFaces) + statMod;
            target.takeDamage(damage);
            return new AttackResult(true, false, damage, attacker.getName() + " touche et inflige " + damage + " dégâts.");
        }

        return new AttackResult(false, false, 0, attacker.getName() + " rate son attaque.");
    }

    private int rollDice(int count, int faces) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += (int) (Math.random() * faces) + 1;
        }
        return total;
    }
}