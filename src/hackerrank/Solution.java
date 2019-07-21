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

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            int[] clouds = new int[n];

            String[] arItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                clouds[i] = Integer.parseInt(arItems[i]);
            }

            System.out.println("Minimum number of moves is: " + jumpingOnClouds(clouds));
        }

        scanner.close();
    }
}