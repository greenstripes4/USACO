import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int teleportStart = Integer.parseInt(st.nextToken());
        int teleportEnd = Integer.parseInt(st.nextToken());
        int[] destination = {Math.min(start,end),Math.max(start,end)};
        int[] teleport = {Math.min(teleportStart,teleportEnd),Math.max(teleportStart,teleportEnd)};
        int distanceUsingTeleporter = Math.abs(destination[0]-teleport[0]) + Math.abs(destination[1]-teleport[1]);
        int directDistance = destination[1] - destination[0];
        out.println(Math.min(directDistance,distanceUsingTeleporter));
        f.close();
        out.close();
    }
}
