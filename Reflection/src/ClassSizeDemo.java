import java.lang.instrument.Instrumentation;

class T{
	
}

class T1{
	int x;
}

class T2{
	String w;
}

class T3{
	int e; 
	String w;
}

public class ClassSizeDemo {

	public static void premain(String a,Instrumentation ins){
		System.out.println("Premain call");
		System.out.println("T size"+ins.getObjectSize(new T()));
		System.out.println("T1 size"+ins.getObjectSize(new T1()));
		System.out.println("T2 size"+ins.getObjectSize(new T2()));
		System.out.println("T3 size"+ins.getObjectSize(new T3()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main call");
	}

}
