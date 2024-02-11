//PROBLEM LINK: http://www.usaco.org/index.php?page=viewproblem2&cpid=1372

import java.util.*;
import java.io.*;



public class Cannonball {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("test.in"));

        int length = sc.nextInt();
        int currentNum = sc.nextInt();
        int value = 1;
        int targetsBroken = 0;
        int totalTargetsLeft = 0;
        boolean goingPositive = true;


        int[][] numLine = new int[length][2];

        for (int i = 0; i<length; i++) {
            numLine[i][0] = sc.nextInt();
            numLine[i][1] = sc.nextInt();
            if (numLine[i][0] == 1) {
                totalTargetsLeft += 1;
            }
            //System.out.println(Arrays.toString(numLine[i]));
            //System.out.println(totalTargetsLeft);
        }
        //System.out.println(currentNum);
        if (numLine[currentNum-1][0] == 0) {
            goingPositive = false;
            value += numLine[currentNum-1][1];
        }

        if (numLine[currentNum-1][0] == 1) {

            if (numLine[currentNum-1][1] <= value) {

                numLine[currentNum-1][0] = 2;
                targetsBroken += 1;
                totalTargetsLeft -= 1;
            }
        }
        int turn = 0;
        while (totalTargetsLeft > 0) {
            turn += 1;
            if (turn == 9*10*10*10*10*10*10) {
                break;
            }
            //System.out.println("turn "  + turn + " coord " + currentNum + " value " +  value  + " target " + targetsBroken);
            //turn += 1;
            if (goingPositive) {
                currentNum += value;
            } else {
                currentNum -= value;
            }

            if (currentNum > length || currentNum <= 0) {
                //System.out.println("broke here");
                break;
            } else {
                if (numLine[currentNum-1][0] == 0) {
                    if (goingPositive) {
                        goingPositive = false;
                    } else {
                        goingPositive = true;
                    }
                    value += numLine[currentNum-1][1];
                }
                else if (numLine[currentNum-1][0] == 1) {
                    if (value >= numLine[currentNum-1][1]) {
                        targetsBroken +=1 ;
                        totalTargetsLeft -= 1;
                        numLine[currentNum-1][0] = 2;
                    }
                }
            }

        }
        System.out.println(targetsBroken);
    }

}
