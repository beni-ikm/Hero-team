package Runtime.equipement.domain.exception;

public class InvalidPlayerException extends EquipementException {
    public InvalidPlayerException() {
        super("Player id cannot be blank");
    }
}
