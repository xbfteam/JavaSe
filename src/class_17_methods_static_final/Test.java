package class_17_methods_static_final;
/**
 *	test static
	myclass static
	person static
	person Test
	test constructor
	person MyClass
	myclass constructor
 */
/**
 *类似地，我们还是来想一下这段代码的具体执行过程。
 *首先加载Test类，因此会执行Test类中的static块。接着执行new MyClass()，
 *而MyClass类还没有被加载，因此需要加载MyClass类。在加载MyClass类的时候，
 *发现MyClass类继承自Test类，但是由于Test类已经被加载了，所以只需要加载MyClass类，
 *那么就会执行MyClass类的中的static块。在加载完之后，就通过构造器来生成对象。
 *而在生成对象的时候，必须先初始化父类的成员变量，
 *因此会执行Test中的Person person = new Person()，而Person类还没有被加载过，
 *因此会先加载Person类并执行Person类中的static块，接着执行父类的构造器，
 *完成了父类的初始化，然后就来初始化自身了，
 *因此会接着执行MyClass中的Person person = new Person()，最后执行MyClass的构造器。
 */
public class Test {
    Person2 person = new Person2("Test");
    static{
        System.out.println("test static");
    }
     
    public Test() {
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person2{
    static{
        System.out.println("person static");
    }
    public Person2(String str) {
        System.out.println("person "+str);
    }
}
 
 
class MyClass extends Test {
    Person2 person = new Person2("MyClass");
    static{
        System.out.println("myclass static");
    }
     
    public MyClass() {
        System.out.println("myclass constructor");
    }
}
