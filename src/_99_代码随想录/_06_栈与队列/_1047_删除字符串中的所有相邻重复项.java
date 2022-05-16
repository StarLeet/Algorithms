package _99_代码随想录._06_栈与队列;

/**
 * @ClassName _1047_删除字符串中的所有相邻重复项
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _1047_删除字符串中的所有相邻重复项 {
    char[] stack;
    int size;
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 2) return s;
        stack = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (peek() == s.charAt(i)){
                pop();
                continue;
            }
            push(s.charAt(i));
        }
        return new String(stack,0,size);
    }

    private void push(char val){
        stack[size++] = val;
    }

    private char peek(){
        if (size == 0) return '#';
        return stack[size - 1];
    }

    private char pop(){
        if (size == 0) return '#';
        return stack[--size];
    }
}
