package swea.d3.n8888;

import java.util.*;

// 코드길이 GOAT
// 1,140 줄
public class OtherSolution4 {
    static class D {

        int p;
        int n;
        ArrayList<Integer> a = new ArrayList<>();

        public D(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt(), t = sc.nextInt(), p = sc.nextInt();
            sc.nextLine();
            int[] ts = new int[t];
            D[] ds = new D[n];
            for (int i = 0; i < n; i++) {
                ds[i] = new D(i + 1);
                char[] temp = sc.nextLine().toCharArray();
                for (int j = 0; j < 2 * t - 1; j += 2) {
                    if (temp[j] == '1') {
                        ds[i].a.add(j / 2);
                    } else {
                        ts[j / 2]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j : ds[i].a) {
                    ds[i].p += ts[j];
                }
            }
            Arrays.sort(ds, new Comparator<D>() {
                public int compare(D a, D b) {
                    return (a.p != b.p) ? b.p - a.p
                        : (a.a.size() != b.a.size()) ? b.a.size() - a.a.size() : a.n - b.n;
                }
            });
            for (int i = 0; i < n; i++) {
                if (ds[i].n == p) {
                    System.out.println("#" + tc + " " + ds[i].p + " " + (i + 1));
                }
            }
        }
    }
}


