public class Sort {
    public static void main(String[] args) {
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        quickSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
}
    public static void quickSort1(int[] array, int l, int u) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
        if (l >= u) return;
        int m = l;
        for (int i = l + 1; i <= u; i++) {
            if (array[i] < array[l]) {
                m += 1;
                int temp = array[m];
                array[m] = array[i];
                array[i] = temp;
} }
        // swap between array[m] and array[l]
        // put pivot in the mid
        int temp = array[m];
        array[m] = array[l];
        array[l] = temp;
        quickSort1(array, l, m - 1);
        quickSort1(array, m + 1, u);
    }
    public static void quickSort(int[] array) {
        quickSort1(array, 0, array.length - 1);
} }