package Runtime.Hero.domain;

public class AttributesModificator {

    public int modAlternation(int attribute){
        return Math.floorDiv(attribute - 10, 2);
    }

}
