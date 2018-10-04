package conditionals;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
	static Scanner in;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		//negCheck();
		//quadratic();
		//findGreatest(new Integer[]{-3, -20, 0, 100, 1504});
		//dayOfWeek();
		//vowelOrConsonant();
		//naturalNumSum();
		//numAvg();
		//cubeCalculator();
		//numTriangle();
		//floydsTriangle();
		//starTriangle();
		//numberRhombus();
		//characterRhombus();
		//doubleTester();
		//digitCounter();
		//threeNumberTest();
		floatingPointTester();
	}
	
	static void negCheck(){
		Scanner in = new Scanner(System.in);
		out.println("Input integer: ");
		int input = in.nextInt();
		
		String result = "";
		
		if(input >= 0)
			result = "positive";
		else
			result = "negative";
		
		out.println(input + " is " + result);
	}

	/* 
	 * Quadratic equation = [-b +_ sqrt(b^2 - 4ac)] / 2a 
	 */
	static void quadratic(){
		
		out.println("Enter a: ");
		int a = in.nextInt();
		
		out.println("Enter b: ");
		int b = in.nextInt();
		
		out.println("Enter c: ");
		int c = in.nextInt();
		
		double result = Math.pow(b*b - 4*a*c, 0.5);
		double root1 = (-b + result) / 2*a; 
		double root2 = (-b - result) / 2*a;
		
		out.println("First root = " + root1);
		out.println("Second root = " + root2);
	}

	static void findGreatest(Integer[] array){
		int greatest;
		
		if(array.length == 0){
			out.println("You did not enter any numbers!");
			return;
		} else{
			greatest = array[0];
		}
		
		for(Integer num: array){
			if(num > greatest)
				greatest = num;
		}
		
		out.println("The greatest number of the array " + Arrays.toString(array) + " is: " + greatest);
	}

	static void dayOfWeek(){
		out.println("Enter a number between 1 and 7: ");
		int dayInt = in.nextInt();
		
		/* Here is one potential solution
		String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		out.println("The corresponding day of the week is: " + days[dayInt - 1]); // Account for index offset of Arrays
		*/
		
		// Here is a solution using case statements
		String dayName = "";
		switch (dayInt) {
	        case 1: dayName = "Monday"; break;
	        case 2: dayName = "Tuesday"; break;
	        case 3: dayName = "Wednesday"; break;
	        case 4: dayName = "Thursday"; break;
	        case 5: dayName = "Friday"; break;
	        case 6: dayName = "Saturday"; break;
	        case 7: dayName = "Sunday"; break;
	        default:dayName = "Invalid day range";
		}
		
		out.println("The corresponding day of the week is: " + dayName);

	}

	static void vowelOrConsonant(){
		out.println("Enter a single character: ");
		String input = in.nextLine().toLowerCase();
		
		boolean singleChar = input.length() == 1;
		boolean vowel = input.charAt(0) == 'a' || input.charAt(0) == 'e' || input.charAt(0) == 'i' 
				|| input.charAt(0) == 'o' || input.charAt(0) == 'u';
		boolean consonant = input.charAt(0) >= 97 && input.charAt(0) <= 122;
		
		if(singleChar){
			if(vowel)
				out.println(input + " is a vowel!");
			else if(consonant)
				out.println(input + " is a consonant!");
			else
				out.println(input + " is neither a vowel nor a consonant!!");
		} else{
			out.println("You did not enter a single character!");
			return;
		}
	}

	static void naturalNumSum(){
		out.println("Input a natural number: ");
		int num = in.nextInt();
		int sum = 0;
		
		
		out.println("The first " + num + " natural numbers are: \n");
		for(int i=1; i<=num; i++){
			out.println("" + i);
			sum += i;
		}
		
		out.println("The sum of the first " + num + " natural numbers is: " + sum);
	}
	
	static void numAvg(){
		out.println("Input a string of numbers separated by spaces: ");
		String nums = in.nextLine();
		
		int count = 0, sum = 0;
	
		for(char c: nums.toCharArray()){
			if(c != ' '){
				count += 1;
				sum += c - 48; // ASCII offset for numbers
			}
		}
		
		out.println("The sum of these " + count + " numbers is: " + sum);
		out.println("The average of these " + count + " numbers is: " + (double) sum/count);
	}
	
	static void cubeCalculator(){
		out.print("Enter a number of terms: ");
		int n = in.nextInt();
		
		for(int i=1; i<=n; i++){
			out.println("Number is " + i + " and the cube is " + (int) Math.pow(i, 3));
		}
	}
	
	static void numTriangle(){
		out.print("Enter a number of rows: ");
		int n = in.nextInt();
		
		for(int i = 1; i <= n; i++){
			for(int j=0; j<i; j++){
				out.print(i);
			}
			out.println();
		}
	}
	
	static void floydsTriangle(){
		out.print("Enter a number of rows: ");
		int rows = in.nextInt();
		
		int count;
		for(int i=1; i<=rows; i++){
			count = i;
			for(int j=0; j<i; j++){
				out.print(count%2);
				count++;
			}
			out.println();
		}
	}
	
	static void starTriangle(){
		out.print("Enter a number of rows: ");
		int rows = in.nextInt();
				
		for(int i=0; i<rows; i++){
			for(int j=0; j<i; j++)
				out.print(" ");
			
			for(int j=0; j<rows-i; j++)
				out.print("*");
			
			out.println();
		}
	}
	
	static void numberRhombus(){
		out.print("Enter a max number: ");
		int max = in.nextInt();
		
		int persist = 0, j = 0;
		
		for(int i=1; i<=max; i++){
			for(j=1; j<=max-i; j++){
				out.print(" ");
			}
			persist = i;
			
			for(j=1; j<=(2*i-1); j++){
				out.print(persist);
				
				if(j< (2*i)/2)
					persist -= 1;
				else
					persist += 1;
			}
			out.println();
		}
		
		for(int i=max-1; i>=1; i--){
			for(j=1; j<=max-i; j++){
				out.print(" ");
			}
			persist = i;
			
			for(j=1; j<=(2*i-1); j++){
				out.print(persist);
				
				if(j< (2*i)/2)
					persist -= 1;
				else
					persist += 1;
			}
			out.println();
		}
	}
	
	static void characterRhombus(){
		out.print("Enter a max number of letters: ");
		int max = in.nextInt();
		
		int persist = 0, j = 0;
		
		for(int i=1; i<=max; i++){
			for(j=1; j<=max-i; j++){
				out.print(" ");
			}
			persist = i;
			
			for(j=1; j<=(2*i-1); j++){
				out.print((char) (persist + 64));
				
				if(j< (2*i)/2)
					persist -= 1;
				else
					persist += 1;
			}
			out.println();
		}
		
		for(int i=max-1; i>=1; i--){
			for(j=1; j<=max-i; j++){
				out.print(" ");
			}
			persist = i;
			
			for(j=1; j<=(2*i-1); j++){
				out.print((char) (persist + 64));
				
				if(j< (2*i)/2)
					persist -= 1;
				else
					persist += 1;
			}
			out.println();
		}
	}

	static void doubleTester(){
		out.print("Enter a floating point digit: ");
		double num = in.nextDouble();
		
		String result = "";
		
		if(num > 0){
			result = "Positive";
		} else if(num < 0){
			result = "Negative";
		} else {
			result = "Zero";
		}
		
		if(Math.abs(num) < 1.0 && num != 0){
			result = "Small";
		} else if(num > 1000000){
			result = "Large";
		}
		
		out.println(result);
	}
	
	static void digitCounter(){
		out.print("Enter a number: ");
		Integer num = in.nextInt();
		
		/* Solution 1 */
		//out.println(num + " has " + num.toString().length() + " digits.");
		
		/* Solution 2 */
		int count = 0, i = 1;
		while(i <= 1000000000){
			if(num / i > 0)
				count++;
			
			i = i*10;
		}
		
		out.println(num + " has " + count + " digits.");
	}
	
	static void threeNumberTest(){
		out.print("Enter first number: ");
		int num1 = in.nextInt();
		out.print("Enter second number: ");
		int num2 = in.nextInt();
		out.print("Enter third number: ");
		int num3 = in.nextInt();
		
		if(num1 == num2 && num1 == num3){
			out.println("All numbers are equal");
		} else if(num1 == num2 || num1 == num3){
			out.println("All numbers are neither all equal nor all different");
		} else {
			out.println("All numbers are all different");
		}
	}
	
	static void floatingPointTester(){
		out.print("Enter first floating point: ");
		double num1 = in.nextDouble();
		out.print("Enter second floating point: ");
		double num2 = in.nextDouble();
		
		double mod1 = num1 * 100;
		double mod2 = num2 * 100;
		
		if(Math.abs(mod1 - mod2) < 1){
			out.println("Digits are same up to 2 decimal points");
		} else{
			out.println("Digits are not same up to 2 decimal points");
		}
	}
}