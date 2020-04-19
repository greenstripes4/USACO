import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(input);
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char[][][] dungeon = new char[L][R][C];
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    dungeon[i][j] = f.readLine().toCharArray();
                }
                f.readLine();
            }
            int[] root = new int[3];
            boolean foundStart = false;
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    for(int k = 0; k < C; k++){
                        if(dungeon[i][j][k] == 'S'){
                            root[0] = i;
                            root[1] = j;
                            root[2] = k;
                            foundStart = true;
                            break;
                        }
                    }
                    if(foundStart){
                        break;
                    }
                }
                if(foundStart){
                    break;
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            HashSet<String> seen = new HashSet<>();
            boolean foundEnd = false;
            int steps = 0;
            int[][] directions = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] next = queue.poll();
                    if(dungeon[next[0]][next[1]][next[2]] == 'E'){
                        foundEnd = true;
                        break;
                    }
                    for(int[] j: directions){
                        int[] transformation = {next[0]+j[0],next[1]+j[1],next[2]+j[2]};
                        if(transformation[0] >= 0 && transformation[1] >= 0 && transformation[2] >= 0 && transformation[0] < L && transformation[1] < R && transformation[2] < C){
                            String asString = transformation[0] + " " + transformation[1] + " " + transformation[2];
                            if(!seen.contains(asString) && dungeon[transformation[0]][transformation[1]][transformation[2]] != '#'){
                                queue.add(transformation);
                                seen.add(asString);
                            }
                        }
                    }
                }
                if(foundEnd){
                    break;
                }
                steps++;
            }
            out.println(foundEnd ? "Escaped in " + steps + " minute(s)." : "Trapped!");
        }
        f.close();
        out.close();
    }
}
