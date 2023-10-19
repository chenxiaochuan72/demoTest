package test;

public class ss {
    public static void main(String[] args) {
        String str=new String();
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
    
