import java.io.*;
import java.util.*;

public class Main{
    private static HashMap<String,HashSet<String>> map;
    private static boolean[][] visited;
    private static boolean[][] lights;
    private static boolean isValidCoordinate(int x, int y){
        return x >= 0 && x < visited.length && y >= 0 && y < visited.length;
    }
    private static boolean hasVisitedNeighbor(int x, int y){
        return (isValidCoordinate(x+1,y) && visited[x+1][y]) || (isValidCoordinate(x-1,y) && visited[x-1][y]) || (isValidCoordinate(x,y+1) && visited[x][y+1]) || (isValidCoordinate(x,y-1) && visited[x][y-1]);
    }
    private static void dfs(int x, int y){
        if(x < 0 || x >= visited.length || y < 0 || y >= visited.length || visited[x][y] || !lights[x][y]){
            return;
        }
        visited[x][y] = true;
        String room = x + " " + y;
        if(map.containsKey(room)){
            HashSet<String> lightRooms = map.get(room);
            for(String i: lightRooms){
                StringTokenizer convert = new StringTokenizer(i);
                int lightRoomX = Integer.parseInt(convert.nextToken());
                int lightRoomY = Integer.parseInt(convert.nextToken());
                lights[lightRoomX][lightRoomY] = true;
                if(hasVisitedNeighbor(lightRoomX,lightRoomY)){
                    dfs(lightRoomX,lightRoomY);
                }
            }
        }
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new boolean[N][N];
        lights = new boolean[N][N];
        lights[0][0] = true;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            String switchRoom = x + " " + y;
            String lightRoom = a + " " + b;
            if(map.containsKey(switchRoom)){
                map.get(switchRoom).add(lightRoom);
            } else {
                HashSet<String> temp = new HashSet<>();
                temp.add(lightRoom);
                map.put(switchRoom,temp);
            }
        }
        dfs(0,0);
        int lit = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(lights[i][j]){
                    lit++;
                }
            }
        }
        out.println(lit);
        f.close();
        out.close();
    }
}
