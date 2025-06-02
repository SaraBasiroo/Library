package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    private CustomStack<Transaction> memberTransactions;


    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        memberTransactions = new CustomStack<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        memberTransactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        if (memberTransactions.isEmpty()) {
            return null;
        }
        return memberTransactions.peek();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
