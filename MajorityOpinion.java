
import java.util.*;
import java.io.*;


public class MajorityOpinion {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("test2.in"));

        int cases = sc.nextInt();

        for (int i = 0; i<cases; i++) {
            ArrayList<Integer> answer = new ArrayList<Integer>();
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int b = 0; b<length; b++) {
                arr[b] = sc.nextInt();
            }
            if (arr.length >= 3) {
                searchThree(arr, answer);
            } else {
                if (arr[0] == arr[1]) {
                    answer.add(arr[0]);
                }
            }

            Collections.sort(answer);
            for (int b = 0; b<answer.size(); b++) {
                if (b == answer.size()-1) {
                    System.out.print(answer.get(b));
                } else {
                    System.out.print(answer.get(b) + " ");
                }
            }
            if (answer.size() == 0) {
                System.out.print(-1);
            }
            if (i != cases-1) {
                System.out.println();
            }

            //System.out.println(answer);



        }
    }

    public static void searchThree(int[] arr, ArrayList<Integer> a) {

        for (int i = 0; i<=arr.length-3; i++) {
            if (arr[i] == arr[i+1] ||  arr[i+2] == arr[i+1]) {
                if (a.indexOf(arr[i+1]) == -1) {
                    a.add(arr[i+1]);
                }
            }
            else if (arr[i] == arr[i+2]) {
                if (a.indexOf(arr[i]) == -1) {
                    a.add(arr[i]);
                }
            }
        }
    }
    /*
    public static void searchPair(int[] arr, int first, int last, ArrayList<Integer> a) {
        if (last-first == 2) {
            if (arr[first] == arr[first+1] || arr[first+1] == arr[last]) {
                if (a.indexOf(arr[first+1]) == -1) {
                    a.add(arr[first+1]);
                }

            }
            else if (arr[first] == arr[last]) {
                if (a.indexOf(arr[first]) == -1) {
                    a.add(arr[first]);
                }
            }
        }
        else if (last - first == 1) {
            if (arr[first] == arr[first+1]) {
                if (a.indexOf(arr[first]) == -1) {
                    a.add(arr[first]);
                }

            }
        } else {
            int mid = ((last - first )/ 2) + first;
            searchPair(arr, first, mid, a);
            searchPair(arr, mid, last, a);
        }

    }

     */
}
