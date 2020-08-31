package cn.lix.spring.demo.imports;

import cn.lix.spring.demo.utils.LogUtils;

public class MyImportBean2 {

    public MyImportBean2() {
        LogUtils.log().info(this.name + "-----我被创建了！！");
    }

    private String name = "MyImportBean2";

    public void sayName() {
        LogUtils.log().info("my name is " + name);
    }


}
