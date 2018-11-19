package suanfabiji;

public class Digv {
    static int maxn = 11;
    static int n;
    static int[] p = new int[maxn];
    static boolean[] hashtalbe = new boolean[maxn];

    public static void generateP(int index) {
        if (index == (n + 1)) {
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d", p[i]);
            }
            System.out.println();
            return;
        }
        for (int x = 1; x <= n; x++) {
            if (hashtalbe[x] == false) {
                p[index] = x;
                hashtalbe[x] = true;
                generateP(index + 1);
                hashtalbe[x] = false;
            }
        }
    }

    public static void main(String[] args) {
        n = 3;
        generateP(1);
    }
}
