package potions.healing;

public class LesserHealingPotion implements HealingPotionsBehavior {

    @Override
    public void potionHeal() {
        System.out.println("You have used a Lesser Healing Potion.");
    }
}
