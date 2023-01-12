package com.P;


/**
 *   |----Collection接口：  单列的接口， 用来存储一个一个对象， 如果你存的基本数据类型的话， 那么就是自动装箱
 *        |----List接口 : 有序存储，可重复
 *              |----ArrayList： 作为List接口的主要实现类；线程不安全，效率较高；底层使用 Object[] elementData存储
 *              |----LinkedList： 底层使用双向链表， 对于频繁的使用  插入、删除操作使用LinkedList集合效率高
 *              |----Vector： 作为List接口的古老实现类， 也就是很早就出现了，上面的会晚点， 线程安全，但是效率不是很高；底层使用底层使用 Object[] elementData存储， 和ArrayList一样
 *                      它的底层和上面差不多，但是扩容是扩大两倍
 *
 *    ArrayList的源码分析：
 *      jdk7的情况
 *          ArrayList list = new ArrayList();   一开始底层创建了一个长度为10的Object[]  数组
 *          但是你一直add() 添加数据这样就会导致数组长度不够，就需要扩容了，
 *          默认的情况下， 底层会帮你先把数组长度扩容1.5倍，然后创建新的数组， 再然后就是把之前数组里的数据复制到这个新的数组里，这样就相当于扩容好了
 *          但是，还有其他情况的就是，可能扩容之后还是容量还是小于需求的容量， 底层就会帮你把需求的容量直接拿过来用了
 *          最后就是， 也不是能无限扩容的， 如果到达了int的最大范围的话，就是抛异常了
 *
 *          结论：  如果工作中知道大概的容量就直接使用带参的构造器，这样就不用扩容了， 提高了效率
 *
 *      jdk8的情况：
 *          ArrayList list = new ArrayList(); 一开始底层只是创建了 Object[]数组  初始化为{}， 并没有创建长度为10的数组
 *          再第一次使用add() 的时候创建一个长度为是10的数组， 并将add中的数据添加进去
 *          后面就是和上面一样了
 *
 *      jdk8中延迟了数组的创建， 节省了内存
 *
 *
 *
 *     LinkedList的源码分析：
 *          其实就是双向链表， 每添加一个数据，就会创建一个Node对象，这个对象能理解成节点， 每次都是创建了一个节点，然后再连接起来
 *          就是看前节点和后节点是谁，没有就是null
 *
 *
 *
 *     List接口的中常用方法：
 *             add(int index, Object obj)  在index位置上，插入obj值
 *             addAll(int index, Collection coll)  在index位置上， 插入coll集合
 *             get(int index) 获取index位置上的值， 也就是获取指定位置上的值
 *             indexOf(Object obj)  获取obj在集合中首次出现的位置
 *             LastIndexOf(Object obj)  获取obj在集合中最后出现的位置
 *             remove(int index)  移除指定index位置上的元素，并返回这个元素
 *             set(int index, Object obj)  设置指定位置的元素为 obj值
 *             subList(int leftIndex, int rightIndex) 返回从指定位置上的子集合
 */

// Map接口：   双列接口， 用来存储一对一对的数据， 就是键值对的形式， key:value


import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class p {

    @Test
    public void T() {

        Collection collection = new ArrayList();
        ArrayList list = new ArrayList();


        collection.add(1);
        collection.add(2);

        /**
         * add(Object a)  将一个一个数据存进去
         * addAll(Collection a)  将一个集合完整的存进去
         *
         * size()   获取当前集合中的数据的个数
         * isEmpty()   判断当前集合是否为空
         * clear()   清空集合中的元素
         *
         * contains(Object obj)   判断当前集合中有没有包含obj， 如果有就返回true， 这里面使用重写之后的equals比较的也就是比较值不是比较地址
         * containsAll(Collection coll)  判断coll集合中数据是否都在当前的集合中，如果在就返回true
         *
         * remove(Object obj)   移除当前集合中obj，前提是要有， 如果你没有就返回false
         * removeAll(Collection coll) 在当前的集合中删除coll集合
         *
         * retainAll(Collection coll)  相当于求交集， 获取当前集合和coll集合的交集，并返回给当前集合
         *
         * equals(Object obj)  判断当前集合和形参集合的元素是否相同
         *
         * hashCode()  返回当前对象的哈希值
         *
         * toArray()   将集合转化为数组，返回什么类型的数组， 就看你参数是什么类型的集合了
         *
         * Arrays.asList(L...t)  参数是一个可变形参， 而可变形参就像数组，所以可以用这个把数组转变为集合
         *
         * iterator()   返回Iterator接口的实例， 用于遍历集合元素， 每使用一次iterator()  方法就会返回一个新的迭代器，也就是每次又是从头开始的
         *
         */

        Iterator iterator = collection.iterator();  //  这里返回的就是Iterator接口的实例

        // 一般都是这样用得
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /**
         * 通过next获取元素，第一个next(), 获取得就是第一个元素，以此类推
         *
         * next()  指向下一个元素， 刚开始是在头节点位置，头节点的下一个位置才有元先调用next就会指向第一个元素了
         * hasNext()  判断这个迭代器中有没有元素，有的话就会进入循环体， 一开始的话， 是判断头节点的下一个节点有没有值，如果有值就会进入
         *
         *
         */


        // 在集合中有一个循环是  foreach的形式， 就是如下， 当然用数组也是能用的
        //  Obj的类型主要是看collection中元素的类型
        for (Object obj: collection) {
            System.out.println(obj);
        }

        // 数组的写法
        int[] a = new int[]{1, 0, 2};
        for (Object i: a) {
            System.out.println(i);
        }


    }




}
