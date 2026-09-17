package Runtime.Hero.infra;

import Runtime.Hero.application.port.HeroRepository;
import Runtime.Hero.domain.Hero;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryHeroRepository implements HeroRepository {

    HashMap<UUID, Hero> collection;

    @Override
    public void save(Hero hero) {
        collection.put(hero.uuid(), hero);
    }

    @Override
    public Hero fetch(UUID uuid) {
        // TODO : if not found throw new exception
        return collection.get(uuid);
    }

    @Override
    public boolean isNameTaken(String name){
        return false;
    }

}
