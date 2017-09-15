public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        solution.quickSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
	}

	public void quickSort(int[] nums){
		quickSort(nums, 0, nums.length - 1);
	}

	public void quickSort(int[] input, int low, int high) {
 
    // Base case
    if (low >= high) {
      return;
    }
 
    // Use last element as pivot
    int pivot = input[high];
    // Set our wall at the first element
    int wall = low;
 
    /**
     * Iterate through array - if current element is less that or equal 
     * to pivot, swap with element above wall
     */
    for (int i = low; i < high; i++) {
      if (input[i] <= pivot) {
        swap(input, i, wall++);
      }
    }
 
    // Place pivot to right to just right of wall
    swap(input, wall, high);
 	for (int item : input) {
            System.out.print(item + " ");
        }
        System.out.println();

    // Recursively call for each part of array
    quickSort(input, low, wall-1);
    quickSort(input, wall, high);
 
  }
 
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


	
}