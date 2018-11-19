package sort;

/**
 * @author Lance Sun
 * @date Created in 10:24 2018/11/15
 */
public class Wallet implements Cloneable {
    private int number;

    public Wallet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o=null;
        try {
            o = (Wallet) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
