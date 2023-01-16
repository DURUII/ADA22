package DCC;


public class Hanoi {
    /**
     * <a href="https://mathsisfun.com/games/towerofhanoi.html">汉诺塔</a>
     */
    public static void main(String[] args) {
        move(3, 1, 3, 2);
    }

    // 将 src 柱上 n 个盘片，转移至 dest 柱（可以借助空闲的 spare 柱）
    static void move(int n, int src, int dest, int spare) {
        if (n == 1) {
            System.out.println(src + "->" + dest);
        } else {
            move(n - 1, src, spare, dest);
            move(1, src, dest, -1);
            move(n - 1, spare, dest, src);
        }
    }
}



