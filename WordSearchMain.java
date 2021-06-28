// Brian Zen Limbert
// CS 145
// Assignment 1
// 03/20/2021

import java.util.*;
import java.io.*;

   public class WordSearchMain{
      public static void main(String[] args) throws FileNotFoundException{
         boolean generated = false;
         Scanner console = new Scanner(System.in);
         String choice;
         WordSearch search = new WordSearch();
         do{
            printIntro();
            choice = console.next();
            if(choice.equals("g")){
               System.out.println("Enter words line by line until you are finished at which point type a single \"q\"");
               String tok = console.next();
               ArrayList<String> wordGrid = new ArrayList<String>();
               do{
                  wordGrid.add(tok);
                  tok = console.next();
               }
               while(!tok.equals("q"));
                  String[] words = new String[wordGrid.size()];
                  wordGrid.toArray(words);
                  search.generate(words);
                  generated = true;
               }
               else if(choice.equals("p")){
                  if(generated){
                     print(search);
                  }
               }
               else if(choice.equals("s")){
                  if(generated){
                     showSolution(search);
                  }
               }
         }
         while(!choice.equals("q"));
   }
   public static void printIntro(){
      System.out.println("Welcome to my word search generator.");
      System.out.println("This programs will allow you to generate your own word search puzzle");
      System.out.println("Please select and option: ");
      System.out.println("Generate a new word search (g)");
      System.out.println("Print out your word search (p)");
      System.out.println("Show the solution to your word search(s)");      
      System.out.println("Quit the program (q)");
   }
   public static void print(WordSearch ws){
      System.out.println(ws);
   }
   public static void showSolution(WordSearch ws){
      System.out.println(ws.toSolution());
   }
}