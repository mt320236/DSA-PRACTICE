/*
Problem:
Generate Pascal's Triangle.

Approach:
1. Generate each row using nCr relation.
2. Store each row in a list.
3. Add all rows to the final answer.

Time Complexity: O(n²)
Space Complexity: O(1) extra space (excluding output)
*/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalAns=new ArrayList<>();
        for(int i=1; i<=numRows;i++){
            finalAns.add(pascalTraingle(i));
        }
        return finalAns;
    }
    public List<Integer> pascalTraingle(int n){
        List<Integer> l=new ArrayList<>();
        long answer=1;
        l.add((int)answer);
        for(int col=1;col<n;col++){
            answer=answer*(n-col);
            answer=answer/col;
            l.add((int)answer);

        }
        return l;
        
        
    }
}
