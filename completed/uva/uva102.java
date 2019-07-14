import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            TreeMap<String, Integer> map = new TreeMap<>();
            int[][] boxes = new int[3][3];
            StringTokenizer st = new StringTokenizer(input);
            ArrayList<Integer> c = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    boxes[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        if(i == j || j == k || i == k){
                            continue;
                        }
                        int count = 0;
                        for(int m = 0; m < 3; m++){
                            if(m != i){
                                count += boxes[0][m];
                            }
                        }
                        for(int n = 0; n < 3; n++){
                            if(n != j){
                                count += boxes[1][n];
                            }
                        }
                        for(int o = 0; o < 3; o++){
                            if(o != k){
                                count += boxes[2][o];
                            }
                        }
                        String combo = "";
                        if(i == 0 && j == 1 && k == 2){
                            combo = "BGC";
                        }
                        else if(i == 1 && j == 0 && k == 2){
                            combo = "GBC";
                        }
                        else if(i == 2 && j == 0 && k == 1){
                            combo = "CBG";
                        }
                        else if(i == 0 && j == 2 && k == 1){
                            combo = "BCG";
                        }
                        else if(i == 1 && j == 2 && k == 0){
                            combo = "GCB";
                        }
                        else if(i == 2 && j == 1 && k == 0){
                            combo = "CGB";
                        }
                        map.put(combo,count);
                        c.add(count);
                    }
                }
            }
            Collections.sort(c);
            String com = "";
            int min = c.get(0);
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                //System.out.println(entry.getValue());
                //System.out.println(c.get(0));
                int x = c.get(0);
                int y = entry.getValue();
                if(x == y){
                    com = entry.getKey();
                    break;
                }
            }
            System.out.println(com + " " + min);
        }

    }
}
