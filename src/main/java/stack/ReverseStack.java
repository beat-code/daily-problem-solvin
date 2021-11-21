package stack;

import java.util.Stack;
//[1,2,3,4,5]
//5,4,3,2,1 -
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }

    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int ele = st.pop();
        reverseStack(st);
        insertAtBottom(st, ele);
    }

    private static void insertAtBottom(Stack<Integer> st, int num){
        if(st.isEmpty()){
            st.push(num);
            return;
        }
        int ele = st.pop();
        insertAtBottom(st, num);
        st.push(ele);
    }
}
