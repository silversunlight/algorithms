package sort;

/**
 * @author Lance Sun
 * @date Created in 18:49 2018/11/7
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Wallet wallet = new Wallet(100);
        Person personA = new Person(20, 180L,"tom",wallet);
        Person personB= (Person) personA.clone();
        System.out.println("B的年纪"+personB.getAge());
        System.out.println("B的钱数" + personB.getMoney().getNumber());
        personB.setAge(50);
        personB.setHeight(120L);
        personB.setName("sam");
        personB.getMoney().setNumber(20);
        System.out.println("A的高度" + personA.getHeight());
        System.out.println("A的名字"+personA.getName());
        System.out.println("A的年纪"+personA.getAge());
        System.out.println("A的钱数" + personA.getMoney().getNumber());
        System.out.println("B的高度" + personB.getHeight());
        System.out.println("B的名字"+personB.getName());
        System.out.println("B的年纪"+personB.getAge());
        System.out.println("B的钱数" + personB.getMoney().getNumber());
    }


}
