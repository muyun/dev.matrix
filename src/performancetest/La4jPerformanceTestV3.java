package performancetest;

//author@ wenlong
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.la4j.LinearAlgebra;

import java.io.IOException;
import java.util.Random;


public class La4jPerformanceTestV3 {
	
	public static void main(String args[]) throws Exception {
		Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(2,2) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		
		String stra = a.mkString(";", ",");
		System.out.println("Matrix a is:" + stra);
	 
		TestMatrix[] inputs = new La4jTestMatrix[2];
		inputs[0] =	new La4jTestMatrix(a);
		
		Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(2,2) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		
		String strb = b.mkString(";", ",");
		System.out.println("Matrix b is:" + strb);
		
		inputs[1] =	new La4jTestMatrix(b);
		
		TestMatrix[] outputs = new La4jTestMatrix[1];
		//long numTrials = 0;
		
		PerformanceTest pt = new PerformanceTest();
		long t = pt.add().process(inputs, outputs, 1000);
		
		System.out.println("la4j matrix sum = " + ( (double) t / 1000) + " s");
		
	}

}
