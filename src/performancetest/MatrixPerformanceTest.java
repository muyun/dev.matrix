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


public class MatrixPerformanceTest {
	
	public static void main(String args[]) throws IOException {
		int size = Integer.parseInt(args[0]);
		long numTrials = Integer.parseInt(args[1]);
		
		Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(size,size) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric(); //symmetric matrix
		
		String stra = a.mkString(";", ",");
		System.out.println("Matrix a is:" + stra);
	 
		TestMatrix[] inputs = new La4jTestMatrix[2];
		inputs[0] =	new La4jTestMatrix(a);
		
		Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(size,size) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		
		String strb = b.mkString(";", ",");
		System.out.println("Matrix b is:" + strb);
		
		inputs[1] =	new La4jTestMatrix(b);
		
		TestMatrix[] outputs = new La4jTestMatrix[1];
		
		La4jRuntimePerformance pt = new La4jRuntimePerformance();
		
		//addition
		long addt = pt.add().process(inputs, outputs, numTrials);	
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) addt / 1000) + " s");
		
		//multiplication
		long multt = pt.mult().process(inputs, outputs, numTrials);
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) multt / 1000) + " s");
		
		//determinant
		long delt = pt.det().process(inputs, outputs, numTrials);
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) delt / 1000) + " s");
		
		//Matrix transpose
		long transposet = pt.transpose().process(inputs, outputs, numTrials);
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) transposet / 1000) + " s");
		
		//Eigenvalue Decomposition;
		TestMatrix[] eiginputs = new La4jTestMatrix[1];
		eiginputs[0] = new La4jTestMatrix(a);
		TestMatrix[] eigoutputs = new La4jTestMatrix[2];
		
		long eigt = pt.eigSymm().process(eiginputs, eigoutputs, numTrials);
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) eigt / 1000) + " s");
		
		//SVD
		TestMatrix[] svdinputs = new La4jTestMatrix[1];
		svdinputs[0] = new La4jTestMatrix(a);
		TestMatrix[] svdoutputs = new La4jTestMatrix[3];
		
		long svdt = pt.svd().process(svdinputs, svdoutputs, numTrials);
		System.out.println("La4j matrix (" + args[0] + "X" + args[0] + ") " + args[1] + " times = " + ( (double) svdt / 1000) + " s");
		
	}

}
