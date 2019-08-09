import java.io.*;
import java.util.*;
/*
O(n log n)
is
the
of
and
as
a
but
::
Descent of Man
The Ascent of Man
The Old Man and The Sea
A Portrait of The Artist As a Young Man
A Man is a Man but Bubblesort IS A DOG
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        ArrayList<String> ignore = new ArrayList<>();
        while(!((input = f.readLine()).equals("::"))){
            ignore.add(input);
        }
        ArrayList<String[]> possibleKeywords = new ArrayList<>();
        String title;
        while(!((title = f.readLine()) == null)){
            title = title.toLowerCase();
            String[] words = title.split(" ");
            for(String word: words){
                if(!ignore.contains(word)){
                    possibleKeywords.add(new String[]{word,title});
                }
            }
        }
        Collections.sort(possibleKeywords, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        ArrayList<String> repeats = new ArrayList<>();
        for(String[] key: possibleKeywords){
            String[] output = key[1].split(" ");
            for(int i = 0; i < output.length; i++){
                String[] temp = output.clone();
                temp[i] = temp[i].toUpperCase();
                if(output[i].equals(key[0]) && !repeats.contains(String.join(" ", temp))){
                    output[i] = output[i].toUpperCase();
                    repeats.add(String.join(" ",output));
                    break;
                }
            }
            System.out.println(String.join(" ",output));
        }
    }
}
