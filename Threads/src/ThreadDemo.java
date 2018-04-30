/*
 * MultiTasking
 * Process Based MultiTaking( NOT SUPPORTED IN JAVA )
 * Thread Based MultiTasking
 * MultiThreading
 * Why MultiThreading (Parallel Programming)
 * Eg:- Apps, Games.
 * 
 */
//Step 1- Create Job
class Job implements Runnable{
//Step 2- Logic inside run(job logic)	
	@Override
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println(" I is "+i+"Thread name is "+Thread.currentThread().getName());
		}	
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		Job job1 = new Job();//STEP - 3 create job object
		Job job2 = new Job();
		Thread worker = new Thread(job1,"Ram"); //Step - 4 Create worker and assign job
		Thread worker2 = new Thread(job2,"Shyam");
		worker.start();
		worker2.start();	
	}
}