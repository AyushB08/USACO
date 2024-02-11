//PROBLEM LINK: http://www.usaco.org/index.php?page=viewproblem2&cpid=988
import java.util.*;
import java.io.*;
public class PhotoShoot {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("photo.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("photo.out"));

        int n = sc.nextInt();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> cows = new ArrayList<Integer>();
        for (int i = 0; i<n-1; i++) {
            b.add(sc.nextInt());
            cows.add(i+1);
            if (i == n-2) {
                cows.add(i+2);
            }
        }

        //System.out.println(b);
        //System.out.println(cows);
        int first = 0;
        for (int i = 0; i<cows.size(); i++) {
            ArrayList<Integer> cowCopy = (ArrayList<Integer>)cows.clone();
            first = cows.get(i);
            cowCopy.remove(cowCopy.indexOf(first));
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            permutation.add(first);
            //System.out.println("FIRST: " + first);

            for (int c = 0; c<cows.size()-1; c++) {

                int next = b.get(c) - permutation.get(c);
                if (cowCopy.indexOf(next) == -1) {
                    break;
                } else {
                    permutation.add(next);
                    cowCopy.remove(cowCopy.indexOf(next));
                }

            }
            if (permutation.size() == n) {
                for (int m = 0; m<permutation.size(); m++) {

                    if (m == permutation.size()-1) {
                        bw.write(permutation.get(m) + "");
                    } else {
                        bw.write(permutation.get(m) + " ");
                    }

                }
                bw.close();
                break;
            }
        }

    }
}
