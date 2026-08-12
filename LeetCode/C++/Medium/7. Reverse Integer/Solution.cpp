class Solution {
public:
    int reverse(int x) {
        int rev = 0;
        while(x!=0){
           int y = x%10; 
           x = x/10;
        // Check for overflow/underflow before updating ans
        if ((rev > INT_MAX / 10) || (rev < INT_MIN / 10)) {
            return 0; // Return 0 if reversing x would cause overflow/underflow
        }
        
            rev = rev *10 +y;
            
        }
        return rev;
    }
};