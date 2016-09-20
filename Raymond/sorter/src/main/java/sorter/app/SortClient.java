package sorter.app;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Random;

/**
 * Created by Ray on 19/09/16.
 */
public class SortClient {
    public static void main(String[] args)  throws RemoteException {
        SortClient client = new SortClient();
        client.sort();
    }

    public static void sort() throws RemoteException {
        int[] data = generateRandomIntegers(5);
        try {
            ISorter stub = (ISorter) LocateRegistry.getRegistry().lookup("sorter1");
            int[] output = stub.sortInts(data);
            for (int i = 0; i < data.length; i++) {
                System.out.println("Number " + output[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomIntegers(int length){
        int[] randomIntegers = new int[length];

        for (int i = 0; i < randomIntegers.length; i++){
            Random r = new Random();
            int n = r.nextInt(100);
            randomIntegers[i] = n;
            System.out.println(i + " " + n);

        }
        return randomIntegers;
    }

    public int[][] spliceList(int[] list) {
        int arraySize = list.length;
        int[][] lists = {{0},{0}};


        return lists;
    }
   /* Integer[] list = generateRandom(1000);
    Comparable[][] lists = spliceList(list);
        for(int i=0;i< lists.size();i++)
        {
            ISorter sorter = (ISorter) Naming.lookup(“sorter”+i);
         Integer[] result = sorter.sort(lists.get(i));
         join(result);
     }*/
}
