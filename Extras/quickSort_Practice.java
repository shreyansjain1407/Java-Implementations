class QuickSort{
	static void quickSort(int[] arr){
		qSort(arr, 0, arr.length-1);
	}

	static qSort(int[] arr, int low, int high){
		if(low<high){
			int p = partition(arr, low, high);
			qSort(arr, low, p-1);
			qSort(arr, p+1, high);
		}
	}

	static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low;
		for (int j = low;j<high ;j++ ) {
			if (arr[j]<pivot) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
		}
		int temp = arr[high];
		arr[high] = arr[i];
		arr[i] = temp;
		return i;
	}
}