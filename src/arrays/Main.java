package arrays;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.*;

public class Main {
	
	static int[] numArray = { 4, 5, 4, 3, 10, 20, 50, 15, 10, 12, 11, -2 };
	static String[] stringArray = { "Java", "Python", "PHP", "C#", "C Programming", "C++" };
	static Object[] objectArray = {"Hello", "World", "Test", "Test Me"};
	
	public static void main(String[] args){
		//sortArrays(numArray, stringArray);
		//out.println("The sum of the array is: " + sumArray(numArray));
		//printGrid(10);
		//out.println("The average of array " + Arrays.toString(numArray) + " is " + arrayAverage(numArray));
		
		int findMe = 100;
		/*
		 * out.println("True / False - The number " + findMe + " is in the array " + Arrays.toString(numArray) + " = " + findValue(numArray, findMe));
		 * out.println("The number " + findMe + " is in the array " + Arrays.toString(numArray) + " at index  " + findIndex(numArray, findMe));
		 */
		//removeValue(objectArray , "World");
		//insertElement(objectArray, "New Element", 4);
		//findMinMax(numArray);
		//reverse(numArray);
		//commonElements(numArray, new int[]{1, 2, 3, 4, 100, -120, 5, 6, 7, 8, 9});
		//matrixAddition();
		//pairSum(numArray, 10);
		//out.println("The two arrays are equal: " + arraysEqual(new int[]{1, 2, 3, 3}, new int[]{1, 2, 3, 4}));
		//commonElementsThreeArrays(new int[]{1, 2, 3, 3}, new int[]{1, 2, 3, 4}, new int[]{1, 2, 10, 41});
		//out.println("The difference between the min and max of array " + Arrays.toString(numArray) + " is " + minMaxDifference(numArray));
		//removeDuplicates(numArray);
		//longestConsecutiveSequence(numArray);
		//majorityElements(numArray);
		//getLeaders(numArray);
		//nearZeroSum(numArray);
		/*
		String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", findCommon(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        */
		
		//stringPermutation("word", "");
		//stringBuilder(new String[]{"hello", "world", "my", "name", "is", "Nick"});
		//recursivePermute("", "help");
		//out.println(allUniqueChars("help"));
		//out.println(isPermutation("god", "dog"));
	/*
		String shorter = "abbc";
		String longer = "cbabadcbbabbcbabaabccbabc";
		out.println("The string " + longer + " contains the following permutations of the word " + shorter + ":");
		ArrayList<String> permutations = findPermutations(longer, shorter);
		for(String s: permutations){
			out.println(s);
		}
	*/
		//out.println(URLify("Mr John Smith    ", 13));
		//out.println(oneEditAway("bale", "pale"));
		//out.println(stringCompression("aabcccccaaa"));
		//zeroMatrix(3, 4);
		//out.println(isRotation("waterbottle".toCharArray(), "erbottlewat".toCharArray()));
		//out.println(ascii_deletion_distance("cat", "at"));
		out.println(bracket_error("()"));
	}
	
	private static int bracket_error(String string) {
		Deque<Character> stack = new ArrayDeque<Character>();
		int reserve = 0;
		int errors = 0;
		
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			
			if(c == '('){
				reserve += 1;
			}
			else if(c == ')'){
				if(reserve <= 0){
					errors += 1;
				} else{
					reserve -= 1;
				}
			}
		}
		
