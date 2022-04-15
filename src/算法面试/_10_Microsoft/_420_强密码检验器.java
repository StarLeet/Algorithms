package 算法面试._10_Microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _420_强密码检验器
 * @Description
 * @Author StarLee
 * @Date 2022/4/2
 */

public class _420_强密码检验器 {
    public int strongPasswordChecker(String password) {
        if (password.length() < 4) return 6 - password.length();
        List<Character> spaces = new ArrayList<>(); // 连续字符的区间,如aaabbb 则spaces={3,3}
        // 补全缺失的必要字符,所需的行为次数
        int requireActions = travelString(password,spaces);
        // 拆散连数需要的最少操作次数
        int breakActions = 0;
        if (password.length() < 6){  // 插入操作是必须的
            int addActions = Math.max(6 - password.length(), 0);
            for (Character space : spaces) {
                breakActions += space / 3;
            }
            // 长度 4 5 怎么也有一次插入操作,可以直接把连数拆散,所以在此可以忽略breakActions
            return Math.max(addActions,requireActions);
        }
        if (password.length() <= 20){  // 默认排除删除、插入操作,因为不会带来更好的收益
            // 连数拆散操作全部由字节替换完成
            for (Character space : spaces) {
                breakActions += space / 3;
            }
            breakActions = Math.max(breakActions,requireActions);  // 替换的同时，可以替换成必须字符
            return breakActions;
        }
        // 字符串超长度的情况,此时连数打散需要尽可能地选取删除的方式
        int deleteActions = password.length() - 20;
        int oldDeleteActions = deleteActions;
        int delOnceCount = 0;   // 通过一次删除操作可以减少一个三连数的次数
        int delSecondCount = 0; // 通过两次删除操作可以减少一个三连数的情况
        for (Character space : spaces) {
            breakActions += space / 3;
            if (space % 3 == 0) delOnceCount++;  // 第一次删除一次,后续都是删除3次
            if (space % 3 == 1) delSecondCount++; // 第一次删除2次,后续都是删除3次
        }
        // 删除操作是否满足减完一次
        delOnceCount = Math.min(deleteActions,delOnceCount);
        deleteActions -= delOnceCount;
        // 删除操作是否满足减完两次
        delSecondCount = Math.min((deleteActions >> 1),delSecondCount);
        deleteActions -= delSecondCount << 1;
        // 删除操作可以减多少个三次
        int delThirdCount = deleteActions / 3;
        // 一次删除过程完成,代表一个连续的3字符被破坏
        breakActions -= delOnceCount + delSecondCount + delThirdCount;
        return Math.max(breakActions,requireActions) + oldDeleteActions;
    }

    public void necessaryChar(char a, boolean[] hasConditions){
        if (a >= 'a' && a <= 'z'){
            hasConditions[0] = true;
        }else if (a >= 'A' && a <= 'Z'){
            hasConditions[1] = true;
        }else if (a >= '0' && a <= '9'){
            hasConditions[2] = true;
        }
    }
    /**
     *  @MethodName travelString
     *  @Description  遍历字符串
     *  @Param [password, spaces]
     *  @return 缺少[小写,大写,数字]中的哪几个
     */
    public int travelString(String password, List<Character> spaces){
        boolean[] hasConditions = new boolean[3];
        int strLength = password.length();
        for (int i = 1; i < strLength; i++) {
            char ch = password.charAt(i - 1);
            necessaryChar(ch, hasConditions);
            int j = i - 1;
            while ((i < password.length()) && password.charAt(i) == password.charAt(i - 1)) i++;
            int length;
            if ((length = i - j) >= 3){
                spaces.add((char)length);
            }
        }
        // 最后一个有可能跳过,在这里加一处保险
        necessaryChar(password.charAt(strLength - 1),hasConditions);
        int requireActions = 0;
        // 清算 缺少的必要字符个数
        for (boolean hasCondition : hasConditions) {
            if (!hasCondition) requireActions++;
        }
        return requireActions;
    }

    public static void main(String[] args) {
        _420_强密码检验器 v = new _420_强密码检验器();
        System.out.println("bbaaaaaaaaaaaaaaacccccc".length());
        v.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc");
        // "bb aaa aaa aaa aaa aa ccc cc"
    }
}
