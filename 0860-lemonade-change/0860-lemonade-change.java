class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0; // Number of $5 bills
        int ten = 0;  // Number of $10 bills

        for (int i = 0; i < bills.length; i++) {

            // Customer pays with $5
            if (bills[i] == 5) {
                five++;
            }

            // Customer pays with $10
            else if (bills[i] == 10) {

                // Need one $5 as change
                if (five == 0) {
                    return false;
                }

                five--;
                ten++;
            }

            // Customer pays with $20
            else {

                // First try to give one $10 and one $5
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                }

                // Otherwise give three $5 bills
                else if (five >= 3) {
                    five = five - 3;
                }

                // Can't give change
                else {
                    return false;
                }
            }
        }

        // Successfully gave change to everyone
        return true;
    }
}