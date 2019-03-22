/**
 * @Author: gws
 * @Date: 2019-03-15 22:51
 * @Description:
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arrays = new int[]{1,21,3,67,4,0,2,-1,4};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arrays,0,arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    public void quickSort(int[] arrays, int low, int high){
        if (low < high) {
            int mid = partition(arrays, low, high);
            quickSort(arrays, low, mid - 1);
            quickSort(arrays, mid + 1, high);
        }
    }

    public int partition(int[] arrays, int low, int high){
        int key = arrays[low];

        while(low < high){
            while(low < high && key <= arrays[high]){   //存在相等的元素
                high--;
            }

            arrays[low] = arrays[high];

            while(low < high && arrays[low] <= key){
                low++;
            }
            arrays[high] = arrays[low];
        }

        arrays[low] = key;
        return low;
    }
}
