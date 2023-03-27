package definingClasses.bankAccount;

public class BankAccount {
    private static double interestRate = 0.02;//стат. променливи се инициализират обикновено на реда, на който са извикани == 0.02
    private static int accountCount = 1;
    //static - не се обвързва с инстанциите и е нещо,
    // което се обвързва с класа и се отделя памет за променливата тогава,
    // когато се заделя за BankAccount.
    private int id;
    private double balance;

    public BankAccount() {
        this.id = accountCount;
        accountCount++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {// пишеш get и избираш за кое поле, т.к. ти го донаписва
        return this.id;
    }
}
