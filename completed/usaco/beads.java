/*
ID: strongh2
LANG: JAVA
PROG: beads
TASK: beads
 */

import java.io.*;

public class beads {
    public static int number_of_beads_taken(String[] blist){
        int beads = 0;
        String ccolor = null;
        int currentpos = 0;
        String opp = null;
        while(currentpos<blist.length){
            if(ccolor == null || !(blist[currentpos].equals(opp))){
                beads++;
                currentpos++;
            }
            else{
                break;
            }
            if(!(blist[currentpos-1].equals("w"))){
                ccolor = blist[currentpos-1];
                if(ccolor.equals("b")){
                    opp = "r";
                }else{
                    opp = "b";
                }
            }
        }
        ccolor = null;
        currentpos = blist.length-1;
        opp = null;
        while(currentpos>=0){
            if(ccolor == null || !(blist[currentpos].equals(opp))){
                beads++;
                currentpos--;
            }
            else{
                break;
            }
            if(!(blist[currentpos+1].equals("w"))){
                ccolor = blist[currentpos+1];
                if(ccolor.equals("b")){
                    opp = "r";
                }else{
                    opp = "b";
                }
            }
        }
        return Math.min(beads,blist.length);
    }


    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int num_beads = Integer.parseInt(f.readLine());
        String beads = f.readLine();
        f.close();
        int[] b = new int[num_beads];
        for(int i = 0; i<num_beads; i++){
            String split_here = beads.substring(i)+beads.substring(0,i);
            String[] lst_version = split_here.split("");
            b[i] = number_of_beads_taken(lst_version);
        }
        int current_max = 0;
        for(int j: b){
            if(j>current_max){
                current_max = j;
            }
        }
        out.println(current_max);
        out.close();
    }
}
