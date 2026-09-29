package Runtime.classes;

import Runtime.Equipement.Quiver;
import Runtime.armor.ChainMailArmor;
import Runtime.armor.LeatherArmor;
import Runtime.armor.Robe;
import Runtime.weapons.Bow;
import Runtime.weapons.LongSword;
import Runtime.weapons.Mace;
import Runtime.weapons.Wand;

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

        public boolean canEquip(Item item) {
            return switch (this) {
                case WARRIOR -> item instanceof LongSword || item instanceof ChainMailArmor || item instanceof LeatherArmor;
                case RANGER -> item instanceof Bow || item instanceof LeatherArmor || item instanceof Quiver;
                case MAGE -> item instanceof Wand || item instanceof Robe;
                case PRIEST -> item instanceof Mace || item instanceof Wand || item instanceof Robe || item instanceof LeatherArmor;
            };
        }
    }

