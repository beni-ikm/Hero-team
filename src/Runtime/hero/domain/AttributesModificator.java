package Runtime.hero.domain;

public class AttributesModificator {

    public int modAlternation(int attribute){
        return (int) (Math.floor(attribute - 10) / 2);
    }

}
