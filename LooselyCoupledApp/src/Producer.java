
public class Producer implements ShowThings{
	public void uCanSeeMe(){
		System.out.println("You can see me "+add(10, 20));
		
	}
	public void uCantSeeMe(){
		System.out.println("You can't see me");
	}
	int add(int x,int y){ //This function is not visible to consumer but since uCanSeeMe can
						  //call it hence indirectly we can use add funtion for consumer via uCanSeeMe
		return x+y;
	}
	

}
