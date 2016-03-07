package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 01-03-2016.
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;
    private float mocha_price_integer;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        mocha_price_integer = 0.20f;
    }

    @Override
    float getCost() {
        return mocha_price_integer + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription()+", Mocha";
    }

    public float getMocha_price_integer() {
        return mocha_price_integer;
    }

    public void setMocha_price_integer(float mocha_price_integer) {
        this.mocha_price_integer = mocha_price_integer;
    }
}
