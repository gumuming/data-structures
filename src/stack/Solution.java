package stack;

import java.util.Stack;

/**
 * 匹配括号 {() []} 系统栈 撤销
 */
public class Solution {

    public boolean isValid(String s){
        //Stack<Character> stack = new Stack<>();
        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                Character topChar = stack.pop();
                if(c==')' && topChar !='(')
                    return false;
                if(c==']' && topChar !='[')
                    return false;
                if(c=='}' && topChar !='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s ="{[]}";
        String s1 ="{[)]}";
        System.out.println(new Solution().isValid(s));
        System.out.println(new Solution().isValid(s1));
    }
}
