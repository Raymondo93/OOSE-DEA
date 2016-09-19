package Sorter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortClient {

    private Integer[] sortedArray = new Integer[0];

    public static void main(String[] args){
        SortClient client = new SortClient();
        client.sort();
    }

    public void sort(){
        int[] randomInts = generateRandomIntegers(1000);
        Integer[][] lists = spliceList(randomInts);
        try {
            for (int i = 1; i<lists.length; i++ ) {
                ISorter sorter = (ISorter) LocateRegistry.getRegistry().lookup("sorter"+ i);
                Integer[] result = sorter.sortIntegers(lists[i]);
                join(result);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    private void join(Integer[] result) {
        int length1 = sortedArray.length;
        int length2 = result.length;

        Integer[] integers = new Integer[length1 + length2];
        System.arraycopy(sortedArray, 0, integers, 0, sortedArray.length);
        System.arraycopy(result, 0, integers, length1, result.length);

        sortedArray = integers;
    }

    private Integer[][] spliceList(int[] randomInts) {

        Integer[][] lists = new Integer[3][randomInts.length];

        for (int i = 0; i < randomInts.length; i++) {
            if(randomInts[i] <= 500)
                lists[1][i] = randomInts[i];
            else
                lists[2][i] = randomInts[i];
        }

        return lists;
    }

    private int[] generateRandomIntegers(int amount) {
        int[] randomIntList = new int[amount];

        Random randomGenerator = new Random();
        for (int i =0; i< amount; i++){
            int randomInt = randomGenerator.nextInt(1000);
            randomIntList[i] = randomInt;
        }

        return randomIntList;
    }
}
