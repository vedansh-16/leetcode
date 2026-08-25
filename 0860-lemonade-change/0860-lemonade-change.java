class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i=0 ;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }else{
                if(ten>0){
                    ten--;
                    if(five==0){
                        return false;
                    }
                    five--;
                }else{
                    if(five<3){
                        return false;
                    }
                    five = five-3;
                }
            }
        }
        return true;
    }
}