import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            char[][] maze = new char[rows][cols];
            for(int i = 0; i < rows; i++) {
                StringBuilder sb = new StringBuilder(f.readLine());
                while(sb.length() < cols) {
                    sb.append(' ');
                }
                maze[i] = sb.toString().toCharArray();
            }
            StringTokenizer initial = new StringTokenizer(f.readLine());
            int r = Integer.parseInt(initial.nextToken())-1;
            int c = Integer.parseInt(initial.nextToken())-1;
            int[][] orientation = {{-1,0},{0,1},{1,0},{0,-1}};
            int ind = 0;
            boolean quit = false;
            while(!quit) {
                String instructions = f.readLine();
                for(char i: instructions.toCharArray()) {
                    if(i == 'R') {
                        ind = (ind+1)%4;
                    } else if(i == 'L') {
                        ind = (ind+3)%4;
                    } else if(i == 'F') {
                        int nextR = r+orientation[ind][0];
                        int nextC = c+orientation[ind][1];
                        if(nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && maze[nextR][nextC] == ' ') {
                            r = nextR;
                            c = nextC;
                        }
                    } else if(i == 'Q') {
                        out.print((r+1) + " " + (c+1) + " ");
                        switch (ind) {
                            case 0:
                                out.println('N');
                                break;
                            case 1:
                                out.println('E');
                                break;
                            case 2:
                                out.println('S');
                                break;
                            default:
                                out.println('W');
                                break;
                        }
                        quit = true;
                        break;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
