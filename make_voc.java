// Haotian He collaborated with Jonggun Park
// 1261169
// LING 570 Homework 1
// Instructor: Professor Fei Xia
// 09/30/2013

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class make_voc {

   public static Map<String, Integer> tally = new HashMap<String, Integer>();
   
   public static void main(String[] args) throws IOException, FileNotFoundException {
      
      BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
      String line = null;
      
      String token = "";
      while((line = file.readLine()) != null) {
         tally = wordCount(line, tally);
      }
      
      List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>();
      entryList.addAll(tally.entrySet());
      Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
         public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            return b.getValue() - a.getValue();
         }
      }
      );
      for (Map.Entry<String, Integer> a: entryList) {
         System.out.println(a.getKey() + "\t" + a.getValue());
      }
   }
   
   public static Map<String, Integer> wordCount(String line, Map<String,Integer> tally) {
      Scanner input = new Scanner(line);
      String word = "";
      while (input.hasNext()) {
         if(input.hasNext()) {
            word = input.next();
            if (tally.get(word) != null) {
               tally.put(word, tally.get(word) + 1);
            } else {
               tally.put(word, 1);
            }
         }
      }
      return tally;
   }
   
}
