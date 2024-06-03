package org.example.c2.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 *
 * @author qlk
 */
public class DynamicArray implements Iterable<Integer> {
    /**
     * 逻辑大小
     */
    private int size = 0;

    /**
     * 容量
     */
    private int capacity = 8;

    /**
     * 初始数组
     * 懒惰初始化
     */
    private int[] array = {};
//    private int[] array = new int[capacity];


    /**
     * 向最后一位添加元素
     *
     * @param element
     */
    public void addLast(int element) {
//      array[size] = element;
//      size++;
        add(size, element);
    }

    /**
     * 指定位置添加元素
     */
    public void add(int index, int element) {
        // 扩容检查
        checkAndGrow();

        if (index >= 0 && index < size) {
            System.arraycopy(array, index,
                    array, index + 1,
                    size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 扩容检查
     */
    private void checkAndGrow() {
        // 初始化懒惰
        if (size == 0) {
            array = new int[capacity];
        }
        if (size == capacity) {
            // 扩容倍数, 1.5, 1.618, 2...
            capacity += capacity >>> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0,
                    newArray, 0,
                    size);
            array = newArray;
        }
    }

    /**
     * 指定位置删除元素
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {  // 最后一个元素的删除
            System.arraycopy(array, index + 1,
                    array, index,
                    size - index - 1);
        }
        size--;
        return removed;
    }

    public int get(int index) {
        return array[index];
    }

    /**
     * 遍历方法1,lambda+fori
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方法2,迭代器遍历,实现Iterable接口,重写iterator方法
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            /**
             * 有没有下一个元素
             */
            @Override
            public boolean hasNext() {
                return i < size;
            }

            /**
             * 返回当前元素,并移动到下一个元素
             */
            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3,流
     */
    public IntStream stream() {
//      return IntStream.of(array);  // 会遍历出多余的空元素
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
