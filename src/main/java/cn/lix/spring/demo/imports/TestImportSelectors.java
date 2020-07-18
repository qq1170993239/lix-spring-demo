package cn.lix.spring.demo.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportSelectors implements ImportSelector {

    // 通过@Import向容器注册TestImportSelectors类，会将返回的类名称数组全部交由spring管理
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cn.lix.spring.demo.imports.MyImportBean1", "cn.lix.spring.demo.imports.MyImportBean2"};
    }

}
