package com.imooc;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){
     logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }
}
