package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 28-02-2016.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        setDescription("HouseBlend");
    }

    @Override
    float getCost() {
        return 0.75f;
    }
}