		errors += reserve;
		return errors;

	}

	public static int ascii_deletion_distance(String str1, String str2) {
        int i = 0, j = 0;
        int distance = 0;
        
        for(i = 0; i < str1.length(); i++){
              if(str1.charAt(i) == str2.charAt(j))
                  j++;
              else if(str1.charAt(i) == str2.charAt(j+1)){
                      distance += str1.charAt(i) + 2;
                      j++;
              } else if(str1.charAt(i+1) == str2.charAt(j)){
                      distance += str2.charAt(j) + 2;        
              }
        }
        
        for(j = j; j < str2.length(); j++){
             distance += str2.charAt(j) + 2;   
        }
        
        return distance;
    }
	
	private static boolean isRotation(char[] word1, char[] word2) {
		if(word1.length != word2.length)
			return false;
		
		int begIndex = 0, j = 0;
		
		// Go through the word1 once and compare with word2 
		for(int i = 0; i < word1.length; i++){
			if(word1[i] == word2[j])
				j++;	// Increment word2 index when you get an equals
			else
				begIndex = i + 1;	// Remember the last index where strings were not equal
		}
		
		// The sum of the index of the last compared letter and the place to pick up should equal the length of the word 
		if( (begIndex + j - 1) != word2.length)
			return false;

		for(int i = 0; i < word1.length - begIndex; i++){
			if(word1[i] != word2[j])
				return false;
			
			j++;
		}
		
		return true;
	}

	private static void zeroMatrix(int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = (int) (Math.random()*10);
			}
			
			out.println(Arrays.toString(matrix[i]));
		}
			
		out.println();
		
		setZeros(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			out.println(Arrays.toString(matrix[i]));
		}
	}

	private static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		// Check for 0's in first row
		for(int j = 0; j < matrix[0].length; j++){
			if(matrix[0][j] == 0){
				rowHasZero = true;
				break;
			}
		}

		// Check for 0's in first column
		for(int i = 0; i < matrix.length; i++){
			if(matrix[i][0] == 0){
				colHasZero = true;
				break;
			}
		}
		
		// Check for 0's in rest of matrix
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// Nullify rows accordingly
		for(int i = 1; i < matrix.length; i++){
			if(matrix[i][0] == 0){
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns accordingly
		for(int j = 1; j < matrix[0].length; j++){
			if(matrix[0][j] == 0){
				nullifyColumn(matrix, j);
			}
		}
		
		if(rowHasZero){
			nullifyRow(matrix, 0);
		}
		
		if(colHasZero){
			nullifyColumn(matrix, 0);
		}
	}

	private static void nullifyRow(int[][] matrix, int n) {
		for(int j = 0; j < matrix[0].length; j++){
			matrix[n][j] = 0;
		}
	}
	
	private static void nullifyColumn(int[][] matrix, int n) {
		for(int i = 0; i < matrix.length; i++){
			matrix[i][n] = 0;
		}
	}

	private static String stringCompression(String string) {
		String result = "";
		char[] str = string.toCharArray();
		char c = str[0];
		int index = 0,
			count = 0;
				
		for(int i = 0; i < str.length; i++){
			if(str[i] == c){
				count++;
				
				if(i == str.length - 1)
					result += c + Integer.toString(count);
			}
			else{
				result += c + Integer.toString(count);
				c = str[i];
				index = i;
				count = 1;
			}
		}
		
		return result.length() > string.length() ? string : result;
	}

	private static boolean oneEditAway(String w1, String w2) {
		// Strings have to be within one character of length to qualify
		int s1 = w1.length();
		int s2 = w2.length();
		if(Math.abs(s1 - s2) > 1)
			return false;

		int errors = 0;
		while( s1 >= 0 && s2 >= 0 && (Math.abs(s1) <= 1 && errors < 2) ){
			if(w1.charAt(s1) == w2.charAt(s2)){
				s1--; s2--;
			} else if(w1.charAt(s1 - 1) == w2.charAt(s2)){
				errors += 1;
				s2--;
			} else if(w2.charAt(s2 - 1) == w1.charAt(s1)){
				errors += 1;
				s1--;
			}
		}
		
		return errors < 2;
	}

	private static char[] URLify(String string, int numChars) {
		out.println(string);
		
		char[] result = string.toCharArray();
		
		int spaces = (result.length - numChars)/2;
		
		int i = result.length - 1;
		while(i >= 0 && spaces > 0){
			if(result[i - spaces*2] == ' '){
				result[i] = '0';
				result[i-1] = '2';
				result[i-2] = '%';
				i -= 3;
				spaces -= 1;
			}
			
			result[i] = result[i - spaces*2];
			i--;
		}

		return result;
	}

	private static ArrayList<String> findPermutations(String longer, String shorter) {
		ArrayList<String> result = new ArrayList<String>();
		
		int window = shorter.length();
		String temp = "";
		boolean equal = false;
		
		for(int i = 0; i <= longer.length() - window; i++){
			if(isPermutation(longer.substring(i, i + window), shorter))
				result.add(longer.substring(i, i + window));
		}
		
		return result;
	}

	/**
	 * Checks if two strings are permutations of the other.
	 * Strings must be the same length to be a permutation
	 * @param word1
	 * @param word2
	 * @return true / false: whether the strings are permutations
	 */
	private static boolean isPermutation(String word1, String word2) {
		if(word1.length() != word2.length())
			return false;
		
		word1 = stringSort(word1);
		
		return word1.equals(stringSort(word2));
	}

	private static String stringSort(String word) {
		char[] tempArray = word.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}


	private static boolean allUniqueChars(String word) {
		for(int i = 0; i < word.length()-1; i++){
			for(int j = i+1; j < word.length(); j++){
				if(word.charAt(i) == word.charAt(j))
					return false;
			}
		}

		return true;
	}

	public static void recursivePermute(String prefix, String word){
		int n = word.length() ; 
		if(n == 0)
			out.println(prefix);
		else{
			for(int i = 0; i < n; i++){
				recursivePermute(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, n));
			}
		}
	}
	
	public static void stringBuilder(String[] words){
		StringBuilder sentence = new StringBuilder();
		for(String w: words){
			sentence.append(w);
		}
		
		out.println(sentence.toString());
	}
	
	public static void stringPermutation(String str, String prefix){
		if(str.length() == 0)
			out.println(prefix);
		else {
			for(int i = 0; i < str.length(); i++){
				String rem = str.substring(0, i) + str.substring(i+1);
				stringPermutation(rem, prefix + str.charAt(i));
			}
		}
	}
	
	public static String[] findCommon(String[] names1, String[] names2) {
        Stream<String> one = Stream.of(names1);
        Stream<String> two = Stream.of(names2);
        Stream<String> concat = Stream.concat(one, two);
        
        String[] result = concat.distinct().toArray(String[]::new);
       
        return result;
    }
	
	static void sortArray(int[] array1, String[] array2){
		out.println("Unsorted int array: " + Arrays.toString(array1));
		Arrays.sort(array1);
		out.println("Sorted int array: " + Arrays.toString(array1));
		out.println("Unsorted String array: " + Arrays.toString(array2));
		Arrays.sort(array2);
		out.println("Sorted String array: " + Arrays.toString(array2));
	}
	
	static int sumArray(int[] nums){
		int sum = 0;
		
		for(int i: nums){
			sum += i;
		}
		
		return sum;
	}
	
	static void printGrid(int n){
		int[][] square = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				out.printf("%2d ", square[i][j]);
			}
			
			out.println();
		}
	}
	
	static double arrayAverage(int[] nums){
		int sum = 0;
		double avg = 0;
		
		for(int i: nums){
			sum += i;
		}
		
		avg = sum / nums.length;
		
		return avg;
	}
	
	static boolean findValue(int[] array, int findMe){
		boolean found = false;
		
		for(int n: array){
			if(n == findMe){
				found = true;
			}
		}
		
		return found;
	}
	
	static int findIndex(int[] array, int findMe){
		for(int i = 0; i < array.length; i++){
			if(array[i] == findMe){
				return i;
			}
		}
		
		return -1;
	}
	
	static void removeValue(Object[] array, Object findMe){
		out.println("Original array: " + Arrays.toString(array));
		
		
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(findMe)){
				for(int j = i; j < array.length - 1; j++){
					array[j] = array[j+1];
				}
				array[array.length-1] = null;
				break;
			}
		}
		
		out.println("New array: " + Arrays.toString(array));
	}
	
	static void insertElement(Object[] array, Object insert, int index){
		if(index >= array.length){
			out.println("Enter an index that is in range.");
			return;
		}
		
		out.println("Original array: " + Arrays.toString(array));
		
		Object[] newArray = new Object[array.length + 1];
		int offset = 0;
		
		for(int i = 0; i < array.length; i++){
			if(i == index){
				newArray[i] = insert;
				offset = 1; 
				newArray[i + offset] = array[i];
			} else{
				newArray[i + offset] = array[i];
			}
		}
		
		out.println("New array: " + Arrays.toString(newArray));
	}
	
	static void findMinMax(int[] array){
		int min = array[0], max = array[0];
		
		/* Iterating through the array and assigning min, max using the conditional assignment operator */
		for(int i: array){
			min = (i < min) ? i : min;
			max = (i > max) ? i : max;
		}
		
		out.println("Here is the array: " + Arrays.toString(array));
		out.println("Min = " + min);
		out.println("Max = " + max);
	}
	
	static void reverse(int[] array){
		int length = array.length;
		int[] newArray = new int[length];
		
		out.println("Original array: " + Arrays.toString(array));
		
		for(int i = 0; i < array.length; i++){
			newArray[length - i - 1] = array[i];
		}
		
		out.println("Original array: " + Arrays.toString(newArray));
	}
	
	static void commonElements(int[] array1, int[] array2){
		out.println("First array: " + Arrays.toString(array1));
		out.println("Second array: " + Arrays.toString(array2));
		
		for(int i: array1){
			for(int j = 0; j < array2.length; j++){
				if(i == array2[j]){
					out.println(i + " is a common element.");
					break;
				}
			}
		}
	}
	
	static void matrixAddition(){
		int[][] matrix1 = 
			{	{1, 2, 1},
				{2, 1, 3}, 
				{3, 2, 1} };
		
		int[][] matrix2 = 
			{	{2, 1, 2},
				{3, 2, 1}, 
				{1, 3, 2} };
		
		int[][] matrixResult = new int[3][3];
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		out.println("Matrix 1: \n" + Arrays.toString(matrix1[0]) +  "\n" + Arrays.toString(matrix1[1]) +  "\n" + Arrays.toString(matrix1[2]));
		out.println();
		out.println("Matrix 2: \n" + Arrays.toString(matrix2[0]) +  "\n" + Arrays.toString(matrix2[1]) +  "\n" + Arrays.toString(matrix2[2]));
		out.println();
		out.println("Result matrix: \n" + Arrays.toString(matrixResult[0]) +  "\n" + Arrays.toString(matrixResult[1]) +  "\n" + Arrays.toString(matrixResult[2]));
		out.println();
		
		ArrayList<String> list = new ArrayList<String>(Arrays.asList());
		list.toArray();
	}
	
	static void pairSum(int[] list, int sum){
		
		for(int i = 0; i < list.length; i++){
			for(int j = i+1; j < list.length; j++){
				if(list[i] + list[j] == sum){
					out.println(list[i] + " + " + list[j] + " = " + sum);
				}
			}
		}
	}
	
	static boolean arraysEqual(int[] list1, int[] list2){
		
		if(list1.length == list2.length){
			for(int i = 0; i < list1.length; i++){
				if(list1[i] != list2[i]){
					return false;
				}
			}
		} else{
			return false;
		}
		
		return true;
	}
	
	static void commonElementsThreeArrays(int[] list1, int[] list2, int[] list3){
		ArrayList<Integer> common = new ArrayList<Integer>();
		
		for(int i = 0; i < list1.length; i++){
			for(int j = 0; j < list2.length; j++){
				if(list1[i] == list2[j]){
					for(int k = 0; k < list3.length; k++){
						if(list1[i] == list3[k]){
							common.add(list1[i]);
						}
					}
				}
			}
		}
		
		out.print("Common elements among all 3 arrays: ");
		
		for(int i: common){
			out.print(i + " ");
		}
		
		out.println();
	}
	
	static int minMaxDifference(int[] list){
		int min = list[0], max = list[0];
		
		for(int i: list){
			min = (i < min) ? i : min;
			max = (i > max) ? i : max;
		}
		
		return max - min;
	}
	
	static void removeDuplicates(int[] array){
		out.println("Original array: " + Arrays.toString(array));
		
		ArrayList dupes = new ArrayList();
		
		for(int i: array){
			if(dupes.contains(i) == false){
				dupes.add(i);
			}
		}
		
		out.println("Length of the de-duped array: " + dupes.size());
	}
	
	static void longestConsecutiveSequence(int[] nums){
		final HashSet<Integer> h_set = new HashSet<Integer>();
        for (int i : nums) h_set.add(i);

        int longest_sequence_len = 0;
        for (int i : nums) {
            int length = 1;
            
            for (int j = i - 1; h_set.contains(j); --j) {
                h_set.remove(j);
                ++length;
            }
            
            for (int j = i + 1; h_set.contains(j); ++j) {
                h_set.remove(j);
                ++length;
            }
            
            longest_sequence_len = Math.max(longest_sequence_len, length);
        }
        
        out.println(longest_sequence_len);
	}
	
	static void majorityElements(int[] nums){
		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

		for(int i: nums){
			if(elements.containsKey(i)){
				elements.put(i, elements.get(i) + 1);
			} else{
				elements.put(i, 1);
			}
		}
		
		Integer majority = null;
		
		for(int key: elements.keySet()){
			if(elements.get(key) > nums.length/2)
				majority = key;
		}
		
		if(majority == null){
			out.println("There is no majority element.");
		} else{
			out.println("The majority element is " + majority + " and it occurs " + elements.get(majority) + " times.");
		}
	}

	static void getLeaders(int[] nums){
		List<Integer> leaders = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length-1; i++){			
			for(int j = i+1; j < nums.length; j++){
				if(nums[i] <= nums[j])
					break;
				
				if(j == nums.length-1){
					leaders.add(nums[i]);
				}
			}
		}
		
		leaders.add(nums[nums.length-1]);
		out.println("The leaders of the array are: " + leaders.toString());
	}
	
	static void nearZeroSum(int[] nums){
		int diff = Integer.MAX_VALUE;
		List<Integer> pair = new ArrayList<Integer>();
		pair.add(Integer.MAX_VALUE);
		pair.add(Integer.MAX_VALUE);
		
		for(int i = 0; i < nums.length; i++){
			for(int j = i+1; j < nums.length; j++){
				if(Math.abs(nums[i] + nums[j]) < diff){
					diff = Math.abs(nums[i] + nums[j]);
					pair.set(0, nums[i]);
					pair.add(1, nums[j]);
				}
			}
		}
		
		out.println("The nearest zero-sum pair is: " + pair.get(0) + " , " + pair.get(1));
	}
	
	static void segregation(int[] array){
		int head = 0;
		int tail = array.length-1;
		
		/*
		while(head < tail){
			if()
		}
		*/
	}
}
