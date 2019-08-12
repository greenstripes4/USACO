import java.io.*;
import java.util.*;
/*
O(n^2)
10
tiny
2short4me
very_long_file_name
shorter
size-1
size2
size3
much_longer_name
12345678.123
mid_size_name
12
Weaser
Alfalfa
Stimey
Buckwheat
Porky
Joe
Darla
Cotton
Butch
Froggy
Mrs_Crabapple
P.D.
19
Mr._French
Jody
Buffy
Sissy
Keith
Danny
Lori
Chris
Shirley
Marsha
Jan
Cindy
Carol
Mike
Greg
Peter
Bobby
Alice
Ruben
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while((input = f.readLine()) != null){
            out.println("------------------------------------------------------------");
            int numFileNames = Integer.parseInt(input);
            String[] files = new String[numFileNames];
            int maxLength = 0;
            for(int i = 0; i < numFileNames; i++){
                files[i] = f.readLine();
                if(files[i].length() > maxLength){
                    maxLength = files[i].length();
                }
            }
            Arrays.sort(files);
            int numCols = 62/(maxLength+2);
            int numRows = (int) Math.ceil((double) numFileNames/numCols);
            for(int j = 0; j < numRows; j++){
                for(int k = 0; k < numCols; k++){
                    if(k*numRows+j < files.length){
                        out.print(files[k*numRows+j]);
                        if(k != numCols-1) {
                            for (int l = 0; l < maxLength + 2 - files[k*numRows+j].length(); l++) {
                                out.print(' ');
                            }
                        } else {
                            for (int l = 0; l < maxLength - files[k*numRows+j].length(); l++) {
                                out.print(' ');
                            }
                        }
                    }
                }
                out.println();
            }
        }
        out.close();
        f.close();
    }
}
