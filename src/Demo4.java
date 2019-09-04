/**
 * 最长回文字
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Demo4 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }


    static String longestPalindrome(String s) {
        if(s==null||s.length()<=1){
            return s;
        }
        boolean[][] is=new boolean[s.length()][s.length()];
        //下标0为大小,下标1为回文开始下标
        int[] max=new int[]{1,0};
        String result=null;
        char[] chars = s.toCharArray();
        for (int i = 0; i <s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(chars[j]==chars[i]){
                    //收尾相等,长度为3以内的字符串必为回文
                    if(i-j<=2){
                        is[j][i]=true;

                        //收尾相等,判断其他长度
                    }else {
                        if(is[j+1][i-1]){
                            is[j][i]=true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(is[i][j]){
                    if(j-i+1>max[0]){
                        max=new int[]{j-i+1,i};
                    }
                }
            }
        }
        result=s.substring(max[1],max[0]+max[1]);

        return result;
    }


    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String palindromeOdd = centerSpread(s, len, i, i);
            String palindromeEven = centerSpread(s, len, i, i + 1);
            String maxLen = palindromeOdd.length() > palindromeEven.length() ? palindromeOdd : palindromeEven;
            if (maxLen.length() > longestPalindrome) {
                longestPalindrome = maxLen.length();
                longestPalindromeStr = maxLen;
            }
        }
        return longestPalindromeStr;
    }

    private String centerSpread(String s, int len, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 这里要特别小心，跳出 while 循环的时候，是第 1 个满足 s.charAt(l) != s.charAt(r) 的时候
        // 所以，不能取 l，不能取 r
        return s.substring(l + 1, r);
    }

}
