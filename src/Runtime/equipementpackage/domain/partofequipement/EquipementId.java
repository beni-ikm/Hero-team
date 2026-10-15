package Runtime.equipementpackage.domain.partofequipement;

import java.util.Objects;
import java.util.UUID;

public record EquipementId(String value) {

    public EquipementId {
        Objects.requireNonNull(value);
    }

    public static EquipementId generate() {return new EquipementId(UUID.randomUUID().toString());}
}
