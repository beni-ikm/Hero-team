package Runtime.hero.infrastructure;

import Runtime.hero.domain.Hero;

public class HeroPersistanceMapper {

    public HeroPersistanceModel (Hero hero) {
        return new HeroPersistanceModel(
                hero.id().value,

        );
    }

}
