package Combat.Bestiaire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record AttackDefinition(
    String name,
    int bonus,
    int diceCount,
    int diceFaces,
    int damageBonus,
    String damageExpression
) {
    private static final Pattern DAMAGE_PATTERN = Pattern.compile("(\\d+)d(\\d+)(?:\\s*([+-])\\s*(\\d+))?");

    public AttackDefinition(String name, int bonus, int diceCount, int diceFaces, int damageBonus) {
        this(
            name,
            bonus,
            diceCount,
            diceFaces,
            damageBonus,
            formatExpression(diceCount, diceFaces, damageBonus)
        );
    }

    public AttackDefinition(String name, int bonus, String damageExpression) {
        this(
            name,
            bonus,
            parseDiceCount(damageExpression),
            parseDiceFaces(damageExpression),
            parseDamageBonus(damageExpression),
            damageExpression
        );
    }

    public AttackDefinition {
        if (name == null || name.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le nom de l'attaque ne peut pas être vide.");
        }
        if (diceCount <= 0) {
            throw new DefinitionCreatureInvalideException("Le nombre de dés d'attaque doit être supérieur à zéro.");
        }
        if (diceFaces <= 0) {
            throw new DefinitionCreatureInvalideException("Le nombre de faces des dés doit être supérieur à zéro.");
        }
    }

    private static String formatExpression(int count, int faces, int bonus) {
        if (bonus > 0) {
            return count + "d" + faces + " + " + bonus;
        } else if (bonus < 0) {
            return count + "d" + faces + " - " + (-bonus);
        }
        return count + "d" + faces;
    }

    private static Matcher matchExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new DefinitionCreatureInvalideException("L'expression de dégâts ne peut pas être vide.");
        }
        Matcher matcher = DAMAGE_PATTERN.matcher(expression.trim());
        if (!matcher.matches()) {
            throw new DefinitionCreatureInvalideException("Expression de dégâts invalide: " + expression);
        }
        return matcher;
    }

    private static int parseDiceCount(String expression) {
        return Integer.parseInt(matchExpression(expression).group(1));
    }

    private static int parseDiceFaces(String expression) {
        return Integer.parseInt(matchExpression(expression).group(2));
    }

    private static int parseDamageBonus(String expression) {
        Matcher matcher = matchExpression(expression);
        String sign = matcher.group(3);
        String value = matcher.group(4);
        if (sign == null || value == null) {
            return 0;
        }
        int amount = Integer.parseInt(value);
        return "-".equals(sign) ? -amount : amount;
    }
}
