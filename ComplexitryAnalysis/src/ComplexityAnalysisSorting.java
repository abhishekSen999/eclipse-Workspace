package src;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;

public class ComplexityAnalysisSorting
{
	static String sortingAlgorithm[];
	static int axisNoOfElements[];
	static double axisNoOfComparisons[][];
	
		public static void main(String args[])throws IOException
		{
			
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
			int gap=10, testCases=20,range=100*gap,index=0;
			sortingAlgorithm= new String[] {"Bubble","Insertion","Quick","Merge"};
			axisNoOfElements=new int[range/gap+1]; 
			axisNoOfComparisons=new double[sortingAlgorithm.length][range/gap+1];
			System.out.println("Please wait.....");
			for(int i=0;i<=range;i+=gap)
			{
				int testElements[]=new int[i];
				int sumBubble=0,sumInsertion=0,sumMerge=0,sumQuick=0;
				for(int j=0;j<testCases;j++)
				{
					assignElements(testElements,i);
					//calculation
					sumQuick+=quickSortInitiate(testElements,i);
					System.out.println("Please wait.....quick: "+i);
					
					//sumBubble+=bubbleSort(testElements,i);
					System.out.println("Please wait.....bubble: "+i);
					sumInsertion+=insertionSort(testElements,i);
					System.out.println("Please wait.....insertion: "+i);
					
					sumMerge+=mergeSort(testElements,0,testElements.length-1);
					System.out.println("Please wait.....merge: "+i);
					
				}
				
				
				//average 
				double avgBubble=(double)sumBubble/testCases;
				double avgInsertion=(double)sumInsertion/testCases;
				double avgQuick=(double)sumQuick/testCases;
				double avgMerge=(double)sumMerge/testCases;
				
				//for plotting
				axisNoOfElements[index]=i;
				axisNoOfComparisons[0][index]=avgBubble;
				axisNoOfComparisons[1][index]=avgInsertion;
				axisNoOfComparisons[2][index]=avgQuick;
				axisNoOfComparisons[3][index]=avgMerge;
				
				
				index++;
				
				//System.out.println("number of elements= "+i+"  average number of comparisons= "+avgBubble);
			}
			plot();
		}
		static void assignElements(int ar[],int n)
		{
			int collision[]=new int [10*n];
			for(int i=0;i<10*n;i++)collision[i]=0;
			for(int i=0;i<n;i++)
			{
				int flag=0;
				while(flag==0)
				{
					int k=((int)(Math.random()*11111*n))%(10*n);
					if(collision[k]==0)
					{
						flag=1;
						ar[i]=k;
						collision[k]++;
					}
				}
				
			}
		}
		static int bubbleSort(int ar[],int n)
		{
			//copying
			int arr[]=new int[n];
			for(int i=0;i<n;i++)arr[i]=ar[i];
			
			int cntCmp=0;
			for(int i=0;i<n-1;i++)
			{
				for(int j=0;j<n-i-1;j++)
				{
					cntCmp++;
					if(arr[j]>arr[j+1])
					{
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
				}	
			}

			return cntCmp;
		}
		static int insertionSort(int ar[],int n)
		{
			//copying
			int arr[]=new int[n];
			for(int i=0;i<n;i++)arr[i]=ar[i];
			
			int cntCmp=0;
			for(int i=1;i<n;i++)
			{
				int j=i-1;
				int temp=arr[i];
				
				while(j>=0 && arr[j]>temp)
				{
					cntCmp+=2;
					
					arr[j+1]=arr[j--];
				}
				arr[j+1]=temp;
			}
			
			return cntCmp;
			
		}
		static int quickSortInitiate(int ar[],int n)
		{
			//copying
			int arr[]=new int[n];
			for(int i=0;i<n;i++)arr[i]=ar[i];
			
			
			//for(int i=0;i<n;i++)System.out.print(" "+arr[i]);
			//System.out.println("");
			
			return quickSort(arr,0,n-1);
		}
		static int quickSort(int ar[],int low,int high)
		{
			int cnt=0;
			int rtrn[]= {0,-1};//rtrn array stores the no of comparisons for partition function at index->0 & pivot at index->1 as two values cannot be returned by a function
			if (low<high)
			{
				
				partition(ar,low,high,rtrn);
				//System.out.println("low: "+low+" high: "+high);
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

		static int mergeSort(int arr[],int l,int u)
		{
			int c=0;
			int m=(l+u)/2;
			if(l<u)
			{
				
				c+=mergeSort(arr,l,m);
				c+=mergeSort(arr,m+1,u);
			}
			c+=merge(arr,l,m,u);
			return c;
		}
		static int merge(int arr[],int l, int m, int u )
		{
			int cmp=0;
			int tmp[]=new int[u-l+1];
			int i=0,j=l,k=m+1;
			for(i=0;i<tmp.length;i++)
			{
				if(j<=m&&k<=u  && arr[j]<arr[k]) {cmp+=2;tmp[i]=arr[j++];}
				else if(j<=m&&k<=u) { cmp+=4;tmp[i]=arr[k++];}
				else if(j<=m) {cmp+=5; tmp[i]=arr[j++];}
				else {cmp+=5; tmp[i]=arr[k++];}
				
			}
			
			for(j=l,i=0;j<=u;j++,i++)
			{
				arr[j]=tmp[i];
			}
			return cmp;
		}

		
		
		static void plot()throws IOException
		{
			HSSFWorkbook workbook=new HSSFWorkbook();
			
			/*for (int j = 0; j < sortingAlgorithm.length; j++) 
			{
				HSSFSheet sheet = workbook.createSheet(sortingAlgorithm[j]);
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("No.Of Elements");
				cell = row.createCell(1);
				cell.setCellValue("No.OfComparisons");
				for (int i = 0; i < axisNoOfElements.length; i++) {
					row = sheet.createRow(i + 1);
					cell = row.createCell(0);
					cell.setCellValue(axisNoOfElements[i]);
					cell = row.createCell(1);
					cell.setCellValue(axisNoOfComparisons[j][i]);
				} 
			}*/
			
			HSSFSheet sheet=workbook.createSheet("Complexity Comparison");
			HSSFRow row=sheet.createRow(0);
			HSSFCell cell=row.createCell(0);
			cell.setCellValue("no of elements");
			for(int j=0;j<sortingAlgorithm.length;j++)
			{
				cell=row.createCell(j+1);
				cell.setCellValue(sortingAlgorithm[j]);
			}
			for (int i = 0; i < axisNoOfElements.length; i++) {
				row = sheet.createRow(i + 1);
				cell = row.createCell(0);
				cell.setCellValue(axisNoOfElements[i]);
				for(int j=0;j<sortingAlgorithm.length;j++)
				{
					cell = row.createCell(j+1);
					cell.setCellValue(axisNoOfComparisons[j][i]);
				}
			} 
			
				
			
			
			
			
			workbook.write(new FileOutputStream("ComplexityData.xls"));
			workbook.close();
			System.out.println("done");
		}

}
