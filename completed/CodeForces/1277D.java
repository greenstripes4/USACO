import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            ArrayList<Integer>[] occ = new ArrayList[4];
            for(int i = 0; i < 4; i++) {
                occ[i] = new ArrayList<>();
            }
            HashMap<String, Integer> map = new HashMap<>();
            boolean[] invalid = new boolean[n];
            for(int i = 0; i < n; i++) {
                char[] arr = f.readLine().toCharArray();
                if(arr[0] == '0' && arr[arr.length-1] == '0') {
                    occ[0].add(i+1);
                } else if(arr[0] == '1' && arr[arr.length-1] == '1') {
                    occ[1].add(i+1);
                } else if(arr[0] == '0' && arr[arr.length-1] == '1') {
                    occ[2].add(i+1);
                } else {
                    occ[3].add(i+1);
                }
                String temp = new String(arr);
                if(map.containsKey(temp)) {
                    invalid[map.get(temp)] = invalid[i] = true;
                }
                for(int j = 0; j < arr.length/2; j++) {
                    char ttemp = arr[j];
                    arr[j] = arr[arr.length-j-1];
                    arr[arr.length-j-1] = ttemp;
                }
                map.put(new String(arr), i);
            }
            if(occ[0].size() > 0 && occ[1].size() > 0 && occ[2].size() == 0 && occ[3].size() == 0) {
                out.println(-1);
            } else {
                int diff = Math.abs(occ[2].size()-occ[3].size())/2;
                out.println(diff);
                if(occ[2].size() < occ[3].size()) {
                    int i = 0;
                    while(diff > 0) {
                        if(!invalid[occ[3].get(i)-1]) {
                            out.print(occ[3].get(i) + " ");
                            diff--;
                        }
                        i++;
                    }
                    out.println();
                } else {
                    int i = 0;
                    while(diff > 0) {
                        if(!invalid[occ[2].get(i)-1]) {
                            out.print(occ[2].get(i) + " ");
                            diff--;
                        }
                        i++;
                    }
                    out.println();
                }
            }
        }
        f.close();
        out.close();
    }
}
