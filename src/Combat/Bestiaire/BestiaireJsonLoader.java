package Combat.Bestiaire;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BestiaireJsonLoader {
    private static final Pattern OBJECT_PATTERN = Pattern.compile("\\{([^{}]+(?:\\{[^{}]*\\}[^{}]*)*)\\}");

    public static List<CreatureDefinition> chargerDepuisFichier(Path chemin) {
        try {
            String contenu = Files.readString(chemin);
            return chargerDepuisJson(contenu);
        } catch (IOException e) {
            throw new BestiaireChargementException("Impossible de lire le fichier JSON: " + chemin, e);
        }
    }

    public static List<CreatureDefinition> chargerDepuisJson(String json) {
        if (json == null || json.isBlank()) {
            throw new BestiaireChargementException("Le contenu JSON est vide.");
        }

        List<CreatureDefinition> definitions = new ArrayList<>();
        Matcher objectMatcher = OBJECT_PATTERN.matcher(json);

        while (objectMatcher.find()) {
            String bloc = objectMatcher.group(0);
            if (bloc.contains("\"attack\"") || bloc.contains("\"maxHitPoints\"") || bloc.contains("\"hitPoints\"")) {
                definitions.add(extraireDefinition(bloc));
            }
        }

        if (definitions.isEmpty()) {
            throw new BestiaireChargementException("Aucune définition de créature trouvée dans le JSON.");
        }

        return definitions;
    }

    public static void chargerDansBestiaire(Bestiaire bestiaire, Path chemin) {
        List<CreatureDefinition> definitions = chargerDepuisFichier(chemin);
        for (CreatureDefinition def : definitions) {
            bestiaire.enregistrer(def);
        }
    }

    private static CreatureDefinition extraireDefinition(String jsonObjet) {
        try {
            String name = extraireValeurChaine(jsonObjet, "name");
            int maxHitPoints = extraireValeurEntier(jsonObjet, "maxHitPoints", "hitPoints");
            int armorClass = extraireValeurEntier(jsonObjet, "armorClass");
            int initiativeBonus = extraireValeurEntier(jsonObjet, "initiativeBonus");
            int experiencePoints = extraireValeurEntier(jsonObjet, "experiencePoints", "experience");
            String behaviorType = extraireValeurChaine(jsonObjet, "behaviorType");

            String attackBloc = extraireSousObjet(jsonObjet, "attack");
            String attackName = extraireValeurChaine(attackBloc, "name");
            int attackBonus = extraireValeurEntier(attackBloc, "bonus");
            String damageExpression = extraireValeurChaine(attackBloc, "damageExpression");

            AttackDefinition attack = new AttackDefinition(attackName, attackBonus, damageExpression);

            return new CreatureDefinition(
                name,
                maxHitPoints,
                armorClass,
                initiativeBonus,
                experiencePoints,
                attack,
                behaviorType
            );
        } catch (Exception e) {
            throw new BestiaireChargementException("Format de créature JSON invalide: " + e.getMessage(), e);
        }
    }

    private static String extraireValeurChaine(String json, String cle) {
        Pattern pattern = Pattern.compile("\"" + cle + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new BestiaireChargementException("Propriété manquante dans le JSON: " + cle);
    }

    private static int extraireValeurEntier(String json, String... cles) {
        for (String cle : cles) {
            Pattern pattern = Pattern.compile("\"" + cle + "\"\\s*:\\s*(-?\\d+)");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
        }
        throw new BestiaireChargementException("Propriété entière manquante dans le JSON: " + cles[0]);
    }

    private static String extraireSousObjet(String json, String cle) {
        Pattern pattern = Pattern.compile("\"" + cle + "\"\\s*:\\s*\\{([^{}]*)\\}");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new BestiaireChargementException("Sous-objet manquant dans le JSON: " + cle);
    }
}
