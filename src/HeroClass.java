import runtime.armor.ChainMailArmor;
import runtime.armor.LeatherArmor;
import runtime.armor.Robe;
import runtime.equipment.domain.Equipment;
import runtime.weapons.Bow;
import runtime.weapons.LongSword;
import runtime.weapons.Mace;
import runtime.weapons.Wand;

    public enum HeroClass {
        WARRIOR("Guerrier"),
        RANGER("Rôdeur"),
        MAGE("Mage"),
        PRIEST("Prêtre");

        private final String label;

        HeroClass(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public boolean canEquip(Equipment item) {
            return switch (this) {
                case WARRIOR -> item instanceof LongSword || item instanceof ChainMailArmor || item instanceof LeatherArmor;
                case RANGER -> item instanceof Bow || item instanceof LeatherArmor;
                case MAGE -> item instanceof Wand || item instanceof Robe;
                case PRIEST -> item instanceof Mace || item instanceof Wand || item instanceof Robe || item instanceof LeatherArmor;
            };
        }
    }

