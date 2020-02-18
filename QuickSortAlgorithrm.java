package testquicksort;

public class MySortAlgorithrm {

	public void quickSort(String[] strings) {
		int left = 0, right = strings.length - 1;
		strings = quickSortRecusion(strings, left, right);
	}

	public String[] quickSortRecusion(String[] strings, int left, int right) {
		if (right - left <= 0)
			return strings;

		int pivot = getPivot(strings, left, right);
		int r = right; // optimize second loop

		for (int i = 0; i <= right; i++) {
			if (r < i) {
				return quickSortRecusion(quickSortRecusion(strings, left, i - 1), i, right);
			}
			if (i == right) {
				if (strings[right].compareTo(strings[pivot]) < 0)
					swap(strings, pivot, i);
				return quickSortRecusion(strings, left, right - 1);
			}
			if (strings[i].compareTo(strings[pivot]) > 0) {
				for (int j = r; j >= i; j--) {
					if (j == i) {
						return quickSortRecusion(quickSortRecusion(strings, left, j - 1), j, right);
					}
					if (strings[j].compareTo(strings[pivot]) <= 0) {
						if (strings[j].compareTo(strings[pivot]) == 0)
							pivot = i;
						r = j - 1;
						swap(strings, i, j);
						break;
					}
				}
			}
		}
		return strings;
	}

	private void swap(String[] strings, int i, int j) {
		String temp = strings[i];
		strings[i] = strings[j];
		strings[j] = temp;
	}

	private int getPivot(String[] strings, int left, int right) {
		return (left + right) / 2;
	}

}
