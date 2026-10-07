package Runtime.equipement.domain.partofequipement;

import Runtime.equipement.domain.exception.InvalidPlayerException;

public record PlayerId(String value) {

    public PlayerId {
        if (value == null || value.isBlank()){
            throw new InvalidPlayerException();
        }
    }

}
