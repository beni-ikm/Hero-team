package Runtime.equipementpackage.domain.partofequipement;

import Runtime.equipementpackage.domain.exception.InvalidPlayerException;

public record PlayerId(String value) {

    public PlayerId {
        if (value == null || value.isBlank()){
            throw new InvalidPlayerException();
        }
    }

}
