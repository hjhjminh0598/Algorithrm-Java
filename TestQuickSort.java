package testquicksort;

import java.util.Random;

public class TestQuickSort {

	public static void main(String[] args) {
		TestQuickSort test = new TestQuickSort();
//		test.testQuickSortWithRandomChar();
		test.testQuickSortWithPerson();
	}
	
	private void testQuickSortWithPerson() {
		Person test = new Person();
		Person[] persons = {new Person("a", "hanoi"), new Person("z", "bangkok"), new Person("b", "da nang")};
		test.sortFromCityToName(persons);
		String[] cities = test.getCities();
		String[] names = test.getNames();
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(cities[i] + " " + names[i]);
		}
	}

	private void testQuickSortWithRandomChar() {
		MySortAlgorithrm q = new MySortAlgorithrm();
		String[] nums = new String[10000];
		int l = nums.length;
		Random r = new Random();
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		for (int i = 0; i < l; i++) {
			nums[i] = String.valueOf(alphabet.charAt(r.nextInt(26)));
		}
		q.quickSort(nums);
		for (String t : nums)
			System.out.print(t + " ");
	}

}
