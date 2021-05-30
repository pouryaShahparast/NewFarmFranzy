package model;

public class Coin {
    private int coins;
    public Coin(int coins) {
        this.coins = coins;
    }
    public int getCoin() {
        return coins;
    }
    public boolean hasEnoughCoins(int price){
        return coins - price >= 0;
    }
    public boolean reduceCoin(int a){
        if(coins - a >= 0){
            coins -= a;
            return true;
        }else {
            return false;
        }
    }
    public void addCoin(int a){
        coins += a;
    }
}
