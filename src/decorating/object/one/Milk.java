package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 01-03-2016.
 */
public class Milk extends CondimentDecorator {

    private Beverage beverage;
    private float milk_price_integer;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
        this.milk_price_integer = 0.15f;
    }

    @Override
    float getCost() {
        return this.milk_price_integer + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription()+", Milk";
    }

    public float getMilk_price_integer() {
        return milk_price_integer;
    }

    public void setMilk_price_integer(float milk_price_integer) {
        this.milk_price_integer = milk_price_integer;
    }
}
