package runtime.hero.application.port;

import runtime.hero.domain.Hero;

import java.util.UUID;

public interface HeroRepository {

    public void save(Hero hero);

    public Hero fetch(UUID uuid);

    public boolean isNameTaken(String name);

}
