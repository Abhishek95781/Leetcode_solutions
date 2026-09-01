class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0 || (x %10 == 0 && x!=0)){
            return false ;
        }
        long rev = 0;
        int temp = x;
        while(temp > 0){
            int dig = temp % 10;
            rev = rev*10 + dig;
            temp = temp / 10;
        }
        return rev == x;
    }
};