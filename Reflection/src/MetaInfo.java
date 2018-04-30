import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class RR{
	private int p;
	static int m;
	public int t;
	public int l;
	public void print(){
		System.out.println("Print Call");
	}
	private void display(){
		System.out.println("Display call");
	}
}
public class MetaInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int publicCount = 0;
		int privateCount=0;
		int staticCount=0;
		RR obj = new RR();
		Class cls = obj.getClass(); //Meta+Data
		//Class cls = RR.class; Meta
		Method methods[] =cls.getDeclaredMethods();
		for(Method method:methods){
			/*method.setAccessible(true);*/
			System.out.println(method.getName());
		}
		Field fields[] =cls.getDeclaredFields();
		for(Field field: fields){
			int mod = field.getModifiers();
			/*field.setAccessible(true);*/
			System.out.println("Mod"+mod);
			if(Modifier.isPublic(/*field.getModifiers()*/mod)){
				publicCount++;
				
			}
			else if(Modifier.isPrivate(/*field.getModifiers()*/mod)){
				privateCount++;
			}
			else if(Modifier.isStatic(/*field.getModifiers()*/mod)){
				staticCount++;
				
			}
			System.out.println(field.getName());
			System.out.println("Static are"+staticCount);
			System.out.println("Private are"+privateCount);
			System.out.println("Public are"+publicCount);
		}	
	}	
}