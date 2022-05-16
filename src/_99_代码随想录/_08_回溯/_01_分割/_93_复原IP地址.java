package _99_代码随想录._08_回溯._01_分割;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _93_复原IP地址
 * @Description
 * @Author StarLee
 * @Date 2022/5/13
 */
public class _93_复原IP地址 {

    private List<String> result;
    private char[] chars;
    private StringBuilder sb;
    private final int MAX_DEPTH = 4;  // IP地址由四部分组成
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        chars = s.toCharArray();
        sb = new StringBuilder();
        dfs(0,0);
        return result;
    }

    /**
     * 要选4个部分,所以设置curDepth参数
     */
    private void dfs(int curDepth, int startIndex){
        if (curDepth == MAX_DEPTH){
            // 剪枝,第四部分的划分不是在最后一个元素后面,直接退出
            if (startIndex == chars.length){
                result.add(sb.toString());
            }
            return;
        }
        // 0.0.0.0
        for (int i = startIndex; i < chars.length; i++) {
            // 如果要对非法字符做判断,在此处加即可,题目默认了数字,我就不多做操作了
            int oldLen = sb.length();  // 记录旧builder的长度,方便回溯
            int appendLen = i - startIndex + 1;  // 计算新拼接部分的长度
            if (appendLen > 3){  // IP地址每部分长度不能超过3
                break;
            }else if (appendLen == 3 &&
                    Integer.parseInt(new String(chars,startIndex,appendLen)) > 255){
                // 每部分长度为3的数值不能超过255
                break;
            }
            sb.append(chars, startIndex, appendLen);
            // 最后一部分后面就不能加.了
            if (curDepth != MAX_DEPTH - 1) sb.append('.');
            dfs(curDepth + 1,i + 1);
            // 回溯
            sb.delete(oldLen,sb.length());
            // 当前部分的第一个字符为0时,当前部分只能选择0,不能继续向后回溯
            if (chars[startIndex] == '0') break;
        }
    }
}
