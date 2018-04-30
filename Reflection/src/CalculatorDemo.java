import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Calc{
public int add(int x,int y){
	return x+y;
}
public int subtract(int x,int y){
	return x-y;
}
public int multiply(int x,int y){
	return x*y;
}
public int divide(int x,int y){
	return x/y;
}
Calc(){
	System.out.println("I will call when object is created");
}
static{
	System.out.println("I will call when Class is loaded");
}

}
public class CalculatorDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		System.out.println("add for Addition");
		System.out.println("subtract for Subtraction");
		System.out.println("multiple for Multiplication");
		System.out.println("divide for Division");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the choice");
		String methodName = scanner.next();
		System.out.println("Enter the class name to load");
		String className = scanner.next();
		/*Calc obj = new Calc();*/ //Eager way
		//Class.forName(className); //Load a class
		Object object = Class.forName(className).newInstance();//Lazy way
		Method method=object.getClass().getDeclaredMethod(methodName,int.class,int.class);
		Object result=method.invoke(object, 10,20); //obj.add(10,20);
		System.out.println(result);
		
	}

}
