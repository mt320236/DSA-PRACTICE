/*
LeetCode 1344 - Angle Between Hands of a Clock

Approach:
- Minute hand moves 6° per minute.
- Hour hand moves 30° per hour and 0.5° per minute.
- Calculate both angles and find their difference.
- Return the smaller angle using Math.min(angle, 360-angle).

Time Complexity: O(1)
Space Complexity: O(1)
*/


class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12){
            hour=0;
        }
        double minDegree=minutes*6;
        double hMinDegree=minutes*.5;
        
        double hourDegree=hour*30+hMinDegree;
        double angle=0;
        if(minDegree>hourDegree){
            angle=minDegree-hourDegree;
            
        
            
        }
        else{
            angle=hourDegree-minDegree;
        }
        angle=Math.min(angle,360-angle);
        return angle;
        
        
    }
}
