public class Season {


}


//  当需要定义一组常量时，强烈建议使用枚举类
//  如果枚举类中只有一个对象，则可以作为单列模式的实现方式
//  使用enum关键都是继承了于 java.lang.Enum类的
//         在Enum中有几个方法， toString(), values(), valueOf()
/*
        toString(), 这里如果重写的话， 那就打印的也不是地址，而是而是你调用的常量
        values()方法，  这里是返回的是一个枚举类的数组， 也就是这个数组里存的是，有多少个常量，数组里的值都是枚举常量
        valueOf(String ObjName)   返回枚举类中对象名是objName的对象 ， 如果没找到的就会抛一个异常

 */

/*
        如果枚举类实现一个接口的话，有两种情况
            就是普通的重写这个接口中的方法，但是这样的， 每一个枚举类的对象调用的都是同一个方法了
            还有一个就是在每一个枚举类中重写这个接口中的方法, 如下就行

 */

interface Show {

    void show();
}

enum dalQ implements Show{

    // 1. 提供当前枚举类的对象，多个对象之间用  逗号隔开， 末尾用 分号隔开
    // 这里都是以常量出现的
    SPRING("春天", "春天") {
        @Override
        public void show() {

        }
    };


    private final String name;
    private final String desc;

    // 私有化构造器，因为属性是final的必须要有个初始值， 这时在这里设置初始值
    private dalQ(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }






}
