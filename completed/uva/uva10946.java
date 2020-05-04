import java.io.*;
import java.util.*;

class Pothole implements Comparable<Pothole>{
    char name;
    int size;
    public Pothole(char name, int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public int compareTo(Pothole o){
        if(this.size == o.size){
            return this.name - o.name;
        }
        return o.size - this.size;
    }
}

public class Main{
    private static int size;
    private static void dfs(char[][] island, char tar, int r, int c){
        if(r < 0 || c < 0 || r >= island.length || c >= island[0].length || island[r][c] != tar) {
            return;
        }
        size++;
        island[r][c] = '.';
        dfs(island,tar,r+1,c);
        dfs(island,tar,r-1,c);
        dfs(island,tar,r,c+1);
        dfs(island,tar,r,c-1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 1;
        while(!(input = f.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(input);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char[][] island = new char[x][y];
            for(int i = 0; i < x; i++){
                island[i] = f.readLine().toCharArray();
            }
            ArrayList<Pothole> allPotholes = new ArrayList<>();
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(island[i][j] != '.'){
                        size = 0;
                        char name = island[i][j];
                        dfs(island,island[i][j],i,j);
                        allPotholes.add(new Pothole(name,size));
                    }
                }
            }
            Collections.sort(allPotholes);
            out.println("Problem " + testCase + ":");
            for(Pothole i: allPotholes){
                out.println(i.name + " " + i.size);
            }
            testCase++;
        }
        f.close();
        out.close();
    }
}
