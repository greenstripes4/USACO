import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearch(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size();
        while(low+1 < high){
            int mid = (low+high)/2;
            if(arr.get(mid) > tar){
                high = mid;
            } else {
                low = mid;
            }
        }
        return arr.get(low+1);
    }
    private static boolean isWraparound(int n){
        int size = 0;
        int orig = n;
        while(n != 0) {
            size++;
            n /= 10;
        }
        int[] arr = new int[size];
        int ind = size-1;
        while(orig != 0){
            arr[ind] = orig%10;
            orig /= 10;
            ind--;
        }
        HashSet<Integer> seen = new HashSet<>();
        int pointer = 0;
        while(seen.size() < size && !seen.contains(arr[pointer])){
            seen.add(arr[pointer]);
            pointer = (pointer+arr[pointer])%size;
        }
        return seen.size() == size && pointer == 0;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Integer> wraparoundNumbers = new ArrayList<>();
        for(int i = 1; i <= 9999999; i++) {
            if(isWraparound(i)){
                wraparoundNumbers.add(i);
            }
        }
        int testcase = 1;
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0){
                break;
            }
            int number = binarySearch(wraparoundNumbers,n);
            out.println("Case " + testcase + ": " + number);
            testcase++;
        }
        f.close();
        out.close();
    }
}
