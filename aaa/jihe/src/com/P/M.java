package com.P;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map接口：双列数据， 存储键值对(key-value)的形式
 *     |---HashMap： 作为Map的主要实现类， 线程不安全，效率高，键值对可以存储null的
 *          |----LinkedHashMap: 保证在遍历map元素时，可以按照添加的顺序实现遍历，  对于频繁的遍历操作，这个实现类效率要高点
 *                      原因： 在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *
 *     |---TreeMap: 保证按照添加的key-value对， 进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                 底层使用的是红黑树
 *
 *     |---Hashtable: 古老的实现类，也就是出现的比较早，线程安全的，效率低， 这里的键值对不能存储null
 *          |----Properties:  常用来处理配置文件。 key和value都是String类型
 *
 *
 *
 * Map结构的理解：
 *      Map中的key: 无序的，不可重复的， 使用set存储所有的key --->  key所在的类要重写equals()和hashCode()方法（以HashMap为例）
 *      Map中的value:  无序的，可重复的， 使用Collection存储所有的value  ---->  value所在的类要重写equals() 方法
 *      一个键值对： key-value构成了Entry
 *      Map中的entry： 无序的， 不可重复的， 使用set存储所有的entry
 *
 *
 * HashMap底层原理:
 *      jdk7的时候：
 *          当new了一个HashMap的对象的时候，底层就会帮你创建一个长度为16的 Entry[] table数组
 *          当经过一系列的put的操作
 *          首先就会先调用， 当前put里的key的类中的 hashCode()方法， 经过某种算法，算出一个哈希值，就得到了这个key在Entry中的索引位置
 *              如果这个索引位置上没有其他的数据， 那么就能直接添加上去，   ----->  情况一
 *              如果这个位置上有其他的数据，（就意味着，这个位置上存在一个或多个（一链表的形式存储的）， 就比较当前这个位置上数据的哈希值和这个链表上的哈希值）
 *                  如果当前键的哈希值和这个位置上的键的哈希值和链表上的哈希值都不相同的话， 那么就添加成功了  ----->  情况二
 *                  如果当前键的哈希值和这个位置上的键的哈希值和链表上的哈希值都相同的话， 就调用，这个类的 key1.equals(key2)
 *                      如果返回false， 则添加成功   ----->  情况三
 *                      如果返回true， 则就说明存在一个相同的键， 那么就会把当前的这个键的值， 替换这个相同键的值， 也就是相当于是修改这个键
 *
 *          在不断添加数据的过程情况， 就会涉及扩容的情况， 默认的扩容方法：  扩容2倍， 并将原来的数据复制到新的里面
 *
 *     jdk8的时候
 *  *          1. new一个HashMap的时候： 底层没有直接创建一个长度为16的数组，
 *  *          2. jdk8中， 底层的数组是 Node[]， 而非Entry[]
 *  *          3. 首次调用put方法时， 底层创建一个长度16的数组， 也就是在存放数据时，创建数组， 节省了内存
 *  *          4. jdk7 底层结构只有 数组+ 链表，   jdk8中， 数组+链表+红黑树
 *  *              当数组的某个索引位置上的元素以链表形式存在的数据个数 > 8 并且 当前数组的长度 > 64时，
 *  *              此时 此索引位置上的元素数据改为使用红黑树存储
 *
 *
 */


public class M {


    @Test
    public void G() {

        Map map = new HashMap();

        /**
         *  put(Object key, Object value)   将指定的键值对存放map中
         *  putAll(Map m)  将m中的所有key-value对 存放当前map中
         *  remove(Object key)  通过指定的键， 删除这个键值对，并返回这个键的值
         *  clear()   清空当前map中的所有数据
         *  size()   返回有多少一个键值对
         *
         *
         *  get(Object key)   获取指定的key的值
         *  boolean containsKey(Object key)   判断是否包含指定的key
         *  boolean containsKey(Object value)  判断是否含有指定的value
         *
         *
         *  isEmpty()    判断当前的map是否为空
         *  Set keySet()    返回所有key构成的Set集合
         *  Collection values() 返回所有value构成的Collection集合
         *  Set entrySet   返回所有key-value对 构成的集合
         *
         *
         *
         */




    }

}
