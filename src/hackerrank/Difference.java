import java.util.ArrayList;
import java.util.Arrays;

class Difference {
  	private int[] elements;
  	public int maximumDifference;

    // arr is an array of positive integers
    public Difference(int[] arr) {
        this.elements = arr;
    }

    public void computeDifference() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer num : this.elements) {
            max = num > max ? num : max;
            min = num < min ? num : min;
        }

        this.maximumDifference = Math.abs(max - min);
    }

	public String printElements() {
        return Arrays.toString(this.elements);
	}

} // End of Difference class