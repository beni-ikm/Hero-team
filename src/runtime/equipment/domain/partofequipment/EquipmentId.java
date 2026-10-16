package runtime.equipment.domain.partofequipment;

import java.util.Objects;
import java.util.UUID;

public record EquipmentId(String value) {

    public EquipmentId {
        Objects.requireNonNull(value);
    }

    public static EquipmentId generate() {return new EquipmentId(UUID.randomUUID().toString());}
}
