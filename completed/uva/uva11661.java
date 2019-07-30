import java.io.*;
/*
O(n)
2
RD
5
..Z..
10
.R......D.
10
.R..Z...D.
10
...D..R...
25
..D...R.RR...DD...D.R...R
0
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int num = Integer.parseInt(input);
            char[] stores = f.readLine().toCharArray();
            int last_index = -1;
            int min_index_diff = -1;
            char prev = '.';
            for(int s = 0; s <stores.length; s++){
                if(stores[s] == 'Z'){
                    min_index_diff = 0;
                    break;
                }
                if((prev == 'R' && stores[s] == 'D') || (prev == 'D' && stores[s] == 'R')){
                    int current_space = s-last_index;
                    if(current_space < min_index_diff || min_index_diff == -1){
                        min_index_diff = current_space;
                    }
                }
                if(stores[s] != '.'){
                    last_index = s;
                    prev = stores[s];
                }
            }
            System.out.println(min_index_diff);
        }
    }
}
