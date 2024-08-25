package com.tom.springnote.chapter06.componentscan2;

import org.springframework.stereotype.Repository;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ScanComponentDomainService.java
 * @Description TODO
 * @createTime 2024年08月16日 19:22:00
 */
@Repository
public class ComponentScanDAO {
    public void scan() {
        System.out.println("ScanComponentDAO#scan()：扫描完成");
    }
}
