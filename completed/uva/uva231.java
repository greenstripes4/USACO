import java.io.*;
import java.util.*;

public class Main{
    private static int getPileIndex(ArrayList<Integer> sequence, ArrayList<Integer> pileTops, int lowerBound) {
        int low = 0;
        int high = pileTops.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(sequence.get(pileTops.get(mid)) < lowerBound) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        int first;
        while((first = f.nextInt()) != -1) {
            if(t > 1) {
                out.println();
            }
            ArrayList<Integer> sequence = new ArrayList<>();
            ArrayList<Integer> pileTops = new ArrayList<>();
            pileTops.add(sequence.size());
            sequence.add(first);
            int next;
            while ((next = f.nextInt()) != -1) {
                int pileIndex = getPileIndex(sequence, pileTops, next);
                if (pileIndex < 0) {
                    pileTops.add(sequence.size());
                } else {
                    pileTops.set(pileIndex, sequence.size());
                }
                sequence.add(next);
            }
            out.println("Test #" + t + ":");
            out.println("  maximum possible interceptions: " + pileTops.size());
            t++;
        }
        f.close();
        out.close();
    }
}
