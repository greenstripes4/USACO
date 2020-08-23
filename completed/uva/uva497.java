import java.io.*;
import java.util.*;

public class Main{
    private static int getPileIndex(ArrayList<Integer> sequence, ArrayList<Integer> pileTops, int lowerBound) {
        int low = 0;
        int high = pileTops.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(sequence.get(pileTops.get(mid)) >= lowerBound) {
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
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            ArrayList<Integer> sequence = new ArrayList<>();
            ArrayList<Integer> pileTops = new ArrayList<>();
            ArrayList<Integer> currentLeftPileTopIndicies = new ArrayList<>();
            String input;
            while ((input = f.readLine()) != null && input.length() > 0) {
                int next = Integer.parseInt(input);
                int pileIndex = getPileIndex(sequence, pileTops, next);
                int leftPileIndex;
                if (pileIndex < 0) {
                    leftPileIndex = pileTops.size() - 1;
                    pileTops.add(sequence.size());
                } else {
                    leftPileIndex = pileIndex - 1;
                    pileTops.set(pileIndex, sequence.size());
                }
                sequence.add(next);
                currentLeftPileTopIndicies.add(leftPileIndex < 0 ? -1 : pileTops.get(leftPileIndex));
            }
            out.println("Max hits: " + pileTops.size());
            int lastPileTop = pileTops.get(pileTops.size() - 1);
            ArrayList<Integer> subsequence = new ArrayList<>();
            while (lastPileTop >= 0) {
                subsequence.add(0, sequence.get(lastPileTop));
                lastPileTop = currentLeftPileTopIndicies.get(lastPileTop);
            }
            for (int i : subsequence) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
