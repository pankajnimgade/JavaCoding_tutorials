package simple.factory;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 09-03-2016.
 */
public abstract class Pizza {

    String name;
    String dough;
    String sauce;

    private ArrayList<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("preparing " + name);
        System.out.println("Tossing dough ");
        System.out.println("Adding toppings");

        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza on diagonal sides");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore Box");
    }

    @Override
    public String toString() {
        return name;
    }
}
