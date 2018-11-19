package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 11:24 2018/10/20
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 4, 1, 3};
        SingleNumber136 a=new SingleNumber136();
        int k = a.singleNumber(nums);
        System.out.println(k);
    }
}
