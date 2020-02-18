package algorithrm;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();
        Comparable[] a = str.split("");
        ms.printSorted(a);
    }

    public void printSorted(Comparable[] a) {
        int n = a.length;
        a = sort(a, n);
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }

    public Comparable[] sort(Comparable[] a, int n) {
        if (n == 1)
            return a;
        int mid = n / 2, k = mid, clength = n - mid;
        Comparable[] b = new Comparable[mid], c = new Comparable[clength];
        for (int i = 0; i < mid; i++)
            b[i] = a[i];
        for (int i = 0; i < n - mid; i++)
            c[i] = a[k++];
        return mergeArraySorted(sort(b, mid), sort(c, clength));
    }

    public Comparable[] mergeArraySorted(Comparable[] b, Comparable[] c) {
        int bl = b.length, cl = c.length;
        Comparable[] a = new Comparable[bl + cl];
        int i = 0, j = 0, k = 0, n = a.length;
        while (i < n) {
            if (j == bl)
                a[i++] = c[k++];
            else if (k == cl)
                a[i++] = b[j++];
            else if (largeThan(b[j], c[k]))
                a[i++] = b[j++];
            else
                a[i++] = c[k++];
        }
        return a;
    }

    public boolean largeThan(Comparable b, Comparable c) {
        return b.compareTo(c) >= 0;
    }
}
