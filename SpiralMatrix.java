/*
LeetCode 54 - Spiral Matrix

Approach:
- Maintain four boundaries: top, bottom, left, and right.
- Traverse the matrix layer by layer in spiral order:
  left → right,
  top → bottom,
  right → left,
  bottom → top.
- Shrink the boundaries after each traversal.

Time Complexity: O(m × n)
Space Complexity: O(1) (excluding output list)
*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);

            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                list.add(matrix[bottom][i]);
            }}
            bottom--;
            if(left<=right){for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
            }}
            left++;

        }
        return list;
    }
}


actually  i didnt solved any question today i got off track but i dont want to break the github consistency green so this question i solved some time ago so im putting this for today

