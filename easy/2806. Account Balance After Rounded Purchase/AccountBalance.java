//https://leetcode.com/problems/account-balance-after-rounded-purchase/
public class AccountBalance{
	public static void main(String[] args){
		System.out.println(accountBalanceAfterPurchase(9));
	}
    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        if(purchaseAmount==0) return 100;
    int firstDigit=(purchaseAmount-1)/10;
    return ((2*firstDigit)+1)*5<=purchaseAmount?(9-firstDigit)*10:(10-firstDigit)*10;
    }
}
