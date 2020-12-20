import java.io.*;
import java.util.*;

public class Main{
    private static boolean solve(ArrayList<String[]> constraints, int ind, StringBuilder sb, ArrayList<Character> banned, PrintWriter out) {
        if(ind == constraints.size()) {
            char[] temp = sb.toString().toCharArray();
            Arrays.sort(temp);
            out.println("Toppings: " + new String(temp));
            return true;
        }
        String[] temp = constraints.get(ind);
        for(String i: temp) {
            char request = i.charAt(0);
            char topping = i.charAt(1);
            boolean removeAdded = false;
            boolean removeBanned = false;
            if(request == '+') {
                if(banned.contains(topping)) {
                    continue;
                } else {
                    sb.append(topping);
                    removeAdded = true;
                }
            } else {
                if(sb.indexOf(topping+"") >= 0) {
                    continue;
                } else {
                    banned.add(topping);
                    removeBanned = true;
                }
            }
            if(solve(constraints, ind+1, sb, banned, out)) {
                return true;
            }
            if(removeAdded) {
                sb.deleteCharAt(sb.length()-1);
            }
            if(removeBanned) {
                banned.remove(banned.size()-1);
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            ArrayList<String[]> constraints = new ArrayList<>();
            char[] arr = input.toCharArray();
            String[] first = new String[arr.length/2];
            for(int i = 0; i < arr.length-1; i += 2) {
                first[i/2] = arr[i]+""+arr[i+1];
            }
            Arrays.sort(first, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return t1.compareTo(s);
                }
            });
            constraints.add(first);
            while(!(input = f.readLine()).equals(".")) {
                char[] temp = input.toCharArray();
                String[] next = new String[temp.length/2];
                for(int i = 0; i < temp.length-1; i += 2) {
                    next[i/2] = temp[i]+""+temp[i+1];
                }
                Arrays.sort(next, new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return t1.compareTo(s);
                    }
                });
                constraints.add(next);
            }
            Collections.sort(constraints, new Comparator<String[]>() {
                @Override
                public int compare(String[] strings, String[] t1) {
                    return strings.length-t1.length;
                }
            });
            if(!solve(constraints, 0, new StringBuilder(), new ArrayList<>(), out)) {
                out.println("No pizza can satisfy these requests.");
            }
        }
        f.close();
        out.close();
    }
}
