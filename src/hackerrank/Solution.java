import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int[] sockCounter = new int[100];
        for (int i = 0; i < n; i++){
            sockCounter[ar[i]] += 1;
        }

        int pairs = 0;
        for (int i = 0; i < 100; i++) {
            pairs += sockCounter[i] / 2;
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