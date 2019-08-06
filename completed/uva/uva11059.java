import java.io.*;
import java.util.StringTokenizer;
//O(n^2)
//1
//-1
//
//2
//-3 -7
//
//4
//-3 4 -7 5
//
//18
//10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10
//
//3
//2 4 -3
//
//5
//2 5 -1 2 -1


public class Main{
    public static long findMaximumProduct(int[] arr){
        long max = 0;
        for(int i = 0; i < arr.length; i++) {
            long product = 1;
            for (int j = i; j < arr.length; j++) {
                product = product * arr[j];
                if(product > max){
                    max = product;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int count = 1;
        while((input = f.readLine()) != null){
            int numElements = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] elements = new int[numElements];
            for(int i = 0; i < numElements; i++){
                elements[i] = Integer.parseInt(st.nextToken());
            }
            long max = findMaximumProduct(elements);
            System.out.println("Case #" + count + ": "+ "The maximum product is " + max + ".");
            System.out.println();
            count++;
            f.readLine();
        }
    }
}
