package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 20:39 2018/10/17
 */
public class BaseballGame682 {
    public int calPoints(String[] ops) {
        int result = 0;
        int[] valid = new int[ops.length];
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C": {
                    int k = findLastValid(valid, i);
                    result -= valid[k];
                    valid[k] = 0;
                }
                break;
                case "D": {
                    int k = findLastValid(valid, i);
                    valid[i] = 2 * valid[k];
                    result += valid[i];
                }
                break;
                case "+": {
                    int k = findLastValid(valid, i);
                    int p = findLastValid(valid, k);
                    valid[i] = valid[k] + valid[p];
                    result += valid[i];
                }
                break;
                default: {
                    int k = Integer.parseInt(ops[i]);
                    result += k;
                    valid[i] = k;
                }
            }
        }
        return result;
    }

    private int findLastValid(int[] valid, int index) {
        for (int i = index-1; i >= 0; i--) {
            if (valid[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        BaseballGame682 a=new BaseballGame682();
        System.out.println(a.calPoints(ops));

    }
}
