import java.io.*;
import java.util.*;

public class Main {
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int temp1 = heights[stack.pop()];
                int temp2 = stack.isEmpty() ? i : i-stack.peek()-1;
                max = Math.max(max, temp1*temp2);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int temp1 = heights[stack.pop()];
            int temp2 = stack.isEmpty() ? heights.length : heights.length-stack.peek()-1;
            max = Math.max(max, temp1*temp2);
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] forest = new char[n][];
        for(int i = 0; i < n; i++) {
            forest[i] = f.readLine().toCharArray();
        }
        int[][] rows = new int[n+1][m];
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j < m; j++) {
                rows[i][j] = forest[i][j] == '.' ? rows[i+1][j]+1 : 0;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, largestRectangleArea(rows[i]));
        }
        out.println(max);
        f.close();
        out.close();
    }
}
