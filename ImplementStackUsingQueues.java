/*
LeetCode 225 - Implement Stack using Queues

Approach:
- Use a single queue.
- After pushing an element, rotate the previous elements behind it.
- This makes the newly added element stay at the front.
- Therefore, pop() and top() behave like a stack.

Time Complexity:
- push(): O(n)
- pop(): O(1)
- top(): O(1)
- empty(): O(1)

Space Complexity: O(n)
*/

class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }

    public void push(int x) {
        q.add(x);

        int n = q.size();

        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
