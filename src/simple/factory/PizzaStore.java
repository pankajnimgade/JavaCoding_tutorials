package simple.factory;

/**
 * Created by Pankaj Nimgade on 09-03-2016.
 */
public abstract class PizzaStore  {


    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
