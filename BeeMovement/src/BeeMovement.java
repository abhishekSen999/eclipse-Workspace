import java.io.*;
public class BeeMovement 
{
	static int xyzMap[]= {1,-1,1,-1,1,-1};// array states the map (+x,-x,+y,-y,+z,-z)
	static int direction[]= {0,0,0,0,0,0};// array states the direction in which the bee will move, among the six directions any one direction is randomly chosen and that value is made 1 
	static int xyzIniPos[]= {0,0,0};// states the initial position of the bee
	static int xyzFinPos[]= {0,0,0};// states the final position of the bee
	static double xMean=0.0;// stored the mean distance over all the cases
	static double standardDeviation=0.0;// stores the standard deviation
	public static void main(String[] args)throws IOException
	{
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number of steps: ");
		int noOfSteps=Integer.parseInt(buf.readLine());// number of steps the bee will move 
		System.out.print("enter the no of cases over which mean and deviation has to be calculated: ");
		int noOfCases=Integer.parseInt(buf.readLine());// the number of cases over which the mean and standard deviation will be calculated
		System.out.println("Initial position of the bee is (x,y,z)=(0,0,0)");
		double x[]=new double[noOfCases];// stores the distances after movement for all the cases
		
		for(int i=0;i<noOfCases;i++)
		{
			for(int j=0;j<noOfSteps;j++)
			{
				int rnd=random();//generating a random number between 0-5
				direction[rnd]=1;
				for(int k=0,fp=0;k<6;k=k+2,fp++)
				{
					xyzFinPos[fp]+=xyzMap[k]*direction[k]+xyzMap[k+1]*direction[k+1];
				}
				direction[rnd]=0;
				//System.out.println("("+xyzFinPos[0]+","+xyzFinPos[1]+","+xyzFinPos[2]+")");
			}
			//System.out.println();
			x[i]=distance();
			xMean+=x[i];
			for(int init=0;init<3;init++)xyzFinPos[init]=0;
		}
		xMean=xMean/noOfCases;
		//calculating standard deviation
		
		for(int i=0;i<noOfCases;i++)
		{
			standardDeviation+=Math.pow(x[i]-xMean,2);
		}
		standardDeviation=standardDeviation/(noOfCases-1);
		standardDeviation=Math.sqrt(standardDeviation);
		System.out.println("Mean: "+xMean);
		System.out.println("Standard Deviation: "+standardDeviation);
		
		
	}
	static double distance()// calculated distance from xyzIniPos to xyzFinPos using 3D co-ordinate geometry formulae
	{
		double d=0.0;
		double sum=0.0;
		for(int i=0;i<3;i++)
		{
			 sum+=Math.pow(xyzFinPos[i]-xyzIniPos[i], 2);
		}
		d=Math.sqrt(sum);
		return d;
	}
	static int random()// returns a random number between 0-5
	{
		int rnd=0;
		while (true)
		{
			rnd=((int)((double)Math.random()*10))%6;
			if((double)Math.random()<0.5)break;
		}
		return rnd;
	}

}
