package com.tom.springnote.chapter10;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.io.Resource;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SystemClearnerAspect.java
 * @Description TODO
 * @createTime 2024年08月20日 19:11:00
 */
@Aspect
public class SystemClearnerAspect {

    private Resource resource;

    @After("execution(boolean *.execute(String, ..))")
    public void clearUpResourceIfNeed() throws Throwable {
        if (resource.exists()) {
            // 删除文件
        }
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
