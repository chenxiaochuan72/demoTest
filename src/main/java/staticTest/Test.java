package staticTest;

public class Test {
    private String name;
    static {
        System.out.println(new Test("1").getName());
    }
    public static class A{
        public A() {
        }
        public String age;
        public String getName(){
            return getName();
        }

    }

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public class B{
    }


    public static void main(String[] args) {
        Test test=new Test("2");
        new Test.A().getName();
    }
}
