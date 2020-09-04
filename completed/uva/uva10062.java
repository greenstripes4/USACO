import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcases = 0;
        while((input = f.readLine()) != null) {
            if(testcases > 0) {
                out.println();
            }
            int[] frequencies = new int[128];
            for(char i: input.toCharArray()) {
                frequencies[i]++;
            }
            ArrayList<int[]> map = new ArrayList<>();
            for(int i = 0; i < 128; i++) {
                if(frequencies[i] > 0) {
                    map.add(new int[]{i,frequencies[i]});
                }
            }
            Collections.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[1] == t1[1]) {
                        return t1[0]-ints[0];
                    }
                    return ints[1]-t1[1];
                }
            });
            for(int[] i: map) {
                out.println(i[0] + " " + i[1]);
            }
            testcases++;
        }
        f.close();
        out.close();
    }
}
