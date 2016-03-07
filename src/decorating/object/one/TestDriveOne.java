package decorating.object.one;

/**
 * Created by Pankaj Nimgade on 07-03-2016.
 */
public class TestDriveOne {

    public static void main(String[] args) {
        DarkRoast darkRoast = new DarkRoast();

        System.out.println("Beverage: \t"+darkRoast.getDescription()+", Cost: \t"+darkRoast.getCost());

        Milk milk = new Milk(darkRoast);
        System.out.println("Beverage: \t"+milk.getDescription()+", Cost: \t"+milk.getCost());

        System.out.println("\n##########################################\n");

        Beverage beverage = new HouseBlend();

        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);
        System.out.println("Beverage: \t"+beverage.getDescription()+", Cost: \t"+beverage.getCost());


    }
}
