/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        HashMap<String,HashSet<String>> mtas = new HashMap<>();
        while((input = f.next()).charAt(0) != '*'){
            String city = f.next();
            mtas.put(city,new HashSet<>());
            int members = f.nextInt();
            for(int i = 0; i < members; i++) {
                mtas.get(city).add(f.next());
            }
        }
        String smpt;
        while((smpt = f.next()).charAt(0) != '*'){
            String[] sender = smpt.split("@");
            String nextRecipient;
            ArrayList<String[]> recipients = new ArrayList<>();
            while((nextRecipient = f.next()).charAt(0) != '*'){
                String[] next = nextRecipient.split("@");
                boolean add = true;
                for(String[] i: recipients){
                    if(Arrays.equals(i,next)){
                        add = false;
                        break;
                    }
                }
                if(add) {
                    recipients.add(next);
                }
            }
            f.nextLine();
            String data = "";
            String temp=f.nextLine();
            while (!"*".equals(temp)) {
                data=data+"     "+temp+"\n";
                temp=f.nextLine();
            }
            /*
            int lineNumber = 1;
            StringBuilder data = new StringBuilder();
            String line = f.nextLine();
            while(line.charAt(0) != '*'){
                if(lineNumber > 1){
                    data.append("\n");
                }
                data.append("     ");
                data.append(line);
                lineNumber++;
            }
            */
            if(!mtas.get(sender[1]).contains(sender[0]))
                continue;
            while(recipients.size() != 0){
                ArrayList<String[]> mtaRecipients = new ArrayList<>();
                ArrayList<String[]> nextRecipients = new ArrayList<>();
                String nextmta = recipients.get(0)[1];
                for(String[] i: recipients){
                    if(i[1].equals(nextmta)){
                        mtaRecipients.add(i);
                    } else {
                        nextRecipients.add(i);
                    }
                }
                recipients = nextRecipients;
                out.println("Connection between " + sender[1] + " and " + nextmta);
                out.println("     HELO " + sender[1]);
                if(mtas.containsKey(sender[1])){
                    out.println("     250");
                } else {
                    out.println("     550");
                }
                out.println("     MAIL FROM:<" + sender[0]+ "@" +sender[1] + ">");
                if(mtas.containsKey(sender[1]) && mtas.get(sender[1]).contains(sender[0])){
                    out.println("     250");
                } else {
                    out.println("     550");
                }
                boolean validRecipient = false;
                for(String[] i: mtaRecipients){
                    out.println("     RCPT TO:<" + i[0] + "@" + i[1] + ">");
                    if(mtas.containsKey(i[1]) && mtas.get(i[1]).contains(i[0])){
                        out.println("     250");
                        validRecipient = true;
                    } else {
                        out.println("     550");
                    }
                }
                if(validRecipient) {
                    out.println("     DATA");
                    out.println("     354");
                    out.print(data);
                    out.println("     .");
                    out.println("     250");
                }
                out.println("     QUIT");
                out.println("     221");
            }
        }
        out.close();
        f.close();
    }
}
