public class Solution {
	public static void quicksort(int[] nums){
		quicksort(nums, 0, nums.length - 1);
	}
 
	public static void quicksort(int[] nums, int left, int right) {
		if(left >= right) return;

		int pivot = nums[(left + right) / 2];
		int index = partition(nums, left, right, pivot);
		quicksort(nums, left, index - 1);
		quicksort(nums, index, right);

	}

	private static int partition(int[] nums, int left, int right, int pivot) {
		while(left <= right){
			while(nums[left] < pivot){
				left++;
			}
			while(nums[right] > pivot){
				right--;
			}
			if(left <= right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	private static void swap(int[] nums, int left, int right){
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}