package _99_代码随想录._04_字符串;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName 字节_字符串替换
 * @Description
 * @Author StarLee
 * @Date 2022/4/20
 */

public class 字节_字符串替换 {
    public String stringReplace(String s, int[] arr){
        if (s == null || s.length() <= 1) return s;
        int[] lenArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            while (tmp != 0){
                lenArr[i]++;
                tmp /= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int curIndex = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) != '%'){
                sb.append(s.charAt(i++));
            }else {
                int j = i + 1;
                char ch = s.charAt(j);
                StringBuilder num = new StringBuilder();
                while (ch >= '0' && ch <= '9'){
                    num.append(ch);
                    if (++j == s.length()) break;
                    ch = s.charAt(j);
                }
                i = j + 1;
                if (ch == 'd'){
                    if (num.length() == 0){
                        sb.append(arr[curIndex++]);
                    }else {
                        int l = Integer.parseInt(num.toString());
                        if (l > lenArr[curIndex]){
                            int blankNum = l - lenArr[curIndex];
                            while (blankNum-- > 0){
                                sb.append(' ');
                            }
                        }
                        sb.append(arr[curIndex++]);
                    }
                    continue;
                }
                sb.append('%').append(num);
                if (ch < '0' || ch > '9') sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String stringReplace1(String s, int[] arr){
        if (s == null || s.length() <= 1) return s;
        Pattern compile = Pattern.compile("%[0-9]*d");
        Matcher matcher = compile.matcher(s);
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (matcher.find()){
            String group = matcher.group(0);
            int len = 0, tmp = arr[i];
            while (tmp != 0){
                len++;
                tmp /= 10;
            }
            int blankNum = Integer.parseInt(group.substring(1,group.length() - 1)) - len;
            StringBuilder sb = new StringBuilder();
            while (blankNum-- > 0){
                sb.append(' ');
            }
            sb.append(arr[i++]);
            matcher.appendReplacement(buffer,sb.toString());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String s = scanner.nextLine();
        int i = 0;
        while (i < n){
            arr[i] = scanner.nextInt();
            i++;
        }
        字节_字符串替换 v = new 字节_字符串替换();
        System.out.println(v.stringReplace1(s,arr));
    }
}
