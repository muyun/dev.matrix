/**
 * Copyright (c) 2014, Hong Kong Creative & Technology Limited. All Rights Reserved.
 * 
 * @author wenlong
 */
package performancetest;

import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.la4j.LinearAlgebra;

import java.io.IOException;
import java.util.Random;

public class La4jPerformanceTestV2 {
	/*
	public MatrixProcessorInterface add(){
		return new Add();
	}
	*/
	
	//public static class Add implements MatrixProcessorInterface {
		public static long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials){
			Matrix a = inputs[0].getOriginal();
			Matrix b = inputs[1].getOriginal();
			
			Matrix C = null;
			
			long prev = System.currentTimeMillis();
			
			for( long i = 0; i < numTrials; i++ ) {
                C = a.add(b);
            }
			
			long elapsed = System.currentTimeMillis() - prev;
            outputs[0] = new La4jTestMatrix(C);
            
            return elapsed;
		}
	//}

	public static void main(String args[]) throws IOException {
			Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
					   .shape(2,2) // 10x10 matrix
					   .source(new Random())
					   .buildSymmetric();
			
			String stra = a.mkString(";", ",");
			System.out.println("Matrix a is:" + stra);
		 
			TestMatrix[] inputs = new La4jTestMatrix[2];
			inputs[0] =	new La4jTestMatrix(a);
			
			Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
					   .shape(100,100) // 10x10 matrix
					   .source(new Random())
					   .buildSymmetric();
			
			String strb = b.mkString(";", ",");
			System.out.println("Matrix b is:" + strb);
			
			inputs[1] =	new La4jTestMatrix(b);
			
			TestMatrix[] outputs = new La4jTestMatrix[1];
			
			long t = process(inputs, outputs, 1000);
			
			System.out.println("la4j matrix sum = " + ( (double) t / 1000) + " s");
		}
}


