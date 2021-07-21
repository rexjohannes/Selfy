package me.sirlennox.selfy;

public enum AccountType {
    USER(0), PREMIUM(1);
    private int level;
    AccountType(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
