import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer b1 = new StringTokenizer(f.readLine());
        StringTokenizer b2 = new StringTokenizer(f.readLine());
        StringTokenizer t = new StringTokenizer(f.readLine());
        int[] billboard1 = {Integer.parseInt(b1.nextToken()),Integer.parseInt(b1.nextToken()),Integer.parseInt(b1.nextToken()),Integer.parseInt(b1.nextToken())};
        int[] billboard2 = {Integer.parseInt(b2.nextToken()),Integer.parseInt(b2.nextToken()),Integer.parseInt(b2.nextToken()),Integer.parseInt(b2.nextToken())};
        int[] truck = {Integer.parseInt(t.nextToken()),Integer.parseInt(t.nextToken()),Integer.parseInt(t.nextToken()),Integer.parseInt(t.nextToken())};
        boolean[][] arr = new boolean[2001][2001];
        for(int i = billboard1[0]; i < billboard1[2]; i++){
            for(int j = billboard1[1]; j < billboard1[3]; j++){
                arr[i+1000][j+1000] = true;
            }
        }
        for(int i = billboard2[0]; i < billboard2[2]; i++){
            for(int j = billboard2[1]; j < billboard2[3]; j++){
                arr[i+1000][j+1000] = true;
            }
        }
        for(int i = truck[0]; i < truck[2]; i++){
            for(int j = truck[1]; j < truck[3]; j++){
                arr[i+1000][j+1000] = false;
            }
        }
        int count = 0;
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(arr[i][j]){
                    count++;
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
