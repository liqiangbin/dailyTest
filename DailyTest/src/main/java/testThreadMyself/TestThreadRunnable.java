package testThreadMyself;

public class TestThreadRunnable implements Runnable{

	public static void main(String[] args) {
      for(int i=0;i<=100;i++){
    	  System.out.println(Thread.currentThread().getName()+i);
    	  if(i==10){
    		  TestThreadRunnable test1=new TestThreadRunnable();
    		  Thread thread1=new Thread(test1,"另开线程1");
    		  thread1.start();
    	  }
    	  if(i==20){
    		  TestThreadRunnable test2=new TestThreadRunnable();
    		  Thread thread2=new Thread(test2,"另开线程2");
    		  thread2.start();
    	  }
      }
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"正在执行");
	}

}
