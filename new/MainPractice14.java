import java.util.HashMap;
import java.util.Random;

public class MainPractice14 {
    public static void main(String[] args){
        Bank bank = new Bank();
        for(int i = 0; i < 100; i++) {
            Account account = new Account((long) ((Math.random() * (40000)) + 30000), String.valueOf((int) (Math.random() * (19)) + 1));
            bank.addAcc(String.valueOf(i), account);
        }
        for(int i = 0; i < 4; i++){
            BankGenerator start = new BankGenerator(bank);
            new Thread(start).start();
        }
    }
}

class Bank{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    public Bank(){
        accounts = new HashMap<>();
    }
    public void addAcc(String name, Account account) {
        accounts.put(name,account);
    }
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }
    public synchronized void transfer(String fromAccountNumber, String toAccountNumber, long amount){
        if(accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            Account firstAccount = accounts.get(fromAccountNumber);
            Account secondAccount = accounts.get(toAccountNumber);
            System.out.println("\n \n" + fromAccountNumber + ": " + firstAccount.getMoney() + "\n" + toAccountNumber + ": " + secondAccount.getMoney() + "\n" + "Sum of transactions: " + amount + "\n");
            if (!firstAccount.isBlockAccount() && !secondAccount.isBlockAccount()) {
                if(amount > 50000){
                    try{
                        if(isFraud(fromAccountNumber, toAccountNumber, amount)){
                            System.out.println("Operation has been stopped.");
                            firstAccount.setBlockAccount(true);
                            secondAccount.setBlockAccount(true);
                        }
                        else {
                            if (firstAccount.getMoney() - amount >= 0) {
                                firstAccount.setMoney(firstAccount.getMoney() - amount);
                                secondAccount.setMoney(secondAccount.getMoney() + amount);
                                System.out.println("Transaction has been completed." + "\n" + fromAccountNumber + ": " + getBalance(fromAccountNumber) + "\n" + toAccountNumber + ": " + getBalance(toAccountNumber) + "\n");
                                accounts.put(fromAccountNumber, firstAccount);
                                accounts.put(toAccountNumber, secondAccount);
                            } else {
                                System.out.println("You have not enough money.");
                            }
                        }
                    }catch (InterruptedException ex){
                        System.out.println("Accounts have been blocked.");
                    }
                }
                else{
                    if(firstAccount.getMoney() - amount >= 0){
                        firstAccount.setMoney(firstAccount.getMoney()-amount);
                        secondAccount.setMoney(secondAccount.getMoney()+amount);
                        System.out.println("Transaction has been completed." + "\n" + fromAccountNumber + ": " + getBalance(fromAccountNumber) + "\n" + toAccountNumber + ": " + getBalance(toAccountNumber) + "\n");
                        accounts.put(fromAccountNumber, firstAccount);
                        accounts.put(toAccountNumber, secondAccount);
                    }
                    else{
                        System.out.println("You have not enough money.");
                    }
                }
            } else {
                System.out.println("Account has been blocked.");
            }
        }
        else{
            System.out.println("Something goes wrong.");
        }
    }

    public long getBalance(String accountNum){
        return accounts.get(accountNum).getMoney();
    }
}

class Account
{
    private long money;
    private String accountNumber;
    private boolean blockAccount = false;
    public Account(long money,String accountNumber) {
        this.accountNumber = accountNumber;
        this.money=money;
    }
    public void setMoney(long money){
        this.money=money;
    }
    public synchronized long getMoney() {
        return money;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setBlockAccount(boolean blockAccount) {
        this.blockAccount = blockAccount;
    }
    public boolean isBlockAccount() {
        return blockAccount;
    }
}

class BankGenerator implements Runnable {
    private Bank bank;
    public BankGenerator(Bank bank){
        this.bank = bank;
    }
    public void run() {
        for(int i = 0; i < 10; i++){
            bank.transfer(String.valueOf((int)(Math.random()*99)), String.valueOf((int)(Math.random()*99)), (long)((Math.random()*(40000))+30000));
        }
    }
}