/*
ID: strongh2
LANG: JAVA
PROG: beads
TASK: beads
 */

import java.io.*;
public class beads_new {
    public static int number_of_beads_taken(char[] blist){
        int beads = 0;
        char l_color_limit = 'w';
        char r_color_limit = 'w';

        for(int i=0; i<blist.length; i++) {
            if(blist[i] != 'w') {
                l_color_limit = blist[i]=='r'? 'b': 'r';
                break;
            }
        }

        for(int i=blist.length-1; i>=0; i--) {
            if(blist[i] != 'w') {
                r_color_limit = blist[i]=='r'? 'b': 'r';
                break;
            }
        }

        for(int i=0; i<blist.length && blist[i] != l_color_limit; i++) {
            beads++;
        }

        for(int i=blist.length-1; i>=0 && blist[i] != r_color_limit && beads<blist.length; i--) {
            beads++;
        }

        return beads;
    }


    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int num_beads = Integer.parseInt(f.readLine());
        String beads = f.readLine();
        f.close();
        int max = 0;
        for(int i = 0; i<num_beads; i++){
            String split_here = beads.substring(i)+beads.substring(0,i);
            char[] lst_version = split_here.toCharArray();
            max= Math.max(max, number_of_beads_taken(lst_version));
        }
        out.println(max);
        out.close();
    }
}
