import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. 
     * Calculate the hourglass sum for every hourglass in arr, then return the maximum hourglass sum.
     * 
     * An hourglass looks like this:
     * a b c
     *   d
     * e f g
     * @param arr - a 6x6 array 
     * @return
     */
    static int maxHourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        int numColumns = arr[0].length;
        int numRows = arr[0].length;
        for (int leftColumn = 0; leftColumn < numColumns - 2; leftColumn++) {
            for (int topRow = 0; topRow < numRows - 2; topRow++) {
                int sum = calculateHourglassSum(arr, leftColumn, topRow);
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    static int calculateHourglassSum(int[][] arr, int leftColumn, int topRow) {
        int sum = 0;
        sum += arr[topRow][leftColumn];
        sum += arr[topRow][leftColumn+1];
        sum += arr[topRow][leftColumn+2];
        sum += arr[topRow+1][leftColumn+1];
        sum += arr[topRow+2][leftColumn];
        sum += arr[topRow+2][leftColumn+1];
        sum += arr[topRow+2][leftColumn+2];

        return sum;
    }

    static int countingValleys(int n, String s) {
        int prevAltitude = 0;
        int altitude = 0;
        int valleys = 0;

        for (int i = 0; i < n; i++) {
            prevAltitude = altitude;
            if (s.charAt(i) == 'U') {
                altitude += 1;
                if (prevAltitude == -1)
                    valleys += 1;
            } else {
                altitude -= 1;
            }
        }

        return valleys;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Difference difference = new Difference(a);
            difference.computeDifference();
            System.out.println("Max difference of " + difference.printElements() + " is:");
            System.out.println(difference.maximumDifference);
            System.out.println();
        }
        
        scanner.close();
    }
}