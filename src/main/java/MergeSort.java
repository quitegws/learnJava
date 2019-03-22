/**
 * @Author: gws
 * @Date: 2019-03-15 23:16
 * @Description:
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arrays = new int[]{1,21,3,67,4,0,2,-1,4};

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    public void mergeSort(int[] arrays, int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arrays, low, mid);
            mergeSort(arrays, mid + 1, high);
            merge(arrays, low, mid, high);
        }
    }

    public void merge(int[] arrays, int low, int mid, int high){

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];

        for(int i = 0; i < n1; i++){
            l[i] = arrays[low + i];
        }
        for(int i = 0; i < n2; i++){
            r[i] = arrays[mid + i + 1];
        }
        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0 ;

        for(int k = low; k <= high; k++){
            if (l[i] <= r[j]) {
                arrays[k] = l[i++];
            } else {
                arrays[k] = r[j++];
            }
        }
    }
}
