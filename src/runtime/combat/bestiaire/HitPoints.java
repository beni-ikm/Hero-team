package runtime.combat.bestiaire;

public record HitPoints(int current, int maximum) {
    public HitPoints {
        if (maximum <= 0) {
            throw new DefinitionCreatureInvalideException("Les points de vie maximum doivent être supérieurs à zéro.");
        }
        if (current < 0 || current > maximum) {
            throw new DefinitionCreatureInvalideException("Les points de vie actuels doivent être entre 0 et " + maximum + ".");
        }
    }

    public static HitPoints full(int maximum) {
        return new HitPoints(maximum, maximum);
    }

    public HitPoints afterDamage(int amount) {
        if (amount <= 0) {
            return this;
        }
        return new HitPoints(Math.max(0, current - amount), maximum);
    }

    public HitPoints afterHealing(int amount) {
        if (amount <= 0) {
            return this;
        }
        return new HitPoints(Math.min(maximum, current + amount), maximum);
    }

    public boolean isDepleted() {
        return current == 0;
    }
}
