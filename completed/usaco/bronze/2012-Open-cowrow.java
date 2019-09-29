import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowrow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrow.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList<Integer> cows = new ArrayList<>();
        HashSet<Integer> breeds = new HashSet<>();
        for(int i = 0; i < N; i++){
            int cowId = Integer.parseInt(f.readLine());
            cows.add(cowId);
            breeds.add(cowId);
        }
        breeds.add(-1);
        int max = 0;
        for(int j: breeds){
            ArrayList<Integer> cowsCopy = new ArrayList<>();
            for(int k: cows){
                if(k != j) {
                    cowsCopy.add(k);
                }
            }
            //cowsCopy.removeIf(integer -> (integer == j));
            int m = 0;
            int count = 0;
            int cur = -1;
            for(int l: cowsCopy) {
                if (l == cur || cur == -1) {
                    cur = l;
                    count++;
                } else {
                    if (count > m) {
                        m = count;
                    }
                    count = 1;
                    cur = l;
                }
            }
            if(count > max){
                max = count;
            }
            if(m > max){
                max = m;
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
