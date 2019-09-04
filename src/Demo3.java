import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 11, 15};
        int target=9;
        System.out.println(Arrays.toString(twoSum2(nums,target)));
    }
    static int[] twoSum(int[] nums, int target) {
        int[] result=null;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result=new int[2];
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 使用HashMap作差值
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
