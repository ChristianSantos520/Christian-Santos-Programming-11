import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        this.name = "";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    //Requires: double amt, Date date, String account
    //Modifies: it will create a new deposit object and add it to the deposits ArrayLst
        //it will add amt into checkBalance or savingBalance
    //Effects: returns checkBalance if account is CHECKING
        //returns savingBalance if account is SAVING
        //returns checkBalance if account is CHECKING
        //returns -1 if account is not equal too CHECKING or SAVING
        //returns -1 is amt is less than 0
    public double deposit(double amt, Date date, String account){
        if (invalidAccountType(account)) return -1;

        if (invalidAmount(amt)) return -1;

        if(CHECKING.equals(account)){
            checkBalance += amt;
            Deposit deposit = new Deposit(amt, date, account);
            deposits.add(deposit);
            return checkBalance;
        }
        // then account must be SAVING
        else {
            savingBalance += amt;
            Deposit deposit = new Deposit(amt, date, account);
            deposits.add(deposit);
            return savingBalance;
        }
    }

    //Requires: double amt, Date date, String account
    //Modifies: it will create a new withdraw object and add it to the  withdraws ArrayList
        //it will subtract amt from checkBalance or savingBalance
    //Effects: returns checkBalance if account is CHECKING
        //returns savingBalance if account is SAVING
        //returns checkBalance if account is CHECKING
        //returns -1 if account is not equal too CHECKING or SAVING
        //returns -1 is amt is less than 0
        //returns -1 if amt will cause an overdraft
    public double withdraw(double amt, Date date, String account){
        if (invalidAccountType(account)) return -1;

        if (invalidAmount(amt)) return -1;

        if(checkOverdraft(amt, account)){
            System.out.println("There is no withdrawal because of overdraft");
            return -1;
        }

        if(CHECKING.equals(account)){
            checkBalance -= amt;
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw);
            return checkBalance;
        }
        // then account must be SAVING
        else {
            savingBalance -= amt;
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw);
            return savingBalance;
        }
    }

    //Requires: double amt >= 0.0 and the String account should be CHECKING or SAVING
    //Effects: returns true if amt is greater than checkingBalance or savingBalance
    private boolean checkOverdraft(double amt, String account) {
        if (CHECKING.equals(account) && checkBalance < amt ){
            System.out.println("Overdraft");
            return true;
        } else if (SAVING.equals(account) && savingBalance < amt ){
            System.out.println("Overdraft");
            return true;
        } else{
            return false;
        }
    }

    //the IDE asked me to make a method because there was duplicate code in withdraw and deposit
    //Requires: String account that the method will check
    //Effects: returns true if invalid
    private boolean invalidAccountType(String account) {
        if(!account.equals(CHECKING) && !account.equals(SAVING)){
            System.out.println("account name is wrong");
            return true;
        }
        return false;
    }

    //the IDE asked me to make a method because there was duplicate code in withdraw and deposit
    //Requires: double amt that the method will check
    //Effects: returns true if amt is less than 0
    private boolean invalidAmount(double amt) {
        if (amt < 0.0) {
            System.out.println("Error :( amount " + amt + " withdrawn is less than 0");
            return true;
        }
        return false;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
