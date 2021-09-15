import java.util.*;

class quickSort{
	public static void QuickSort(int[] arr){
		qSort(arr, 0, arr.length-1);
	}

	public static void qSort(int[] arr, int low, int high){
		if(low<high){
			int p = partition(arr, low, high);
			qSort(arr, low, p-1);
			qSort(arr, p+1, high);
		}
	}

	public static int partition(int[] arr, int low, int high){
		int pivot = arr[high], i = low;
		for(int j = low; j<high; j++){
			if(arr[j]<pivot){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		return i;
	}

	public static void main(String[] args) {
		int[] arr = {9,5,4,7,8,1,2,4};
		System.out.println(Arrays.toString(arr));
		QuickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}