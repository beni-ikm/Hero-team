package Runtime.Hero.domain;

import java.util.UUID;

public class Hero {

    private Name name;
    UUID uuid;

    public UUID uuid() {
        return uuid;
    }

    public Hero(Name name){
        this.name = name;
    }

}
