package Runtime.hero.domain;

import Runtime.hero.domain.exception.InvalidPlayerException;

public record PlayerId(String value) {

    public PlayerId {
        if (value == null || value.isBlank()){
            throw new InvalidPlayerException();
        }
    }

}
