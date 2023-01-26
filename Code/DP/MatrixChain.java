package DP;

public class MatrixChain {
    static int[] arr = new int[]{40, 20, 30, 10, 30};
    static int N = 4;

    public static void main(String[] args) {
        System.out.println(matrixMultiplication(N, arr));
    }

    static int matrixMultiplication(int N, int l[]) {
        int[][] opt = new int[N + 1][N + 1];

        for (int p = 2; p <= N; p++) {
            for (int i = 1; i <= N - p + 1; i++) {
                int j = i + p - 1;
                opt[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int tmp = opt[i][k] + opt[k + 1][j] + l[i - 1] * l[j] * l[k];
                    opt[i][j] = Math.min(tmp, opt[i][j]);
                }
            }
        }

        return opt[1][N];
    }
}