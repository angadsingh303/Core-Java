import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

class MyClass{
	public void show(){
		System.out.println("Show...");
	}
}
public class ByteCodeInjections {

	public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		// Step-1 Load the Pool (Perm Space)
		 ClassPool pool = ClassPool.getDefault();
		 // Step-2 Get the class from perm space
		 CtClass cc = pool.get("MyClass"); 
		 //Step-3 Create the method dynamically
		 CtMethod m = CtNewMethod.make("public void print() { "
				 +"System.out.println(\"this is print call....\"); }", cc);
		 cc.addMethod(m);
		 System.out.println(cc);
		// cc.writeFile();
		 Class objClass = cc.toClass(); 
		 Object object = objClass.newInstance();
		 Method method = object.getClass().getDeclaredMethod("print",null);
		 method.invoke(object, null);
		 System.out.println(objClass);	 
	}
}
