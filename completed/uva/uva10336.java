import java.io.*;
import java.util.*;

class Language implements Comparable<Language>{
    char name;
    int size;
    public Language(char name, int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public int compareTo(Language o){
        if(this.size == o.size){
            return this.name - o.name;
        }
        return o.size - this.size;
    }
}

public class Main{
    private static void dfs(char[][] island, char tar, int r, int c){
        if(r < 0 || c < 0 || r >= island.length || c >= island[0].length || island[r][c] != tar) {
            return;
        }
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
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char[][] island = new char[x][y];
            for(int j = 0; j < x; j++){
                island[j] = f.readLine().toCharArray();
            }
            ArrayList<Language> allLanguages = new ArrayList<>();
            for(int j = 0; j < x; j++){
                for(int k = 0; k < y; k++){
                    if(island[j][k] != '.'){
                        char name = island[j][k];
                        dfs(island,name,j,k);
                        boolean found = false;
                        for(Language l: allLanguages){
                            if(l.name == name){
                                l.size++;
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            allLanguages.add(new Language(name,1));
                        }
                    }
                }
            }
            Collections.sort(allLanguages);
            out.println("World #" + (i+1));
            for(Language j: allLanguages){
                out.println(j.name + ": " + j.size);
            }
        }
        f.close();
        out.close();
    }
}
