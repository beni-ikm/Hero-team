public class Inventory {

    // default slot size is 10 slots by inventory
    // if theres a special item that adds slots to player inventory, this item cant add more slots
    // than 20 in total for the invetory in case there's a missinput (btw this addon can still be remove i thought it would be cool to have it)

    //instanceof checks is certain item is from a certain class for boolean statements

    private short maxItemSlots;
    private List<Item> inventory = new ArrayList<>();
    private Item equipedWeapon;

    public Inventory(short maxitemSlots, Item equipedWeapon) {
        this.maxItemSlots = maxItemSlots;
        this.equipedWeapon = equipedWeapon;
        this.inventory = new ArrayList<>();
    }

    public short getMaxItemSlots() {
        return this.maxItemSlots;
    }

    // for any item that adds slots to inventory
    public short setMaxItemSlots(short maxItemSlots) {
        if (this.maxItemSlots + maxItemSlots > 20) {
            system.out.println("­[Error]: Inventory can't be greater than 20");
        } else{
            this.maxItemSlots = maxItemSlots;
        }
    }

    public void getEquipedWeapon() {
        return this.equipedWeapon;
    }

    public void setEquipedWeapon(Item item) {
        if (!inventory.contains(item)) {
            throw new IllegalArgumentException("[Error]: Item is not in your inventory.");
        }

        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            this.equipedWeapon = weapon;
        } else{
            throw new IllegalArgumentException("[Error]: This item is not a weapon.");
        }
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void setInventory(Item item) {
        if (this.inventory.size() >= this.maxItemSlots) {
            System.out.printf("Inventory is full! current inventory capacity: %d/%d", this.inventory.size(), this.maxItemSlots);
            return;
        }
            this.inventory.add(item);
    }


    // waiting for further changes to modifie this class like new item with specifique conditions.

}