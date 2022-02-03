package test;

class A {
	
	public void foo() {
		System.out.println("A foo");
	}
	
}

class B extends A {
	
	public void bar() {
		System.out.println("B bar");
	}
}


public class TestClass {
	public static void main(String[] args) {
	  A a = new A();
	  B b = (B) a;
	}
}