package Graph;

import java.util.HashMap;
import java.util.Map;

public class ShortestPath {
	
	public Map<String, Integer> shortestPath(int[][] a, String[] apex) {
		int n = a.length;
		int[] w = new int[n];
		Map<String, Integer> msi = new HashMap<>(); // map tinh tong khoang cach ngan nhat den cac dinh
		Map<String, String> mss = new HashMap<>();	// map cap nhat duong di ngan nhat den tung dinh
		for (int i = 1; i < n; i++)
			w[i] = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
					if (a[i][j] != 0 && w[j] > w[i] + a[i][j]) {
						w[j] = w[i] + a[i][j];
						String temp = apex[j];
						mss.put(temp,apex[i] + temp);
						String temp_current = mss.get(temp).substring(0, 1);
						if(mss.containsKey(temp_current))
							mss.put(temp, mss.get(temp_current) + temp);
					}
		
		for(int i = 0 ; i < n ; i++)
			msi.put(apex[i], w[i]);
		System.out.println(mss);
		return msi;
	}

	public void printShortestPath(int[][] a, String[] apex) {
		Map<String, Integer> msi = shortestPath(a, apex);
		int l = apex.length;
		for(int i = 1 ; i < l ; i++)
			System.out.println("Distance from " + apex[0] + " to " + apex[i] + " is: " + msi.get(apex[i]) + ".");
	}
}