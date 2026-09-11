package potions.healing;

public class HealingPotion implements HealingPotionsBehavior {
    @Override
    public void potionHeal() {
        System.out.println("You have used a Healing Potion!");
    }
}
