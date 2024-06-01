package midterm.labs;

import java.util.Stack;

public class Lab4 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(1);
        minStack.push(3);
        System.out.println(minStack);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
    }
}
class MinStack {
    Stack<Integer> stack;
    private Stack<Integer> helper;

    MinStack() {
        // initializes the stacks
        stack = new Stack<>();
        helper = new Stack<>();
    }

    void push(int element) {
        /*
        inserts an element according to its value
        if element is smaller than stack top it adds to helper class to compare its value
        it has O(1) time complexity because all operations is a constant time operation.
         */
        if (!stack.empty() && element < stack.peek()) {
            helper.push(element);
        }
        if (helper.empty()) {
            helper.push(element);
        }
        stack.push(element);
    }

    Integer pop() {
        /*
        removes the top element if helper top and stack top is equal each other removes both of them
        in built in stack algorithm, peek method has O(1) time complexity
         */
        if (stack.peek() == helper.peek()) helper.pop();
        return stack.pop();
    }

    Integer top() {
        // it removes the top element of main stack
        //in built in stack algorithm, top method has O(1) time complexity
        return stack.peek();
    }

    Integer getMin() {
        // return the min element of the stack
        //in built in stack algorithm, peek method has O(1) time complexity
        return helper.peek();
    }


    @Override
    public String toString() {
        return stack.toString();
    }
}