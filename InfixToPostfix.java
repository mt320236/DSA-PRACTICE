/*
LeetCode/GFG: Infix to Postfix

Approach:
- Use a stack to store operators.
- Add operands directly to the result.
- Pop operators based on precedence.
- Handle parentheses separately.
- Pop remaining operators at the end.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i = 0;

        while (i < s.length()) {

            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {

                ans += s.charAt(i);
            }

            else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }

            else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
            }

            else {
                while (!st.isEmpty() &&
                       priority(st.peek()) >= priority(s.charAt(i))) {
                    ans += st.pop();
                }

                st.push(s.charAt(i));
            }

            i++;
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    public int priority(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return -1;
    }
}
