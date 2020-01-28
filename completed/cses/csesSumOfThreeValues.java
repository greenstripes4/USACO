/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
        if(arr.length < 3){
            out.println("IMPOSSIBLE");
        } else {
            Arrays.sort(arr);
            boolean valid = false;
            for(int i = 0; i < arr.length; i++){
                int t = target - arr[i];
                int pointer1 = i + 1;
                int pointer2 = arr.length-1;
                while(pointer1 < pointer2 && arr[pointer1] + arr[pointer2] != t){
                    if(arr[pointer1] + arr[pointer2] > t){
                        pointer2--;
                    } else {
                        pointer1++;
                    }
                }
                if(pointer1 < pointer2){
                    int first = map.get(arr[i]).get(0) + 1;
                    map.get(arr[i]).remove(0);
                    int second = map.get(arr[pointer1]).get(0) + 1;
                    map.get(arr[pointer1]).remove(0);
                    int third = map.get(arr[pointer2]).get(0) + 1;
                    map.get(arr[pointer2]).remove(0);
                    out.println(first + " " + second + " " + third);
                    valid = true;
                    break;
                }
            }
            if(!valid){
                out.println("IMPOSSIBLE");
            }
        }
        out.close();
        f.close();
    }
}
