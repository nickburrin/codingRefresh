import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = Files.newBufferedReader(Paths.get("input.txt"));
        
        int n = Integer.parseInt(scanner.readLine());

        int[] ar = new int[n];

        String[] arItems = scanner.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        System.out.println(sockMerchant(n, ar));

        scanner.close();
    }
}