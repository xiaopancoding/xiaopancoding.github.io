package m1;


/*

    我们可以在子类的构造器或方法中使用  super.  来调用父类中属性和方法，
    super  一般就是在重写时使用， 就是父类和子类中有同名的方法， 如果想调用父类的方法就要用super. 了
    super  掉构造器， 和this 差不多，  如果没写，super 会调用父类的空参构造器，  也就是说， 子类一定会掉用一次  父类的构造器
    如果是调用带参的构造器的话， 就是和 this一样了， super()  ， 当然 super  也就只能放在构造器的首位， 也就是说一个构造器只有一个super关键字、
    总的来说 super 其实就是在子类中调用父类的属性， 方法， 构造器的关键字

 */



public class CheckAccount extends Account{   // 这里就是继承的关系， 当前的类为子类

    private int overraft;

    public CheckAccount(int overraft, int id, double balance, double annuallntersRate) {
        super(id, balance, annuallntersRate);  // 这个就是super关键字，

        // 对于这个关键字的理解是： super.属性  或  super.方法  这个就是调用的父类的属性和方法， 如果就是当前的子类中有一个重写的方法， 之后调用这个方法就是重写之后的内容
        // 但是有时候就是还是要用父类的方法， 所以这是就有super关键字了，  这个就是为了让你能调用父类已经在子类中重写的相同的方法
        this.overraft = overraft;
    }




}
