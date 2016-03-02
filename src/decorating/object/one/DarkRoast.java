package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 28-02-2016.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        setDescription("DarkRoast");
    }

    @Override
    float getCost() {
        return 0.99f;
    }
}
