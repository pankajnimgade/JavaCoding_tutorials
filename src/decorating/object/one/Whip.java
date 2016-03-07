package decorating.object.one;

/**
 * Whip extends {@link decorating.object.one.CondimentDecorator CondimentDecorator}
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
        return this.beverage.getDescription()+", Whip";
    }

    public float getWhip_price_integer() {
        return whip_price_integer;
    }

    public void setWhip_price_integer(float whip_price_integer) {
        this.whip_price_integer = whip_price_integer;
    }
}
