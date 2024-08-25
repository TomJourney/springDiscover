package com.tom.springnote.chapter06.componentscan;

import com.tom.springnote.chapter06.componentscan2.ComponentScanDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName ScanComponentDomainService.java
 * @Description TODO
 * @createTime 2024年08月16日 19:22:00
 */
@Service
public class ComponentScanAppService {

    @Autowired
    private ComponentScanDomainService scanComponentDomainService;

    public void scan() {
        scanComponentDomainService.scan();
    }
}
