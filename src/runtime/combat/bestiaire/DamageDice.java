package runtime.combat.bestiaire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record DamageDice(int diceCount, int diceFaces, int flatBonus) {
    private static final Pattern NOTATION = Pattern.compile("(\\d+)d(\\d+)(?:\\s*([+-])\\s*(\\d+))?");

    public DamageDice {
        if (diceCount <= 0) {
            throw new DefinitionCreatureInvalideException("Le nombre de dés de dégâts doit être supérieur à zéro.");
        }
        if (diceFaces <= 0) {
            throw new DefinitionCreatureInvalideException("Le nombre de faces des dés doit être supérieur à zéro.");
        }
    }

    public static DamageDice parse(String notation) {
        if (notation == null || notation.isBlank()) {
            throw new DefinitionCreatureInvalideException("L'expression de dégâts ne peut pas être vide.");
        }
        Matcher matcher = NOTATION.matcher(notation.trim());
        if (!matcher.matches()) {
            throw new DefinitionCreatureInvalideException("Expression de dégâts invalide : " + notation);
        }
        return new DamageDice(
            Integer.parseInt(matcher.group(1)),
            Integer.parseInt(matcher.group(2)),
            signedBonus(matcher.group(3), matcher.group(4))
        );
    }

    public DamageDice forCriticalHit() {
        return new DamageDice(diceCount * 2, diceFaces, flatBonus);
    }

    private static int signedBonus(String sign, String amount) {
        if (sign == null || amount == null) {
            return 0;
        }
        int value = Integer.parseInt(amount);
        return "-".equals(sign) ? -value : value;
    }

    @Override
    public String toString() {
        String dice = diceCount + "d" + diceFaces;
        if (flatBonus > 0) {
            return dice + " + " + flatBonus;
        }
        if (flatBonus < 0) {
            return dice + " - " + (-flatBonus);
        }
        return dice;
    }
}
