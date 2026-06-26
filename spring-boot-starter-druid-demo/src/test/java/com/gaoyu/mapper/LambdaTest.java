package com.gaoyu.mapper;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author：
 * @Description:
 * @Date Created in 2026-06-2517:12
 * @Modified By:
 **/
public class LambdaTest {
    @Test
    public void test01() {
        Runnable r = () -> {
            System.out.println("线程执行了。。。");
        };
    }
        @Test
        public void test02() {
            Predicate p = o -> false;
        }
        @Test
        public void test03() {
            Consumer c = o -> System.out.println( o);
        }

        public void test04() {
            Supplier supplier = () -> new Object();
        }
    }

