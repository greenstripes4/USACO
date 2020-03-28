/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class Book implements Comparable<Book>{
    String title;
    String author;
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    @Override
    public int compareTo(Book ot){
        if(author.compareTo(ot.author) == 0){
            return title.compareTo(ot.title);
        }
        return author.compareTo(ot.author);
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        ArrayList<Book> books = new ArrayList<>();
        String book;
        while(!(book = f.readLine()).equals("END")){
            String[] bookComponents = book.split(" by ");
            books.add(new Book(bookComponents[0],bookComponents[1]));
        }
        Collections.sort(books);
        ArrayList<Book> borrowed = new ArrayList<>();
        ArrayList<Book> returned = new ArrayList<>();
        String instruction;
        while(!(instruction = f.readLine()).equals("END")){
            String[] instructionComponents = {instruction.substring(0,6),instruction.substring(Math.min(instruction.length(),7))};
            if(instructionComponents[0].equals("BORROW")){
                for(int i = 0; i < books.size(); i++){
                    if(books.get(i).title.equals(instructionComponents[1])){
                        borrowed.add(books.get(i));
                        books.remove(i);
                        break;
                    }
                }
            } else if(instructionComponents[0].equals("RETURN")){
                for(int i = 0; i < borrowed.size(); i++){
                    if(borrowed.get(i).title.equals(instructionComponents[1])){
                        returned.add(borrowed.get(i));
                        borrowed.remove(i);
                        break;
                    }
                }
            } else {
                Collections.sort(returned);
                while(!returned.isEmpty()){
                    Book next = returned.get(0);
                    returned.remove(0);
                    if(books.isEmpty() || books.get(0).compareTo(next) > 0) {
                        out.println("Put " + next.title + " first");
                        books.add(0, next);
                    } else if(books.get(books.size()-1).compareTo(next) < 0) {
                        out.println("Put " + next.title + " after " + books.get(books.size()-1).title);
                        books.add(next);
                    } else {
                        for (int i = 0; i < books.size()-1; i++) {
                            if (books.get(i).compareTo(next) < 0 && books.get(i+1).compareTo(next) > 0){
                                out.println("Put " + next.title + " after " + books.get(i).title);
                                books.add(i+1,next);
                                break;
                            }
                        }
                    }
                }
                out.println("END");
            }
        }
        f.close();
        out.close();
    }
}
