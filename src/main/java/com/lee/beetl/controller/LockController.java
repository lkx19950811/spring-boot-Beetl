package com.lee.beetl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author : lee Cather
 * @date : 2018-11-06 16:04
 * desc :
 */
@RestController
public class LockController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/getLock")
    public void getLock(String id) throws InterruptedException {
        Long count = System.currentTimeMillis() + new Random().nextInt(1000);
        logger.info(count+"等待中 : " + id);
        synchronized (id.intern()){
            logger.info(count + "完成 : " + id);
            Thread.sleep(1000L);
        }
    }
}
