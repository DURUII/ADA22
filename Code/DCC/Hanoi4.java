package DCC;


public class Hanoi4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(move4(i));
        }
    }

    static int move4(int n) {
        // base case
        if (n == 1) return 1;
        if (n == 2) return 3;
        // recursive case
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
            min = Math.min(min, move4(i) + move3(n - i) + move4(i));
        return min;
    }

    static int move3(int n) {
        // base case
        if (n == 1) return 1;
        if (n == 2) return 3;
        // recursive case
        return move3(n - 1) * 2 + 1;
    }
}




