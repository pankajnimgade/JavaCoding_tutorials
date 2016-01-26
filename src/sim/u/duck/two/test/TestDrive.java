package sim.u.duck.two.test;

/**
 * Created by Pankaj Nimgade on 26-01-2016.
 */
public class TestDrive {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.display();
        duck.swim();
        System.out.println();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.swim();
        System.out.println();

        Duck mallardDuck = new MallardDuck();
        ((MallardDuck)mallardDuck).fly();
        System.out.println();

        Duck redheadDuck = new RedheadDuck();
        ((RedheadDuck)redheadDuck).fly();
    }
}
