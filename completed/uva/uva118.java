import java.io.*;
import java.util.*;

public class Main{
    private static char getOrientation(char orientation, char turn){
        if(orientation == 'N' && turn == 'L') {
            return 'W';
        } else if(orientation == 'N' && turn == 'R') {
            return 'E';
        } else if(orientation == 'S' && turn == 'L') {
            return 'E';
        } else if(orientation == 'S' && turn == 'R') {
            return 'W';
        } else if(orientation == 'E' && turn == 'L') {
            return 'N';
        } else if(orientation == 'E' && turn == 'R') {
            return 'S';
        } else if(orientation == 'W' && turn == 'L') {
            return 'S';
        }
        return 'N';
    }
    private static void dfs(int m, int n, int x, int y, char orientation, char[] instructions, int ind, HashSet<String> lost, PrintWriter out){
        if(ind == instructions.length) {
            out.println(x + " " + y + " " + orientation);
            return;
        }
        int nextX = x;
        int nextY = y;
        if(instructions[ind] == 'F' && orientation == 'N') {
            nextY++;
        } else if(instructions[ind] == 'F' && orientation == 'S') {
            nextY--;
        } else if(instructions[ind] == 'F' && orientation == 'E') {
            nextX++;
        } else if(instructions[ind] == 'F' && orientation == 'W') {
            nextX--;
        } else {
            orientation = getOrientation(orientation,instructions[ind]);
        }
        if(nextX < 0 || nextX > m || nextY < 0 || nextY > n) {
            if(lost.contains(x + " " + y)) {
                nextX = x;
                nextY = y;
            } else {
                out.println(x + " " + y + " " + orientation + " LOST");
                lost.add(x + " " + y);
                return;
            }
        }
        dfs(m,n,nextX,nextY,orientation,instructions,ind+1,lost,out);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer upperRightCorner = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(upperRightCorner.nextToken());
        int n = Integer.parseInt(upperRightCorner.nextToken());
        HashSet<String> lost = new HashSet<>();
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer robot = new StringTokenizer(input);
            int x = Integer.parseInt(robot.nextToken());
            int y = Integer.parseInt(robot.nextToken());
            char orientation = robot.nextToken().charAt(0);
            char[] instructions = f.readLine().toCharArray();
            dfs(m,n,x,y,orientation,instructions,0,lost,out);
        }
        f.close();
        out.close();
    }
}
