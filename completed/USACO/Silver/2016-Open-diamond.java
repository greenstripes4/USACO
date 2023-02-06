import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[N];
        for(int i = 0; i < N; i++) {
            diamonds[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(diamonds);
        int[] smallerValidDiamonds = new int[N];
        int[] largerValidDiamonds = new int[N];
        for(int i = 0; i < N; i++) {
            int smallestInd = i;
            while(smallestInd >= 0 && diamonds[i]-diamonds[smallestInd] <= K) {
                smallestInd--;
            }
            smallestInd++;
            smallerValidDiamonds[i] = Math.max(i-smallestInd+1, i > 0 ? smallerValidDiamonds[i-1] : i-smallestInd+1);
            int largestInd = i;
            while(largestInd < N && diamonds[largestInd]-diamonds[i] <= K) {
                largestInd++;
            }
            largestInd--;
            largerValidDiamonds[i] = Math.max(largestInd-i+1, i < N-1 ? largerValidDiamonds[i+1] : largestInd-i+1);
        }
        int maxDiamonds = 0;
        for(int i = 0; i < N-1; i++) {
            maxDiamonds = Math.max(maxDiamonds,smallerValidDiamonds[i]+largerValidDiamonds[i+1]);
        }
        out.println(maxDiamonds);
        out.close();
        f.close();
        out.close();
    }
}
