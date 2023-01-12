package com.P;

import org.junit.Test;

import java.util.*;

public class J {

    /**
     *      |----Collection接口：  单列的接口， 用来存储一个一个对象， 如果你存的基本数据类型的话， 那么就是自动装箱
     *          |--- Set接口：  存储无序，不可重复数据，线程不安全的， 可以存储null
     *              |----HashSet:   作为Set接口的主要实现类
     *                  |----LinkedHashSet： 作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
     *                                        在添加数据的同时， 维护了两个引用，记录数据的前一个数据是什么后一个数据是什么
     *                                        如果进行频繁的遍历操作的话 用LinkedHashSet比用HashSet效率高
     *              |----TreeSet： 可以按照添加对象的指定属性， 进行排序
     *
     *        Set接口中没有额外定义新的方法，也就是使用的都是Collection中声明过的方法
     *
     *       HashSet：
     *          无序性： 不等于随机性， 存储的数据在底层数组中并非按照数组的索引顺序添加的， 而是根据数据的哈希值
     *
     *          不可重复性： 保证添加的元素按照equals() 判断时， 不能返回true， 也就是相同元素只能添加一个
     *
     *
     *       我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法， 计算元素a的哈希值
     *       这个哈希值接着通过某种算法，计算出在数组中索引位置
     *       如果这个位置上没有值，就说明添加成功了
     *       如果这个位置有值，那么就判断这个两个元素的哈希值是否相同，
     *          如果不相同，那么元素a就添加成功
     *          如果相同就调用a元素里的equals()方法
     *              如果返回true，就添加失败
     *              如果返回false， 那么就添加成功
     *
     *       底层就是  数组+链表的结构
     *
     *       如果在HashSet中存放 对象， 那么这个对象一定要重写 equals， 和hashCode方法，
     *       相等的对象，一定要有相等的散列码
     *
     *
     *      自然排序(Comparable),   定制排序(Comparator)
     *
     */


    @Test
    public void T() {

        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add("1212");
        set.add("323");
        for (Object i: set) {
            System.out.println(i);
        }
        Collection collection = new ArrayList();

        int[] a = new int[]{2, 1, 0, -1, 9};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));


        //  以按照添加对象的指定属性， 进行排序
        //  当然要是相同的对象， 如果不是相同的对象， 就会报错
        // 使用Comparator定制排序， 也就是在构造器中传入参数
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        TreeSet treeSet = new TreeSet(com);  //  这样就是定制排序




    }

}
class User implements Comparable{


    //  这里是自然排序，就要实现Comparable接口
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
