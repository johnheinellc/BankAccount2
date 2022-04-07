import java.util.ArrayList;

public class BankAccount {
    private double checking;
    private double savings;
    private static int numOfAccounts = 0;
    // private static int bankCapital = 0;
    static ArrayList<BankAccount> accounts=new ArrayList<BankAccount>();

    public BankAccount(double checkingAmount, double savingsAmount){
        checking = checkingAmount;
        savings = savingsAmount;
        numOfAccounts++;
        accounts.add(this);
    }
    public void showBalance(boolean is_checking) {
        if(is_checking) System.out.println(checking);
        else System.out.println(savings);
    }    
    public static int accountCount() {
        return numOfAccounts;
    }
    public double withdrawl(double amount, boolean is_checking) {
        if (amount > checking + savings){
        System.out.println("err, you dont have that bro!");
        return 0;
    }
        else{
            if(is_checking) checking -= amount;
            else savings -= amount;
            // BankAccount.bankCapital -= amount;
        }
        return amount;
    }
    public void deposit(double amount, boolean is_checking) {
        if(is_checking) checking += amount;
        else savings += amount;
        // BankAccount.bankCapital += amount;
    }
    public static double capitalOfBank() {
        double capital = 0;
        for(int accts = 0; accts<accounts.size(); accts++){
            BankAccount account = accounts.get(accts);
            capital += (account.checking + account.savings);
            // capital += account.getChecking() + account.getSavings();
        }
        return capital;
    }
    
    public void showTotalBalance() {
        System.out.println(checking + savings);
    }

    public double getChecking()
    {
        return checking;
    }

    public void setChecking(double checking)
    {
        this.checking=checking;
    }

    public double getSavings()
    {
        return savings;
    }

    public void setSavings(double savings)
    {
        this.savings=savings;
    }
}
