package com.tridu33.thread.lockOrder;

import java.util.concurrent.atomic.AtomicLong;

final class BankAccountWithId implements Comparable<BankAccountWithId> {
    private double balanceAmount; // Total amount in bank account
    private final Object lock;

    private final long id; // Unique for each BankAccount

    private static final AtomicLong nextID = new AtomicLong(0); // Next unused
    // ID

    BankAccountWithId(double balance) {
        this.balanceAmount = balance;
        this.lock = new Object();
        this.id = nextID.getAndIncrement();
    }

    @Override
    public int compareTo(BankAccountWithId ba) {
        return (this.id > ba.id) ? 1 : (this.id < ba.id) ? -1 : 0;
    }

    // Deposits the amount from this object instance
    // to BankAccount instance argument ba
    public void depositAmount(BankAccountWithId ba, double amount) {
        BankAccountWithId former, latter;
        if (compareTo(ba) < 0) {
            former = this;
            latter = ba;
        } else {
            former = ba;
            latter = this;
        }
        /*
        当发生转账时，会对两个BankAccount对象进行排序，会按排序结果顺序锁定两个BankAccount对象。
        当两个线程向两个账户之间互相转账时，这两个线程会按相同的次序对账户进行锁定，
        这样可以保证只有一个线程完成转账后，另一个线程才能获获取到所有的锁，然后进行转账操作。
        * */
        synchronized (former) {
            synchronized (latter) {
                if (amount > balanceAmount) {
                    throw new IllegalArgumentException("Transfer cannot be completed");
                }
                ba.balanceAmount += amount;
                this.balanceAmount -= amount;
            }
        }
    }

    public static void initiateTransfer(final BankAccountWithId first, final BankAccountWithId second, final double amount) {

        Thread transfer = new Thread(new Runnable() {
            @Override
            public void run() {
                first.depositAmount(second, amount);
            }
        });
        transfer.start();
    }

    public static void main(String[] args) {
        BankAccountWithId bankA = new BankAccountWithId(15000);
        BankAccountWithId bankB = new BankAccountWithId(9000);

        initiateTransfer(bankA, bankB, 500);
        initiateTransfer(bankB, bankA, 1400);
        //正确示例（顺序锁
    }

}
