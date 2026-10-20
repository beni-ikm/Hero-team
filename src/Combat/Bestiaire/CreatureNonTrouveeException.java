package Combat.Bestiaire;

public class CreatureNonTrouveeException extends RuntimeException {
    public CreatureNonTrouveeException(String nomCreature) {
        super("La créature '" + nomCreature + "' est introuvable dans le bestiaire.");
    }
}
