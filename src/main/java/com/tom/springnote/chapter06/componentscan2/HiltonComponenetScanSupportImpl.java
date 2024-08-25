package com.tom.springnote.chapter06.componentscan2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ComponenetScanSupportImpl.java
 * @Description TODO
 * @createTime 2024年08月16日 19:31:00
 */
@Component("hiltonComponenetScanSupportImpl")
public class HiltonComponenetScanSupportImpl implements IComponentScanSupport {

    @Autowired
    private ComponentScanDAO scanComponentDAO;

    @Override
    public void scan() {
        System.out.println("希尔顿组件扫描助手");
        scanComponentDAO.scan();
    }
}
