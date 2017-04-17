package testThreadMyself;

public class TestThread extends Thread{
	private Thread t;
	private String name;
   public  TestThread(String name){
	  this.name=name;
   }
	public static void main(String[] args) {
		for (int i = 0; i <100; i++) {
			if(i==5){
				TestThread thread1=new TestThread("thread1");
				thread1.start();
			}
			if(i==6){
				TestThread thread2=new TestThread("thread2");
				thread2.start();
			}
			System.out.println("main执行"+i);
		}

	}
	public void run(){
	System.out.println(Thread.currentThread().getName()+"正在运行！");	
	}
	
	public void start(){
		System.out.println("开始创建Thread:"+name);
		t=new Thread(this, name);
		t.start();
	}
	

}
