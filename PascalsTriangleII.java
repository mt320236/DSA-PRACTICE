/*
Problem:
Return the rowIndex-th row of Pascal's Triangle.

Approach:
1. Use the nCr relation to generate elements directly.
2. Start with 1 as the first element.
3. Compute each next element using the previous element.
4. Store all elements in a list and return it.

Time Complexity: O(rowIndex)
Space Complexity: O(1) extra space (excluding output)
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        long answer=1;
        List<Integer> l=new ArrayList<>();
        l.add((int)answer);
        for(int col=1;col<=rowIndex;col++){
            answer=answer*((rowIndex+1)-col);
            answer=answer/col;
            l.add((int)answer);

        }
        return l;
        
    }
}
