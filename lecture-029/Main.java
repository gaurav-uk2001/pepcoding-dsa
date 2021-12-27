import java.io.*;
import java.util.*;

public class Main {

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<String>(); // base case
            base.add(""); // empty string
            return base;
        }

        ArrayList<String> myAns = new ArrayList<String>();

        if (sc + 1 <= dc) { // can move right
            for (int jump = 1; sc + jump <= dc; jump++) { // try all possible jumps loops till we reach destination
                ArrayList<String> hCall = getMazePathsWithJumps(sr, sc + jump, dr, dc); // right jumps
                for (String s : hCall) { // for each right jump
                    myAns.add("h" + jump + s); // add it to the answer with jump count
                }
            }
        }

        if (sr + 1 <= dr) { // can move down
            for (int jump = 1; sr + jump <= dr; jump++) { // try all possible jumps loops till we reach destination
                ArrayList<String> vCall = getMazePathsWithJumps(sr + jump, sc, dr, dc); // down jumps
                for (String s : vCall) { // for each down jump
                    myAns.add("v" + jump + s); // add it to the answer with jump count
                }
            }
        }

        if (sr + 1 <= dr && sc + 1 <= dc) { // can move diagonally (down and right)
            for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) { // try all possible jumps loops till we
                                                                             // reach destination
                ArrayList<String> dCall = getMazePathsWithJumps(sr + jump, sc + jump, dr, dc); // diagonal jumps
                for (String s : dCall) { // for each diagonal jump
                    myAns.add("d" + jump + s); // add it to the answer with jump count
                }
            }
        }
        return myAns; // return the answer
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> myAns = getMazePathsWithJumps(0, 0, n - 1, m - 1);
        System.out.println(myAns);
        scn.close();
    }

}