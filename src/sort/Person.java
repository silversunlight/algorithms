package sort;

/**
 * @author Lance Sun
 * @date Created in 10:24 2018/11/15
 */
public class Person implements Cloneable {
    private int age;
    private Long height;
    private String name;
    private Wallet money;

    public Person(int age, Long height, String name, Wallet money) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.money = money;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Wallet getMoney() {
        return money;
    }

    public void setMoney(Wallet money) {
        this.money = money;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = null;
        try {
            o = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ((Person) o).money= (Wallet) money.clone();
        return o;
    }
}
