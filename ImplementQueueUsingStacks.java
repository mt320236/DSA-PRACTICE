/*
LeetCode 232 - Implement Queue using Stacks

Approach:
- Use two stacks: s1 and s2.
- Push all new elements into s1.
- When peek() or pop() is called and s2 is empty,
  transfer all elements from s1 to s2.
- This reverses the order, making the oldest element
  available at the top of s2.

Time Complexity:
- push(): O(1)
- pop(): Amortized O(1)
- peek(): Amortized O(1)

Space Complexity: O(n)
*/

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
