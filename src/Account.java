public class Account {
    private User user;
    private double balance;

    public Account(User user, double initialBalance) {
        this.user = user;
        this.balance = initialBalance;
    }

    public User getUser(){
        return user;
    }

    public  double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void transfer(Account recipient,double amount){
        if (withdraw(amount)){
            recipient.deposit(amount);
            System.out.println("Transfer successful.");
        }else {
            System.out.println("Insufficient funds.");
        }
    }
}