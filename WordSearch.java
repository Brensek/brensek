// Brian Zen Limbert
// CS 145
// Assignment 1
// 03/20/2021

import java.util.*;
import java.io.*;

public class WordSearch{
  private char[][] grid;
   private boolean[][] sol;
   private String[] userWords;

   public void generate(String[] w){
      for(int i = 0 ; i < w.length ; i++){
         w[i] = w[i].toLowerCase();
      }
      this.userWords = w;
      char[][] wordChars = setupGrid();
      for(int i = 0 ; i < wordChars.length ; i++){
         placeWord(wordChars, i);
      }
         fillGrid();
   }
   public String toString(){
      String result = "";
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            result += " " + grid[i][x] + " ";
         }
         result += "\r\n";
      }
      return result;
   }
   public String toSolution(){
      String result = "";
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            if(sol[i][x]){
               result += " " + grid[i][x] + " ";
            }
            else{
               result += " X ";
            }
         }
         result += "\r\n";
      }
      return result;
   }
   private void placeWord(char[][] wordChars, int iter){
      Random rand = new Random();
      int direction = rand.nextInt(3);
      int[] pos = {0,0};
      if(direction == 0){
         boolean placed = false;
         int attempts = 0;
         while(!placed && attempts < 100){
            pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            placed = true;
            for(int u = 0 ; u < wordChars[iter].length ; u++){
               if(grid[pos[0] + u][pos[1]] != '\u0000' && grid[pos[0] + u][pos[1]] != wordChars[iter][u]){
                  placed = false;
                  break;
               }
            }
            attempts++;
         }
         if(placed){
            for(int x = 0 ; x < wordChars[iter].length ; x++){
               grid[pos[0]][pos[1]] = wordChars[iter][x];
               sol[pos[0]][pos[1]] = true;
               pos[0]++;
            }
         }
      }
      else if(direction == 1){
         boolean placed = false;
         int attempts = 0;
         while(!placed && attempts < 100){
            pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            placed = true;
            for(int u = 0 ; u < wordChars[iter].length ; u++){
               if(grid[pos[0]][pos[1] + u] != '\u0000' && grid[pos[0]][pos[1] + u] != wordChars[iter][u]){
                  placed = false;
                  break;
               }
            }
            attempts++;
         }
         if(placed){
            for(int x = 0 ; x < wordChars[iter].length ; x++){
               grid[pos[0]][pos[1]] = wordChars[iter][x];
               sol[pos[0]][pos[1]] = true;
               pos[1]++;
            }
         }
      }
      else if(direction == 2){
         boolean placed = false;
         int attempts = 0;
         while(!placed && attempts < 100){
            pos[0] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            pos[1] = rand.nextInt((grid.length-1) - wordChars[iter].length);
            placed = true;
            for(int u = 0 ; u < wordChars[iter].length ; u++){
               if(grid[pos[0] + u][pos[1] + u] != '\u0000' && grid[pos[0] + u][pos[1] + u] != wordChars[iter][u]){
                  placed = false;
                  break;
               }
            }
            attempts++;
         }
         if(placed){
            for(int x = 0 ; x < wordChars[iter].length ; x++){
               grid[pos[0]][pos[1]] = wordChars[iter][x];
               sol[pos[0]][pos[1]] = true;
               pos[1]++;
               pos[0]++;
            }
         }
      }
   }
   private char[][] setupGrid(){
      char[][] wordChars = new char[userWords.length][];
      int longest = 8;
      for(int i = 0 ; i < userWords.length ; i++){
         wordChars[i] = userWords[i].toCharArray();
         if(wordChars[i].length > longest){
            longest = wordChars[i].length;
         }
      }
      if(userWords.length > longest){
         longest = userWords.length;
      }
      this.grid = new char[longest + 4][longest + 4];
      this.sol = new boolean[longest + 4][longest + 4];
      return wordChars;
   }
   private void fillGrid(){
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            Random rand = new Random();
            if(grid[i][x] == '\u0000'){
               grid[i][x] = (char)(rand.nextInt(26)+97);
            }
         }
      }
   }
}