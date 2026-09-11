package potions.healing;

public class GreaterHealingPotion implements HealingPotionsBehavior {

    @Override
    public void potionHeal() {
        System.out.println("You have used a Greater Healing Potion! Your health is fully restored.");
    }
}
