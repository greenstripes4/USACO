import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("greetings.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("greetings.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int B = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] bessie = new int[1000001];
        int[] elsie = new int[1000001];
        int current = 0;
        int ind = 1;
        int bSize = 0;
        int eSize = 0;
        for(int i = 0; i < B; i++){
            StringTokenizer movement = new StringTokenizer(f.readLine());
            int steps = Integer.parseInt(movement.nextToken());
            String direction = movement.nextToken();
            int eachStep = (direction.equals("R")) ? 1:-1;
            for(int j = 0; j < steps; j++){
                current += eachStep;
                bessie[ind] = current;
                ind++;
                bSize++;
            }
        }
        current = 0;
        ind = 1;
        for(int i = 0; i < E; i++){
            StringTokenizer movement = new StringTokenizer(f.readLine());
            int steps = Integer.parseInt(movement.nextToken());
            String direction = movement.nextToken();
            int eachStep = (direction.equals("R")) ? 1:-1;
            for(int j = 0; j < steps; j++){
                current += eachStep;
                elsie[ind] = current;
                ind++;
                eSize++;
            }
        }
        int max = Math.max(bSize,eSize);
        int lastBEl = bessie[bSize];
        while(bSize < max){
            bessie[bSize] = lastBEl;
            bSize++;
        }
        int lastEEl = elsie[eSize];
        while(eSize < max){
            elsie[eSize] = lastEEl;
            eSize++;
        }
        int count = 0;
        boolean meet = false;
        for(int i = 0; i < max; i++){
            if(bessie[i] == elsie[i] && meet){
                count++;
                meet = false;
            } else if(bessie[i] != elsie[i]){
                meet = true;
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
