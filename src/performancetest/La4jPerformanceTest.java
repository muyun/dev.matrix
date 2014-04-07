package performancetest;

//author@ wenlong
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.la4j.LinearAlgebra;

import java.io.IOException;
import java.util.Random;

public class La4jPerformanceTest {
	//public static final int SIZE = 10;
	
	public static void matrixOperations() {
		// data initialization
		Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		String stra = a.mkString(";", ",");
		System.out.println("Matrix a is:" + stra);
		
		Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		String strb = b.mkString(";", ",");
		System.out.println("Matrix b is:" + strb);
		
		// operations
		long t1= System.currentTimeMillis(); //returns the current time in milliseconds
		Matrix c = a.add(b);
		long t2 = System.currentTimeMillis();
		
		String strc = c.mkString(";", ",");
		System.out.println("Sum is:" + strc);
		
		System.out.println("laej matrix sum = " + ( (double)(t2 - t1)/1000) + " s");
		
		
	}
	
	public static void main(String args[]) throws Exception {
		matrixOperations();
	}

}
