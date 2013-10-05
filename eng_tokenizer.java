// Haotian He
// 1261169
// LING 570 Homework 1
// Instructor: Professor Fei Xia
// 09/30/2013

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class eng_tokenizer {

   private static final String alwaysSplit = "[?!()\";/\\|`]";
   private static final String punctuation = "[,./\\?!'\"`;:%()|]";
   private static final String clitics = "'s|'re|'ve|'m|'ll|n't|'d|'S|'RE|'VE|'M|'LL|N'T|'D";
   private static final List<String> abbreviation = 
      Arrays.asList("N.V.", "Ph.D.", "M.S.", "U.S.A.", "P.R.C.", "U.K.", "M.A.", "M.P.A.", "M.B.A",
                    "N.B.A.", "a.m.", "p.m.", "A.D.", "B.C.", "W.A.", "U.W.", "B.A.", "B.S.", 
                    "D.D.S.", "D.M.D.", "E.S.T.", "P.S.T.", "G.M.T.", "D.C.");

   public static void main(String[] args) throws IOException, FileNotFoundException {
      
      BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
      String line = null;
      
      while ((line = file.readLine()) != null) {
         line = tokenizer(line + " ");
         System.out.println(line);
      }
   }
   
   public static String tokenizer(String line) {
   
      line = line.replaceAll("(" + alwaysSplit + ")", " $1 ");
      line = line.replaceAll("(" + clitics + ")", " $1");
      line = line.replaceAll("(" + clitics + ")([^A-Za-z0-9])", "$1 $2");
      line = line.replaceAll("([$])([0-9]+)", "$1 $2");
      line = line.replaceAll("([%])(" + punctuation + ")", "$1 $2");
      line = line.replaceAll("([0-9]+)([.,][^0-9])", "$1 $2");
      line = line.replaceAll("([A-Za-z])([-])([A-Za-z])", "$1 $2 $3");
      line = line.replaceAll("(" + punctuation + ")(" + punctuation +")", "$1 $2");
      
      String[] words = line.trim().split("\\s");
      for (String word : words) {
         if (!abbreviation.contains(word)) {
            line = line.replaceAll("([^.\\s][A-Za-z])([.,])", "$1 $2");         
         }
      }
      line = line.trim().replaceAll("\\s+", " ");
      return line;
   }

}