package com.tom.srccode.deep.analysis.chapter0501.aop.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 17:56:00
 */
@Slf4j
public class TomAddrBean {

    private String addr = "ChengDu";

    public void test() {
        log.info("addr = {}", addr);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
