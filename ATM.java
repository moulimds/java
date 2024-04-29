
public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && userAccount.getBalance() >= amount) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.setBalance(userAccount.getBalance() + amount);
            System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }

    // Other methods (e.g., transfer, change PIN, etc.) can be added here
}

// BankAccount.java
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        atm.withdraw(200.0); // Withdraw $200
        atm.deposit(500.0); // Deposit $500
        atm.checkBalance(); // Check balance

        // You can add more interactions here based on user input
    }
}
