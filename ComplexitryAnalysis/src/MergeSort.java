package src;
import java.io.*;
public class MergeSort {
	public static void main(String args[])throws IOException
	{
		int [] arr= {13,9,8,7,111,70,10,15,11,14};
		//int c=mergeSort(arr,0,arr.length-1);
		//int arr[]=new int[100];
		//assignElements(arr,100);
		int c=quickSort(arr,0,arr.length-1);
		System.out.println("comparisons = "+c);
		for(int i=0;i<arr.length;i++)System.out.println(arr[i]);
	}
	static void assignElements(int ar[],int n)
	{
		for(int i=0;i<n;i++)
		{
			ar[i]=(int)(Math.random()*(n+1)*10);
		}
	}
	
	static int quickSort(int ar[],int low,int high)
	{
		int cnt=0;
		int rtrn[]= {0,-1};//rtrn array stores the no of comparisons for partition function at index->0 & pivot at index->1 as two values cannot be returned by a function
		if (low<high)
		{
			
			partition(ar,low,high,rtrn);
			System.out.println("low: "+low+" high: "+high);
			cnt+=rtrn[0];
			int pivot=rtrn[1];
			cnt+=quickSort(ar,low,pivot-1);
			cnt+=quickSort(ar,pivot+1,high);
		}
		return cnt;
		
	}
	static void partition(int ar [],int low, int high, int rtrn[])// function to place pivot(first) element of the array in it's correct position, as in sorted array 
	{
		int cnt=0;
		int pivot=ar[low];
		int l=low,h=high;
		while(l<h)
		{
			//System.out.println("partition l= "+l+" h= "+h+"  ar[l]: "+ar[l]+"  ar[h]: "+ar[h]+ "  ar[pivot]: "+ar[pivot]);
			
			while( ar[l]<pivot) 
			{
				cnt++;
				l++;
			}
			
			while (ar[h]>pivot) 
			{
				cnt++;
				h--;
			}
			
			if(l<h)// swap
			{
				
				int temp=ar[l];
				ar[l]=ar[h];
				ar[h]=temp;
			}
			
		}
		
		ar[low]=ar[h];
		ar[h]=pivot;
		int pivotPos=h;
		rtrn[0]=cnt;
		rtrn[1]=pivotPos;
		
	}



	
	

}