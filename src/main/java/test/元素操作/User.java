package test.元素操作;

public class User {
    private String name;
    private Integer sum;

    public User(String name, Integer sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
