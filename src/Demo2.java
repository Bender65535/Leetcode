import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Demo2 {
    public static void main(String[] args) {
        String s="fhewkljhfsakughasgbasjkdfh";
        int s2 = lengthOfLongestSubstring(s);
        System.out.println(s2);
    }
    static int lengthOfLongestSubstring(String s) {
        int max=0;

        char[] chars = s.toCharArray();
        Set<Character> set=new HashSet<>(chars.length);
        for(int i=0;i<chars.length;i++){
            for (int j = i; j < chars.length; j++) {
                //查看元素是否重复
                if(!set.add(chars[j])){//如果重复退出
                    break;
                }
            }
            if(set.size()>max){
                max=set.size();
            }
            set.clear();
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int max=0;
        int k=0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = k; j < i; j++) {
                if(chars[j]==chars[i]){
                    //屏蔽之前遍历的数组
                    k=j+1;
                    //退出查看之前屏蔽的数组的长度
                    break;
                }
            }
            if(i-k+1>max){
                max=i-k+1;
            }
        }

        return max;
    }
}
