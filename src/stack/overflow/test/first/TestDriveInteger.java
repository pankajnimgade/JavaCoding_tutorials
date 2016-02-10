package stack.overflow.test.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Pankaj Nimgade on 10-02-2016.
 */
public class TestDriveInteger {

    public static void main(String[] args) {
        int blocked[][] = new int[][]{{0, 4}, {2, 2}, {3, 1}, {3, 3}};
        System.out.println("\n"+Arrays.deepToString(blocked)+"\n");
        ArrayList<Integer> list = toArrayList(blocked);

        System.out.println("########### Converted integer List ##############\n");

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        int[][] source = toIntegerArray(list);

        System.out.println("\n########### Converted int array ##############\n");
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                System.out.print(source[i][j]+" ");
            }
        }

        System.out.println("\n"+ Arrays.deepToString(source));
    }

    private static int[][] toIntegerArray(ArrayList<Integer> arrayList) {
        int[][] block = new int[arrayList.size() / 2][2];
        if ((arrayList.size() % 2) == 0) {

           int count = arrayList.size()/2;

            Iterator<Integer> integerIterator = arrayList.iterator();

            for (int i = 0; i < count; i++) {
                block[i][0] = integerIterator.next();
                block[i][1] = integerIterator.next();
            }

        } else {
            System.out.println("it is not a even size");
        }

        return block;
    }

    private static ArrayList<Integer> toArrayList(int[][] integerArray) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < integerArray.length; i++) {
            for (int j = 0; j < integerArray[i].length; j++) {
                integerArrayList.add(integerArray[i][j]);
            }
        }
        return integerArrayList;
    }
}
