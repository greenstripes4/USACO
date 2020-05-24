import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            if(i > 0){
                out.println();
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> left = new LinkedList<>();
            Queue<int[]> right = new LinkedList<>();
            for(int j = 0; j < m; j++){
                StringTokenizer car = new StringTokenizer(f.readLine());
                int time = Integer.parseInt(car.nextToken());
                if(car.nextToken().equals("left")){
                    left.add(new int[]{j,time});
                } else {
                    right.add(new int[]{j,time});
                }
            }
            boolean leftBank = true;
            int time = 0;
            int[] res = new int[m];
            while(!left.isEmpty() || !right.isEmpty()){
                if(leftBank){
                    boolean loaded = false;
                    for(int j = 0; j < n; j++){
                        if(left.isEmpty() || left.peek()[1] > time){
                            break;
                        }
                        loaded = true;
                        res[left.poll()[0]] = time+t;
                    }
                    if(loaded || !right.isEmpty() && right.peek()[1] <= time){
                        time += t;
                        leftBank = false;
                    } else if(left.isEmpty() && !right.isEmpty() || !right.isEmpty() && right.peek()[1] < left.peek()[1]) {
                        time = right.peek()[1] + t;
                        leftBank = false;
                    } else if(!left.isEmpty()) {
                        time = left.peek()[1];
                    }
                } else {
                    boolean loaded = false;
                    for(int j = 0; j < n; j++){
                        if(right.isEmpty() || right.peek()[1] > time){
                            break;
                        }
                        loaded = true;
                        res[right.poll()[0]] = time+t;
                    }
                    if(loaded || !left.isEmpty() && left.peek()[1] <= time){
                        time += t;
                        leftBank = true;
                    } else if(right.isEmpty() || !left.isEmpty() && left.peek()[1] < right.peek()[1]) {
                        time = left.peek()[1] + t;
                        leftBank = true;
                    } else {
                        time = right.peek()[1];
                    }
                }
            }
            for(int j: res){
                out.println(j);
            }
        }
        f.close();
        out.close();
    }
}
