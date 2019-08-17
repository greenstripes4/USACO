import java.io.*;
import java.util.*;
/*
O(n log n)
3
100 101 102 103 488
100 200 300 101 102
103 102 101 488 100
3
200 202 204 206 208
123 234 345 456 321
100 200 300 400 444
0
*/

public class Main{
    public static String arrayToString(int[] list) {
        StringBuilder sb = new StringBuilder();
        for (Integer s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while (!((input = f.readLine()).equals("0"))){
            int numFrosh = Integer.parseInt(input);
            HashMap<String, Integer> courses = new HashMap<>();
            for (int i = 0; i < numFrosh; i++) {
                int[] courseCombination = new int[5];
                StringTokenizer st = new StringTokenizer(f.readLine());
                for (int c = 0; c < 5; c++) {
                    courseCombination[c] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(courseCombination);
                String uniqueKey = arrayToString(courseCombination);
                if (courses.containsKey(uniqueKey)) {
                    courses.put(uniqueKey, courses.get(uniqueKey) + 1);
                }
                else {
                    courses.put(uniqueKey, 1);
                }
            }
            int mostPopularValue = 0;
            for (int x : courses.values()) {
                mostPopularValue = Math.max(mostPopularValue, x);
            }
            int countFrosh = 0;
            for (int x : courses.values()) {
                if (x == mostPopularValue) {
                    countFrosh += x;
                }
            }
            out.println(countFrosh);
        }
        f.close();
        out.close();
    }
}
