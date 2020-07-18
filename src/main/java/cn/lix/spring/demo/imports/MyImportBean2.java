package cn.lix.spring.demo.imports;

public class MyImportBean2 {

    public MyImportBean2() {
        System.out.println(this.name + "-----我被创建了！！");
    }

    private String name = "MyImportBean2";

    public void sayName() {
        System.out.println("my name is " + name);
    }


}
