import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Boolean> sockCounter = new HashMap<Integer, Boolean>();
        
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int sockId = ar[i];
            if (sockCounter.containsKey(sockId)) {
                if (sockCounter.get(sockId)) {
                    sockCounter.put(sockId, false);
                    pairs += 1;
                } else {
                    sockCounter.put(sockId, true);
                }
            } else {
                sockCounter.put(sockId, true);
            }
        }

        return pairs;
    }

    /**
     * You're playing a new game that starts with consecutively numbered clouds. Some of the clouds are safe to jump on and others are not.
     * You can jump on any safe clouds having a number that is equal to the number of the current cloud plus 1 or 2. 
     * You must avoid the unsafe clouds. Determine the minimum number of jumps it will take to jump from the starting postion (clouds[0]) to the last cloud (clouds[n-1]).
     * It is always possible to win the game.
     * @param clouds - an array of consecutively numbered clouds. cloud[n] == 0 is safe, cloud[n] == 1 is unsafe
     * @return the minimum number of moves required to traverse the clouds safely
     */
    static int jumpingOnClouds(int[] clouds) {
        // I always know that clouds[0] and clouds[n-1] are safe
        int i = 0;

        int minJumps = 0;
        while (i < clouds.length - 2) {
            if (clouds[i + 2] == 0)
                i += 2;
            else
                i += 1;
            
            minJumps++;
        }

        if (i != clouds.length - 1)
            minJumps++;

        return minJumps;
    }

    /**
     * Print a single integer denoting the number of letter a's in the first 'n' letters of the 
     * infinite string created by repeating 's' infinitely many times.
     * @param s - the string to be repeated
     * @param n - the limited number of characters to account for in the repeated string
     * @return
     */
    static long repeatedString(String s, long n) {
        long result = 0;
        long occurrencesInString = 0; 

        for (char c: s.toCharArray()) {
            if (c == 'a')
                occurrencesInString += 1;
        }

        long multiplier = n / s.length();
        int remainder = (int) (n % s.length());
        result = occurrencesInString * multiplier;

        for (char c: s.substring(0, remainder).toCharArray()) {
            if (c == 'a')
                result += 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        
        while (scanner.hasNext()){
            String chars = scanner.nextLine();
            long n = Long.parseLong(scanner.nextLine());

            System.out.println("'a' occurs in the first " + n + " characters of the infinitely repeated string '" + chars + "' " + repeatedString(chars, n) + " times.");
        }

        scanner.close();
    }
}