package DCC;


public class Hanoi {
    /**
     * <a href="https://mathsisfun.com/games/towerofhanoi.html">线上游戏</a>
     */
    public static void main(String[] args) {
        // T(n) = 2^n -1 = O(2^n)
        move(3, "A", "B", "C");
    }

    /**
     * 将 src 柱上 n 个盘片，借助 spare 柱，转移至 dest 柱
     */
    static void move(int n, String src, String dest, String spare) {
        // base case
        if (n == 1) {
            System.out.println(src + " -> " + dest);
        }

        // recursive case
        else {
            // Move Disk 1 ~ n-1 from A to B
            move(n - 1, src, spare, dest);
            // Move Disk No. n from A to C
            move(1, src, dest, "");
            // Move Disk 1 ~ n-1 from B to C
            move(n - 1, spare, dest, src);
        }
    }
}



