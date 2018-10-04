
/*@author Abhishek Sen
 *  isPrime function checks whether n is prime or not returns 1->prime   0->not prime
 *  complexity O(n^0.5)
 *  but n^0.5 is not calculated mathematically to  avoid overhead 
 */
import java.io.*;
class Prime 
{
	static int count;
	static int isPrime(int n) 
	{
		if (n<=1)return 0;
		else if (n==2)return 1;
		int i=2;
		int cn=n;
		for(i=2;i<cn;i++)
		{
			count++;
			if(n%i==0)return 0;
			
			cn=n/i;
		}
		return 1;
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number: ");
		int n=Integer.parseInt(buf.readLine());
		count=0;
		int check=isPrime(n);
		System.out.println(n + "   isPrime> "+(check==1?"true":"false")+"   number of modulo checks: "+count);
		
	}
	
}
