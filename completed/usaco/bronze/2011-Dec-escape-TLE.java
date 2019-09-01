import java.io.*;
import java.util.*;

public class Main{
    public static ArrayList<ArrayList<Integer>> allSubarrays(int[] arr, int ind){
        if(ind == 0){
            ArrayList<ArrayList<Integer>> last = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[0]);
            last.add(temp);
            return last;
        }
        ArrayList<ArrayList<Integer>> current = allSubarrays(arr, ind-1);
        ArrayList<ArrayList<Integer>> iter = new ArrayList<>();
        for(ArrayList<Integer> k: current){
            ArrayList<Integer> add = new ArrayList<>();
            for(int l: k){
                add.add(l);
            }
            iter.add(add);
        }
        for(int i = 0; i < iter.size(); i++){
            ArrayList<Integer> t = new ArrayList<>();
            for(int j: iter.get(i)){
                t.add(j);
            }
            t.add(arr[ind]);
            current.add(t);
        }
        ArrayList<Integer> c = new ArrayList<>();
        c.add(arr[ind]);
        current.add(c);
        return current;
    }
    public static boolean carries(ArrayList<Integer> arr, int maxLength){
        ArrayList<int[]> digits = new ArrayList<>();
        for(int i: arr){
            int[] d = new int[maxLength];
            for(int j = 0; j < maxLength; j++){
                d[j] = i%10;
                i /= 10;
            }
            digits.add(d);
        }
        int[] digitSums = new int[digits.get(0).length];
        for(int[] k: digits){
            for(int l = 0; l < k.length; l++){
                digitSums[l] += k[l];
            }
        }
        for(int m: digitSums){
            if(m >= 10){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("escape.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
        int numCows = Integer.parseInt(f.readLine());
        int[] cows = new int[numCows];
        for(int i = 0; i < numCows; i++){
            cows[i] = Integer.parseInt(f.readLine());
        }
        ArrayList<ArrayList<Integer>> groups = allSubarrays(cows,numCows-1);
        int maxCows = 0;
        for(ArrayList<Integer> j: groups){
            int maxLength = 0;
            for(int k: j){
                int size = 0;
                while(k != 0){
                    size++;
                    k /= 10;
                }
                if(size > maxLength){
                    maxLength = size;
                }
            }
            if(!carries(j,maxLength) && j.size() > maxCows){
                maxCows = j.size();
            }
        }
        out.println(maxCows);
        out.close();
        f.close();
    }
}
