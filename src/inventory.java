import Equipement.HeroClass;
import Equipement.Item;
import weapons.Weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {

    private static final short DEFAULT_MAX_SLOTS = 10;
    private static final short ABSOLUTE_MAX_SLOTS = 20;

    private short maxItemSlots;
    private final List<Item> inventory;
    private Weapons equippedWeapon;

    public Inventory(short maxItemSlots) {
        if (maxItemSlots <= 0 || maxItemSlots > ABSOLUTE_MAX_SLOTS) {
            throw new IllegalArgumentException("La capacité de l'inventaire doit être entre 1 et " + ABSOLUTE_MAX_SLOTS);
        }
        this.maxItemSlots = maxItemSlots;
        this.inventory = new ArrayList<>();
    }

    public Inventory() {
        this(DEFAULT_MAX_SLOTS);
    }

    public short getMaxItemSlots() {
        return this.maxItemSlots;
    }

    public void expandCapacity(short extraSlots) {
        if (this.maxItemSlots + extraSlots > ABSOLUTE_MAX_SLOTS) {
            throw new IllegalStateException("L'inventaire ne peut pas dépasser " + ABSOLUTE_MAX_SLOTS + " emplacements.");
        }
        this.maxItemSlots += extraSlots;
    }

    public Weapons getEquippedWeapon() {
        return this.equippedWeapon;
    }


    public void equipWeapon(Item item, HeroClass heroClass) {
        Objects.requireNonNull(item, "L'objet ne peut pas être nul.");
        Objects.requireNonNull(heroClass, "La classe du héros ne peut pas être nulle.");


        if (!inventory.contains(item)) {
            throw new IllegalArgumentException("[Erreur]: L'objet n'est pas dans l'inventaire.");
        }


        if (!(item instanceof Weapons weapon)) {
            throw new IllegalArgumentException("[Erreur]: Cet objet n'est pas une arme.");
        }


        if (!heroClass.canEquip(item)) {
            throw new IllegalArgumentException("[Erreur]: La classe " + heroClass.getLabel() + " ne peut pas équiper cet objet.");
        }

        this.equippedWeapon = weapon;
    }

    public List<Item> getInventory() {
        return new ArrayList<>(this.inventory);
    }

    public void addItem(Item item) {
        Objects.requireNonNull(item, "L'objet ne peut pas être nul.");
        if (this.inventory.size() >= this.maxItemSlots) {
            System.out.printf("Inventaire plein! Capacité actuelle: %d/%d%n", this.inventory.size(), this.maxItemSlots);
            return;
        }
        this.inventory.add(item);
    }
}