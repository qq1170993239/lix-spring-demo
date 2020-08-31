package cn.lix.spring.demo.imports;

import cn.lix.spring.demo.utils.LogUtils;

public class MyImportBean1 {

    public MyImportBean1() {
        LogUtils.log().info(this.name + "-----我被创建了！！");
    }

    private String name = "MyImportBean1";

    public void sayName() {
        LogUtils.log().info("my name is " + name);
    }
}
