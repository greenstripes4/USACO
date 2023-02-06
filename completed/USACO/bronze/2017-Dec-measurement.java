import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static boolean equals(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        if(arr1.size() != arr2.size()){
            return false;
        }
        for(int i = 0; i < arr1.size(); i++){
            if(arr1.get(i) != arr2.get(i)){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> getMax(int[] entries){
        int max = 0;
        for(int i: entries){
            if(i > max){
                max = i;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < entries.length; i++){
            if(entries[i] >= max){
                arr.add(i);
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        int N = Integer.parseInt(f.readLine());
        int currentBest = -1;
        int count = 0;
        int[][] log = new int[N][3];
        for(int i = 0; i < N; i++){
            int[] temp = new int[3];
            StringTokenizer st = new StringTokenizer(f.readLine());
            int day = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            int cow;
            if(c.equals("Bessie")){
                cow = 0;
            } else if(c.equals("Elsie")){
                cow = 1;
            } else{
                cow = 2;
            }
            char[] value = st.nextToken().toCharArray();
            int a = value[0] == '+' ? Character.getNumericValue(value[1]) : 0 - Character.getNumericValue(value[1]);
            temp = new int[]{day,cow,a};
            log[i] = temp;
        }
        Arrays.sort(log, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1:-1;
            }
        });
        int[] amounts = {7,7,7};
        ArrayList<Integer> current = new ArrayList<>();
        for(int i = 0; i < N; i++){
            current.add(i);
        }
        for(int[] i: log){
            amounts[i[1]] += i[2];
            ArrayList<Integer> newCurrent = getMax(amounts);
            if(!equals(current,newCurrent)){
                count++;
                current = newCurrent;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
