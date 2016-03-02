package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 28-02-2016.
 */
public class Espresso extends Beverage {

    public Espresso() {
        setDescription("Espresso");
    }

    @Override
    float getCost() {
        return 0.60f;
    }
}
