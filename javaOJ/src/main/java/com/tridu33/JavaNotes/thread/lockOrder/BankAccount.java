package com.tridu33.JavaNotes.thread.lockOrder;

final class BankAccount {
    private double balanceAmount; // Total amount in bank account

    BankAccount(double balance) {
        this.balanceAmount = balance;
    }

    // Deposits the amount from this object instance
    // to BankAccount instance argument ba
    private void depositAmount(BankAccount ba, double amount) {
        synchronized (this) {
            synchronized (ba) {
                if (amount > balanceAmount) {
                    throw new IllegalArgumentException("Transfer cannot be completed");
                }
                ba.balanceAmount += amount;
                this.balanceAmount -= amount;
            }
        }
    }

    public static void initiateTransfer(final BankAccount first, final BankAccount second, final double amount) {
        Thread transfer = new Thread(new Runnable() {
            public void run() {
                first.depositAmount(second, amount);
            }
        });
        transfer.start();
    }

    public static void main(String[] args) {
        BankAccount bankA = new BankAccount(15000);
        BankAccount bankB = new BankAccount(9000);

        initiateTransfer(bankA, bankB, 500);
        initiateTransfer(bankB, bankA, 1400);
//    …上面的错误示例中会存在死锁的情况。当bankA\bankB两个银行账户同步互相进行转账时，就可能会导致死锁的问题。
    }

}
