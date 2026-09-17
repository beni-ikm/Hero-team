package HeroCreationBetterVersion;

public class HeroFactory {

    public Hero create(HeroCreationArgs args) {

        Name name = new Name(args.name());

        return new Hero(name);
    }

}
