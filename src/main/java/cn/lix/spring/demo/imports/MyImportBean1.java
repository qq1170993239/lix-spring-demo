package cn.lix.spring.demo.imports;

public class MyImportBean1 {

    public MyImportBean1() {
        System.out.println(this.name + "-----我被创建了！！");
    }

    private String name = "MyImportBean1";

    public void sayName() {
        System.out.println("my name is " + name);
    }
}
