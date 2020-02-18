package algorithrm;

import java.util.Scanner;

public class MaDiTuan {
    int[] c = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] d = {1, 2, 2, 1, -1, -2, -2, -1};
    int dem = 0;

    public static void main(String[] args) {
        MaDiTuan h = new MaDiTuan();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap dien tich cua ma tran: ");
        int n = sc.nextInt();
        System.out.println("Nhap diem khoi dau cua ngua.");
        System.out.print("Row: ");
        int i = sc.nextInt();
        System.out.print("Column: ");
        int j = sc.nextInt();
        int[][] a = new int[n][n];
        h.backtrackingHorse(a, i, j, 1, n);
    }

    public void backtrackingHorse(int[][] a, int i, int j, int count, int n) {
        if (count == n * n) {
            dem++;
            System.out.println("Cach thu " + dem + ":");
            a[i][j] = count;
            printArr(a);
        } else {
            a[i][j] = count++;
            for (int k = 0; k < 8; k++) {
                int u = i + c[k], v = j + d[k];
                if (u >= 0 && u <= n - 1 && v >= 0 && v <= n - 1 && a[u][v] == 0) {
                    backtrackingHorse(a, u, v, count, n);
                    a[u][v] = 0;
                }
            }
        }
    }

    public void printArr(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
