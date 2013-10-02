package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3
{
   public static void main(String args[])
   {
      int a, b, x, y, i, i1, i2, i3, r1, r2;
      double sum = 0 ;

      //First matrix ---------------------------------------------------//
      String filename = "H:/Matrix1.txt"; // file that has the first matrix (update path)
      System.out.print("Matrix1 = ");
      a = readingMatrixSizeA(filename);
      System.out.print(" by ");
      b = readingMatrixSizeB(filename);
      System.out.println();

      int first[][] = new int[a][b];
      for ( i = 0 ; i < a ; i++ )
      {
         for ( i1 = 0 ; i1 < b ; i1++ )
         {   first[i][i1] = readingTheMatrix(filename,i,i1);  }
      }
      //----------------------------------------------------------------//


      //Second Matrix---------------------------------------------------//
      filename = "H:/Matrix2.txt"; // file that has the second matrix (update path)
      System.out.print("Matrix2 = ");
      x = readingMatrixSizeA(filename);
      System.out.print(" by ");
      y = readingMatrixSizeB(filename);
      System.out.println();
      if ( b != x )
      {   System.out.println("Matrices multiplication is not possible.");   }
      else
      {
         int second[][] = new int[x][y];
         double result[][] = new double[b][y];
         for ( i2 = 0 ; i2 < x ; i2++ )
         {
            for ( i3 = 0 ; i3 < y ; i3++ )
            {  second[i2][i3] = readingTheMatrix(filename,i2,i3);   }
         }

         // loop for the calculation
         for ( i = 0 ; i < a ; i++ )
         {
            for ( i1 = 0 ; i1 < y ; i1++ )
            {
               for ( i2 = 0 ; i2 < x ; i2++ )
               {    sum = sum + first[i][i2]*second[i2][i1];    }

               result[i][i1] = sum;
               sum = 0;
            }
         }
         //----------------------------------------------------------------//

         System.out.println("Product of entered matrices:");

         for ( i = 0 ; i < a ; i++ )
         {
            for ( i1 = 0 ; i1 < y ; i1++ )
            {   System.out.print(result[i][i1]+"\t");   }
            System.out.print("\n");
         }
      }
   }

   public static int readingMatrixSizeA( String thefile )
    {
    int a=0;
    try {
			// since we don't know the size of the matrix, store the values in an array list
			// so that it will grow automatically as we read in the matrix
			ArrayList< ArrayList< Integer > > dynamicArray = new ArrayList< ArrayList< Integer > >();

			// connect a scanner to the file
			Scanner fileReader = new Scanner(new File(thefile));

			// while there is a row of values to parse
			while(fileReader.hasNext())
            {
				// get the next line of the file
				String input = fileReader.nextLine();
				String[] values = input.split(" ");
				ArrayList< Integer > row = new ArrayList< Integer >();

				for(int index = 0; index < values.length; ++index)
                {row.add(Integer.parseInt(values[index]));}
				dynamicArray.add(row);
			}
            a = dynamicArray.size();

            System.out.print(a);
		}
    catch (FileNotFoundException e)
        {
			System.out.println("Failed to read in file: " + thefile + "!  Reason: " + e.getLocalizedMessage());
        }
    return a;
    }

   public static int readingMatrixSizeB( String thefile )
    {
    int b=0;
    try {
			// since we don't know the size of the matrix, store the values in an array list
			// so that it will grow automatically as we read in the matrix
			ArrayList< ArrayList< Integer > > dynamicArray = new ArrayList< ArrayList< Integer > >();

			// connect a scanner to the file
			Scanner fileReader = new Scanner(new File(thefile));

			// while there is a row of values to parse
			while(fileReader.hasNext())
            {
				// get the next line of the file
				String input = fileReader.nextLine();
				String[] values = input.split(" ");
				ArrayList< Integer > row = new ArrayList< Integer >();
				for(int index = 0; index < values.length; ++index)
                {row.add(Integer.parseInt(values[index]));}
				dynamicArray.add(row);
			}
            b = dynamicArray.get(0).size();
            System.out.print(b);
		}
    catch (FileNotFoundException e)
        {
			System.out.println("Failed to read in file: " + thefile + "!  Reason: " + e.getLocalizedMessage());
        }
    return b;
    }

   public static int readingTheMatrix( String thefile, int a, int b)
    {
    int[][] matrix = new int[0][0];
    try {
			// since we don't know the size of the matrix, store the values in an array list
			// so that it will grow automatically as we read in the matrix
			ArrayList< ArrayList< Integer > > dynamicArray = new ArrayList< ArrayList< Integer > >();

			// connect a scanner to the file
			Scanner fileReader = new Scanner(new File(thefile));

			// while there is a row of values to parse
			while(fileReader.hasNext())
            {
				// get the next line of the file
				String input = fileReader.nextLine();
				String[] values = input.split(" ");
				ArrayList< Integer > row = new ArrayList< Integer >();
				for(int index = 0; index < values.length; ++index)
                {	row.add(Integer.parseInt(values[index]));   }
				dynamicArray.add(row);
			}

			// now that we have the values, and know the dimensions of the array
			// we can create the fixed size in[][]
			matrix = new int[dynamicArray.size()][dynamicArray.get(0).size()];

			// convert the dynamic array into a fixed size int[][]
			for(int row = 0; row < dynamicArray.size(); ++row)
            {
				for(int col = 0; col < dynamicArray.get(0).size(); ++col)
                {
					matrix[row][col] = dynamicArray.get(row).get(col);
				}
                System.out.println();
			}
		}
    catch (FileNotFoundException e)
        {
			System.out.println("Failed to read in file: " + thefile + "!  Reason: " + e.getLocalizedMessage());
        }
    int c = matrix[a][b];
    return c;
    }

   //default constructer
  //  private Matrix()
    {}
}