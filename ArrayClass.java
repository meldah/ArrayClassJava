import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;



public class ArrayClass 
{
	private int dimension;
	private int[][] elements; 
	//default constructor
	//creates a zero 1x1 array
	public ArrayClass()
	{
		dimension = 1;
		elements = new int[dimension][dimension];
	}
	
	//constructor with one parameter
	//creates an empty array 
	public ArrayClass(int m)
	{
		dimension = m;
		elements = new int[dimension][dimension];
	}
	
	//constructor with three parameters
	//creates an m by m array filled with num
	public ArrayClass(int m, int num)
	{
		dimension = m;
		elements = new int[dimension][dimension];
		for (int i=0; i<dimension; i++) 
		{
			for (int j=0; j<dimension; j++) 
		    {
				elements[i][j] = num;
		    }
		}
	}
	//print array
	public void printArr()
	{
		for(int i = 0; i < this.dimension; i++)
		{
			for(int j = 0; j < this.dimension; j++)
			{
				System.out.print(elements[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	/**
     * Fills array with user input integers
     */
    public void fillArray() 
    {
    	System.out.println("Enter the " + dimension + " numbers now.");
    	Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < dimension; i++ ) 
        {
        	System.out.println("Enter " + dimension + " numbers for row " + (i+1) + " now.");
        	for(int j = 0; j < dimension; j++)
        	{
        		this.elements[i][j] = input.nextInt();
        	}
        }
        //input.close();
        System.out.println("These are the numbers you have entered.");
    }
    //
    public static boolean isEmpty(ArrayClass arr)
    {
    	for(int i = 0; i<arr.dimension; i++)
    	{
    		for(int j = 0; j<arr.dimension; j++)
    		{
    			if(arr.elements[i][j]!=0)
    			{
    				return false;
    			}
    		}
    		
    	}
		return true;
    	
    	
    }
	//find sum of rows
	public int[] sumOfRows()
	{
		int size = this.dimension;
		int[] b = new int[size];
		for(int i = 0; i < size; i++)
		{
			int sumRow = 0;
			for(int j = 0; j < size; j++)
			{
				sumRow += this.elements[i][j];
			}
			b[i] = sumRow;
		}
		
		return b; 
	}
	
	// Function to calculate sum of each column 
	public int[] sumOfCols() 
	{ 
		int size = this.dimension;
		int[] c = new int[size];
	  
	    // finding the column sum 
	    for (int i = 0; i < size; ++i) 
	    { 
	    	int sumCol = 0;
	        for (int j = 0; j < size; ++j) 
	        { 
	            sumCol += this.elements[j][i]; 
	        }   
	        c[i]=sumCol;
	    } 
	    return c;
	} 
	//find the row the max sum of numbers
	public static int maxNumInRow(int[] b)
	{
		int maxSum = b[0];
		for(int i = 1; i < b.length; i++)
		{
			if(b[i] > maxSum)
			{
				maxSum = b[i];
			}
				
		}
		return maxSum;
	}
	//find the row the min sum of numbers
		public static int minNumInRow(int[] b)
		{
			int minSum = b[0];
			for(int i = 1; i < b.length; i++)
			{
				if(b[i] < minSum)
				{
					minSum = b[i];
				}
					
			}
			return minSum;
		}
		//find the column with the max sum of numbers
		public int maxNumInCol(int[] c)
		{
			int maxSum = c[0];
			for(int i = 1; i < c.length; i++)
			{
				if(c[i] > maxSum)
				{
					maxSum = c[i];
				}
					
			}
			return maxSum;
		}
		//find the column with the min sum of numbers
		public int minNumInCol(int[] c)
		{
			int minSum = c[0];
			for(int i = 1; i < c.length; i++)
			{
				if(c[i] < minSum)
				{
					minSum = c[i];
				}
						
			}
			return minSum;
		}
		//print array to file
		public void printToFile()
		{
			int size = this.dimension;
			try (PrintStream output = new PrintStream(new File("output.txt"));) 
			{
				for (int i = 0; i < size; i++) 
		        {
					String s= "";
					for (int j = 0; j < this.elements[i].length; j++) 
		           	{
						s+= "|" + this.elements[i][j] + "\t";
		           	}
					s+="|";
		           	output.println(s);
		        }
		        output.close();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}	
		}
	public static void readFromFile(ArrayClass rf) throws FileNotFoundException
	{
	    try 
	    {
	        Scanner input = new Scanner(new File("input.txt"));
	        while (input.hasNextLine()) 
	        {
	        	for (int i = 0; i < rf.dimension; i++) 
	            {
	                for (int j = 0; j < rf.dimension; j++) 
	                {
	                   try
	                   {
	                	   rf.elements[i][j] = input.nextInt();
	                    }
	                   catch (java.util.NoSuchElementException e) 
	                   {
	                       e.printStackTrace();
	                    }
	                }
	            }
	        }
	        //input.close();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	    
	}
	// returns the transpose of  matrix object
	public ArrayClass transpose() 
	{
		ArrayClass t = new ArrayClass(dimension);
		for (int i = 0; i<dimension; i++) 
		{
			for (int j = 0; j<dimension; j++) 
			{
				t.elements[j][i] = this.elements[i][j];
		    }
		}
		return t;
	}
	
	//
	public ArrayClass diagonal()
	{
		ArrayClass diag = new ArrayClass(dimension);
		int k,j;
		for(int i=0; i<dimension;i++)
		{
			if(dimension>1)
			{
				k = 0;
				j = i;
			}
			else
			{
				k = i;
				j = 0;
			}
			diag.elements[i][k] = this.elements[i][j];
		}
		return diag;
	}

    // Return the matrix newMatrix = m1 + m2
	public ArrayClass add(ArrayClass m1, ArrayClass m2)
	{

		ArrayClass newMatrix=new ArrayClass(m1.dimension);
	    if ((m1.dimension == m2.dimension)) 
	    {
	      for (int i=0; i<newMatrix.dimension; i++) 
	      {
			for (int j=0; j<newMatrix.dimension; j++) 
			{
				newMatrix.elements[i][j] = m1.elements[i][j] + m2.elements[i][j]; 
			}
	      }
	    }
	    else
	    {
	    	System.out.println("Arrays cannot be added because of different dimensions.");
	    }
	    return newMatrix;
	  }
	
	// Return the matrix newMartix = m1 - m2
	public ArrayClass subtract(ArrayClass m1, ArrayClass m2)
	{
		ArrayClass newMatrix=new ArrayClass(m1.dimension);
		if ((m1.dimension == m2.dimension)) 
		{
			for (int i=0; i<newMatrix.dimension; i++) 
			{
				for (int j=0; j<newMatrix.dimension; j++) 
				{
					newMatrix.elements[i][j] = m1.elements[i][j] - m2.elements[i][j]; 
				}
			}
		}
		else
	    {
	    	System.out.println("Arrays cannot be subtracted because of different dimensions.");
	    }
		   
		return newMatrix;
	}
	
	
	// Return the array  = number*m1
	public static ArrayClass multiply(int number, ArrayClass m1)
	{
	    ArrayClass newMatrix=new ArrayClass(m1.dimension);
	    for (int i=0; i<newMatrix.dimension; i++) 
	    {
	      for (int j=0; j<newMatrix.dimension; j++) 
	      {
	    	  newMatrix.elements[i][j] = number * m1.elements[i][j];
	      }
	    }
	    return newMatrix;
	  }
	
	//returns the element with max value from array
	public int maxElement() 
	{
		int max = this.elements[0][0];
	    for (int i = 0; i<dimension; i++) 
	    {
	    	for (int j = 0; j<dimension; j++) 
	    	{
	    		if(this.elements[i][j] > max)
	    		{
	    			max = this.elements[i][j];
	    		}
	    	}
	    }
	    return max;
	}
	
	//returns the element with min value from array
	public int minElement()
	{
		int min = this.elements[0][0]; 
		for(int i = 0; i<dimension; i++)
		{
			for(int j = 0; j<dimension; j++)
			{
				if(this.elements[i][j] < min)
				{
					min = this.elements[i][j];
				}
			}
		}
		return min;
	}
	//returns the sum off all the elements in the array
	public int sumElements() 
	{
	    int sum = 0;
	    for (int i = 0; i<dimension; i++) 
	    {
	    	for (int j = 0; j<dimension; j++) 
	    	{
	    		sum += this.elements[i][j];
	    	}
	    }
	    return sum;
	}
	
	//returns the average of all the elements in the array
	public double average() 
	{
	    double av = 0;
	    for (int i = 0; i<dimension; i++) 
	    {
	    	for (int j = 0; j<dimension; j++) 
	    	{
	    		av += this.elements[i][j];
	    	}
	    }
	    return av/(dimension*dimension);
	} 
	

	public static void main(String[] args)
	{
		int num;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the dimension of array:");
        num = input.nextInt();
        input.nextLine();
        //create an array with user input size
        ArrayClass newArr = new ArrayClass(num);
        newArr.fillArray();
        //
        System.out.println("Array:");
        newArr.printArr();
        //
        System.out.print("Element with maximum value: ");
        int maxElem = newArr.maxElement();
        System.out.println(maxElem);
        //
        System.out.print("Element with minimum value: ");
        int minElem = newArr.minElement();
        System.out.println(minElem);
        //
        System.out.print("Sum of all elements of array: ");
        int sum = newArr.sumElements();
        System.out.println(sum);
        //
        System.out.print("Average of all elements of array: ");
        double average = newArr.average();
        System.out.println(String.format("%.2f", average));
        //
        newArr.printToFile();
        System.out.println("Array is printed to file - output.txt!");
        //
        System.out.println("Please enter the exact dimension of array which will be read from file: ");
        int numRead=0;
        if(input.hasNextLine())
        {
      	   	numRead = input.nextInt();
        }
        ArrayClass readArr = new ArrayClass(numRead);
        try 
        {
			readFromFile(readArr);
		} 
        catch (FileNotFoundException e) 
        {
			e.printStackTrace();
		}
        //
        System.out.println("Array from file:");
        readArr.printArr();
        //
        System.out.println("Sum of the two arrays:");
        ArrayClass arrAdd = new ArrayClass(num);//dimension or
        arrAdd = arrAdd.add(newArr, readArr);
        if(!isEmpty(arrAdd))
        {
        	arrAdd.printArr();
        }
        //
        System.out.println("Substraction of the two arrays:");
        ArrayClass arrSubstact = new ArrayClass(num);//dimension or
        arrSubstact = arrSubstact.subtract(newArr, readArr);
        if(!isEmpty(arrSubstact))
        {
        	arrSubstact.printArr();
        }
        //Sum of rows in newArr
        System.out.println("Sum of rows:");
        int[] rowSum = new int[newArr.dimension];
        rowSum = newArr.sumOfRows();
        for(int i = 0; i < rowSum.length - 1; i++)
        {
        	System.out.print(rowSum[i] + " ");
        }
        System.out.println(rowSum[rowSum.length - 1]);
        
        //Sum of columns in newArr
        System.out.println("Sum of columns:");
        int[] colSum = new int[newArr.dimension];
        colSum = newArr.sumOfCols();
        for(int i = 0; i < colSum.length - 1; i++)
        {
        	System.out.print(colSum[i] + " ");
        }
        System.out.println(colSum[colSum.length - 1]);
        //
        System.out.println("Maximum value of row sums:");
        int maxValR = maxNumInRow(rowSum);
        System.out.println(maxValR);
        //
        System.out.println("Minimum value of row sums:");
        int minValR = minNumInRow(rowSum);
        System.out.println(minValR);
        //
        System.out.println("Maximum value of column sums:");
        int maxValC = maxNumInRow(colSum);
        System.out.println(maxValC);
        //
        System.out.println("Minimum value of column sums:");
        int minValC = minNumInRow(colSum);
        System.out.println(minValC);
        
        input.close();
}
}

