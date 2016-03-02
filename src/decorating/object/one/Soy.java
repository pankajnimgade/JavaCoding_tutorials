package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 01-03-2016.
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;
    private float soy_price_integer;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
        this.soy_price_integer = 0.25f;
    }

    @Override
    float getCost() {
        return this.soy_price_integer + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription();
    }

    public float getSoy_price_integer() {
        return soy_price_integer;
    }

    public void setSoy_price_integer(float soy_price_integer) {
        this.soy_price_integer = soy_price_integer;
    }
}
