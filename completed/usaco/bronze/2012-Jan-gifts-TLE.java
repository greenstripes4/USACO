import java.io.*;
import java.util.*;
/*
    // Target folder to store test cases
    static String problem = "gifts";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

    // First line config
    static boolean hasPrefixLine = true;
    static Field[] prefixSchema = {Field.FollowCount, Field.General};
    static int prefixNumbers = 2;
    static boolean prefixIsSorted = false;
    static long[][] prefixBoundaries = { { 1, 1000 }, { 1, 1000000000 } };

    // Following line config
    static int numberPerLine = 2;
    static int numberLines = 100;
    static boolean numberIsSorted = false;
    static long[][] numberBoundaries = { { 0, 1000000000 }, { 0, 1000000000 } };
*/
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gifts.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gifts.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] gifts = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer g = new StringTokenizer(f.readLine());
            gifts[i][0] = Integer.parseInt(g.nextToken());
            gifts[i][1] = Integer.parseInt(g.nextToken());
        }
        int max = 0;
        for(int j = 0; j < gifts.length; j++){
            int [][] temp = new int[gifts.length][];
            for(int i = 0; i < gifts.length; i++)
                temp[i] = gifts [i].clone();
            temp[j][0] /= 2;
            Arrays.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] + o1[1] == o2[0] + o2[1]){
                        return 0;
                    }
                    return o1[0] + o1[1] > o2[0] + o2[1] ? 1:-1;
                }
            });
            int count = 0;
            int sum = 0;
            int ind = 0;
            while(sum <= B && ind < gifts.length){
                count++;
                sum += temp[ind][0] + temp[ind][1];
                ind++;
            }
            if(count > max){
                max = count;
            }
        }
        out.println(max-1);
        out.close();
        f.close();
    }
}
