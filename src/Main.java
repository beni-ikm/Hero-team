import Runtime.Hero.domain.AttributesModificator;

public class Main {
    public static void main(String[] args) {

        AttributesModificator attributesModificator = new AttributesModificator();

        attributesModificator.modAlternation(10);


        System.out.println(attributesModificator.modAlternation(3));

    }
}