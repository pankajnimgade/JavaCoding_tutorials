package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 28-02-2016.
 */
public class Decaf extends Beverage {

    public Decaf() {
        setDescription("Decaf");
    }

    @Override
    float getCost() {
        return 0.80f;
    }
}
