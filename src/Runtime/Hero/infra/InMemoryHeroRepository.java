package Runtime.Hero.infra;

import Runtime.Hero.application.port.HeroRepository;
import Runtime.Hero.domain.Hero;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryHeroRepository implements HeroRepository {

    private final HashMap<UUID, Hero> collection = new HashMap<>();

    @Override
    public void save(Hero hero) {
        collection.put(hero.uuid(), hero);
    }

    @Override
    public Hero fetch(UUID uuid) {
        Hero hero = collection.get(uuid);
        if (hero == null) {
            throw new IllegalArgumentException("Aucun héros trouvé avec l'identifiant " + uuid);
        }
        return hero;
    }
    
    @Override
    public boolean isNameTaken(String name){
        return false;
    }

}
