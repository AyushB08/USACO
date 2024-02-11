//PROBLEM LINK: http://www.usaco.org/index.php?page=viewproblem2&cpid=712 
import java.io.*;
import java.util.*;

public class WhyDidTheCowsCrossTheRoadII {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("circlecross.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("circlecross.out"));

        String s = sc.next();
        //System.out.println(s);
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        ArrayList<String[]> pairs = new ArrayList<String[]>();

        for (int i = 0; i<26; i++) {
            String letter = arr[i];
            //System.out.println(letter);
            int first = s.indexOf(letter);
            //System.out.println(first);
            int second = s.indexOf(letter, first+1);
            //System.out.println(second);
            ArrayList<String> lettersFound = new ArrayList<String>();
            for (int a = first+1; a<second; a++) {
                //System.out.println("I: " + i);
                //System.out.println("A: " + s.charAt(a) + "");
                String alpha = s.charAt(a) + "";
                if (lettersFound.indexOf(alpha) != -1) {
                    lettersFound.remove(lettersFound.indexOf(alpha));
                } else {
                    lettersFound.add(alpha);
                }
            }
            for (int b = 0; b<lettersFound.size(); b++) {
                String[] cross = new String[2];
                cross[0] = letter;
                cross[1] = lettersFound.get(b);
                pairs.add(cross);
            }

        }
        /*
        for (int i = 0; i<pairs.size(); i++) {
            System.out.println(Arrays.toString(pairs.get(i)));
        }
        System.out.println(pairs.size());
        */
        bw.write(pairs.size()/2 + "");
        bw.close();


    }
}
