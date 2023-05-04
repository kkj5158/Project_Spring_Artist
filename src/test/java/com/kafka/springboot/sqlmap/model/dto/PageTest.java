package com.kafka.springboot.sqlmap.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    @Test
    public void test() {
        Page ph = new Page(250, 1);
        ph.print();
        System.out.println("ph = "+ph);
        assertTrue(ph.getBeginPage()==1);
        assertTrue(ph.getEndPage()==10);
    }

    @Test
    public void test2() {
        Page ph = new Page(250, 11);
        ph.print();
        System.out.println("ph = "+ph);
        assertTrue(ph.getBeginPage()==11);
        assertTrue(ph.getEndPage()==20);
    }

    @Test
    public void test3() {
        Page ph = new Page(255, 25);
        ph.print();
        System.out.println("ph = "+ph);
        assertTrue(ph.getBeginPage()==21);
        assertTrue(ph.getEndPage()==26);
    }

}