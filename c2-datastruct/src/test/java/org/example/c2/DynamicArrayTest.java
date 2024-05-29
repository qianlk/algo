package org.example.c2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author qlk
 */
class DynamicArrayTest {
    @Test
    @DisplayName("测试添加")
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
//        dynamicArray.addLast(5);

        dynamicArray.add(2, 5);

        assertEquals(1, dynamicArray.get(0));
        assertEquals(2, dynamicArray.get(1));
        assertEquals(5, dynamicArray.get(2));
        assertEquals(3, dynamicArray.get(3));
        assertEquals(4, dynamicArray.get(4));
    }

    @Test
    @DisplayName("测试遍历1")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.foreach(System.out::println);

//        ResultCollector consumer = new ResultCollector();
//        dynamicArray.foreach(consumer);
//        consumer.test(List.of(1, 2, 3, 4));

    }

//    static class ResultCollector implements Consumer<Integer> {
//        List<Integer> list = new ArrayList<>();
//
//        public void accept(Integer element) {
//            list.add(element);
//        }
//
//        public void test(List<Integer> expected) {
//            assertIterableEquals(expected, list);
//        }
//    }

    @Test
    @DisplayName("测试遍历2")
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        // 增强for循环,内部就是在调用迭代器
        for (Integer ele : dynamicArray) {
            System.out.println(ele);
        }
        assertIterableEquals(List.of(1, 2, 3, 4), dynamicArray);
    }

    @Test
    @DisplayName("测试遍历3")
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.stream().forEach(System.out::println);

        assertArrayEquals(new int[]{1, 2, 3, 4},
                dynamicArray.stream().toArray());
    }

    @Test
    @DisplayName("测试删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(4);

        assertEquals(5, removed);
        assertIterableEquals(List.of(1, 2, 3, 4), dynamicArray);
    }

    @Test
    @DisplayName("测试扩容")
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        assertIterableEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                dynamicArray
        );
    }

}