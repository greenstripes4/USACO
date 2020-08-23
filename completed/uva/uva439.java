import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String source = st.nextToken();
            int sourceR = source.charAt(0)-'a';
            int sourceC = Character.getNumericValue(source.charAt(1))-1;
            String destination = st.nextToken();
            int destinationR = destination.charAt(0)-'a';
            int destinationC = Character.getNumericValue(destination.charAt(1))-1;
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();
            queueR.offer(sourceR);
            queueC.offer(sourceC);
            int knightMoves = 0;
            boolean found = false;
            int[][] directions = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
            boolean[][] seen = new boolean[8][8];
            while(!queueR.isEmpty()) {
                int size = queueR.size();
                for(int i = 0; i < size; i++) {
                    int tempR = queueR.poll();
                    int tempC = queueC.poll();
                    if(tempR == destinationR && tempC == destinationC) {
                        found = true;
                        break;
                    }
                    for(int[] j: directions) {
                        int nextR = tempR+j[0];
                        int nextC = tempC+j[1];
                        if(nextR < 0 || nextR >= 8 || nextC < 0 || nextC >= 8 || seen[nextR][nextC]) {
                            continue;
                        }
                        queueR.offer(nextR);
                        queueC.offer(nextC);
                        seen[nextR][nextC] = true;
                    }
                }
                if(found) {
                    break;
                }
                knightMoves++;
            }
            out.println("To get from " + source + " to " + destination + " takes " + knightMoves + " knight moves.");
        }
        f.close();
        out.close();
    }
}
