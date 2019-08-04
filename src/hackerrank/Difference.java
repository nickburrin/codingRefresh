package hackerrank;

import java.util.Arrays;

class Difference {
  	private int[] elements;
  	public int maximumDifference;

    // arr is an array of positive integers
    public Difference(int[] arr) {
        this.elements = arr;
    }

    public void computeDifference() {
        int min = this.elements[0];
        int max = this.elements[0];
        this.maximumDifference = Math.abs(max - min);

        for (Integer num : this.elements) {
            int diff1 = Math.abs(max - num);
            int diff2 = Math.abs(num - min);

            if (diff1 > this.maximumDifference) {
                this.maximumDifference = diff1;
                min = num;
            }

            if (diff2 > this.maximumDifference) {
                this.maximumDifference = diff2;
                max = num;
            }
        }
    }

	public String printElements() {
        return Arrays.toString(this.elements);
	}

} // End of Difference class