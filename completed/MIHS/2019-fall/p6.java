import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("itoa.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("itoa.out")));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int target = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken(),cur);
            out.println(Integer.toString(val,target).toUpperCase());
        }
        f.close();
        out.close();
    }
}
