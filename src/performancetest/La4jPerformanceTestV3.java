package performancetest;

//author@ wenlong
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.la4j.LinearAlgebra;

import performancetest.PerformanceTestV2;

import java.io.IOException;
import java.util.Random;


public class La4jPerformanceTestV3 {
	
	public static void main(String args[]) throws Exception {
		Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		
		String stra = a.mkString(";", ",");
		System.out.println("Matrix a is:" + stra);
	 
		La4jTestMatrix[] inputs;
		inputs[0] =	new La4jTestMatrix(a);
		
		Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		
		String strb = b.mkString(";", ",");
		System.out.println("Matrix b is:" + strb);
		
		inputs[1] =	new La4jTestMatrix(a);
		
		La4jTestMatrix[] outputs;
		long numTrials = 0;
		
		long t = process(inputs, outputs, 100);
	}

}
