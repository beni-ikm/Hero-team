package runtime.combat.bestiaire;

public class CreatureNonTrouveeException extends BestiaireException {
    public CreatureNonTrouveeException(String nomCreature) {
        super("La créature '" + nomCreature + "' est introuvable dans le bestiaire.");
    }
}
