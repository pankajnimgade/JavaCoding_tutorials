package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 01-03-2016.
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;
    private float whip_price_integer;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
        this.whip_price_integer = 0.20f;
    }

    @Override
    float getCost() {
        return this.whip_price_integer + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription();
    }

    public float getWhip_price_integer() {
        return whip_price_integer;
    }

    public void setWhip_price_integer(float whip_price_integer) {
        this.whip_price_integer = whip_price_integer;
    }
}
