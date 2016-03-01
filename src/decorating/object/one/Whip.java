package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 01-03-2016.
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    float getCost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
