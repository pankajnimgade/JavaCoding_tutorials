package sim.u.duck.test.one;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class TestDriveOne {

    public static void main(String[] args){
        Duck duck = new Duck();
        duck.display();
        duck.fly();
        System.out.println();
        Duck duck1 = new MallardDuck();
        duck1.display();
        duck1.fly();

        System.out.println();

        Duck duck2 = new RubberDuck();
        duck2.fly();
        duck2.display();
    }
}
