package sim.u.duck.three.test;

/**
 * Created by Pankaj Nimgade on 01-02-2016.
 *
 */
public class DuckTestDrive {

    public static void main(String[] args){
        Duck duck = new MallardDuck();
        duck.display();
        duck.swim();
        duck.performFly();
        duck.performQuack();
        System.out.println();
    }
}
