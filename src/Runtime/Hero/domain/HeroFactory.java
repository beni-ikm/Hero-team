package Runtime.Hero.domain;

import Runtime.Hero.application.Create.HeroCreationCommand;

public class HeroFactory {

    public Hero create(HeroCreationArgs args) {

        Name name = new Name(args.name());

        return new Hero(name, args.species(), args.job(),
                args.health(), args.strength(), args.dexterity(),
                args.intelligence(), args.constitution(), args.charisma(), args.wisdom());


    }

}
