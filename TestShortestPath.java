package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestGraph {

	public static void main(String[] args) {
		ShortestPath sp = new ShortestPath();
		String[] apex = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		List<String> al = new ArrayList<>(); // adjacent List
		al.add("ABCD");
		al.add("BACG");
		al.add("CABDG");
		al.add("DACEF");
		al.add("EDFI");
		al.add("FDEGH");
		al.add("GBCFH");
		al.add("HFGI");
		al.add("IFH");
		int[][] ama = creatRanDomMatrix(al, apex); // adjacent matrix
		sp.printShortestPath(ama, apex);
	}

	public static int[][] creatRanDomMatrix(List<String> al, String[] apex) {
		Random rd = new Random();
		Bai0 b0 = new Bai0();
		int[][] ama = b0.ama(al);
		int l = ama.length;
//		for (int i = 0; i < l - 1; i++)
//			for (int j = i + 1; j < l; j++)
//				if (ama[i][j] == 1)
//					ama[i][j] = 1 + rd.nextInt(20);
		for (int i = 0; i < l; i++)
			for (int j = 1; j < l; j++) // the matrix symmetry(doi xung) so copy aij = aji
				ama[j][i] = ama[i][j]; //ama[i][j];
		System.out.print("{  ");
			for(int i = 0 ; i < l ; i++)
				System.out.print(apex[i] + "   ");
			System.out.println();
		for (int i = 0; i < l; i++) {
			System.out.print(" {");
			for (int j = 0; j < l; j++) {
				String str = Integer.toString(ama[i][j]);
				if (j == l - 1) {
					if (str.length() == 1)
						System.out.print(" " + ama[i][j] + " ");
					else
						System.out.print(ama[i][j] + " ");
				} else {
					if (str.length() == 1)
						System.out.print(" " + ama[i][j] + ", ");
					else
						System.out.print(ama[i][j] + ", ");
				}
			}
			System.out.println("},");
		}
		System.out.println("};");
		return ama;
	}
}
