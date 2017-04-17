package sort;

import junit.runner.Sorter.Swapper;

public class insertSort {
	/**
	 * 插入排序算法
	 * @param a
	 */
	public static void insertSotr(int[] a){
		
		if(a!=null){
			for(int i=1;i<a.length;i++){
					int j=i;
					int temp=a[i];
					if(a[j-1]>temp){
						 while(j>=1&&temp<a[j-1]){
							 a[j]=a[j-1];
							 j--;
						  }
						 a[j]=temp;
					}
			}
		}
		
		
	}
	
	
	public static void maopaoSort(int[] a){
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}


	
	/**
	 * 快速排序算法
	 * 根据一个标杆值将数组左右划分，然后对左右分别重复递归
	 */
	 public static void quickSort(int[]a,int low,int high){
		 int temp=a[low];
		 int start=low;
		 int end=high;
		 while(start<end){
		 while(start<end&&temp<=a[end]){
			 end--;
		 }
		 if(temp>=a[end]){
			 int extre=a[end];
			 a[end]=a[start];
			 a[start]=extre;
		 }
 
		 while(start<end&&a[start]<=temp){
			 start++;
		 }
		 if(a[start]>=temp){
			 int extre=a[start];
			 a[start]=a[end];
			 a[end]=extre;
		 }
		 		 }
		 System.out.println("start="+start+"|end="+end);
		 if(start>low){
			quickSort(a, low, start-1); 
		 }
		 
		 if(end<high){
			 quickSort(a, start+1, high);
		 }
		 
	 }
	 
	 /**
	  * 希尔排序
	  * @param args
	  */
	 
	 public static void shellSort(int[] a){
		 int len=a.length;
		 int i,j;
		 for(int gap=len/2;gap>0;gap=gap/2){
			 for(i=gap;i<len;i++){
				 for(j=i-gap;j>=0&&a[j]>a[j+gap];j-=gap){
					 int temp=a[j];
					 a[j]=a[j+gap];
					 a[j+gap]=temp;
				 }
			 }
		 }
		 
	 }
	 
	public static void main(String[] args) {
//		int[] a={10,8,3,2,1,4,6,7,0,90,88,5};
//		insertSotr(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]+"|");
//		}
//		System.out.println("");
//		
//		int[] b={10,8,3,2,1,4,6,7,0};
//		maopaoSort(b);//时间复杂度 n*(n-1)
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(b[i]+"|");
//		}
//		System.out.println("");
//		int[] c={5,2,1,4,6,7,0,3};
//		quickSort(c, 0, c.length-1);
//		for (int i = 0; i < c.length; i++) {
//			System.out.print(c[i]+"|");
//		}
//		System.out.println("");
		
		int[]d={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for(int i=0;i<d.length;i++)
        {
            System.out.print(d[i]+" ");
        }
        shellSort(d);
        System.out.println("");
            System.out.println("排序之后：");
                for(int i=0;i<d.length;i++)
                {
                    System.out.print(d[i]+" ");
                }
                
                
                
 
 
   
	}

}
