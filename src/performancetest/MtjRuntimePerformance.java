/**
 * Copyright (c) 2014. All Rights Reserved.
 * 
 * @author Vladimir Kostyukov
 * updated by wenlong
 * 
 */
package performancetest;

import no.uib.cipr.matrix.DenseMatrix;

//import java.io.IOException;

public class MtjRuntimePerformance implements RuntimePerformanceV2 {
	
	//Matrix addition
	@Override
	public MatrixProcessorInterface add(){
		return new Add();
	}
	
    public static class Add implements MatrixProcessorInterface {
        @Override
        public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials) {
            DenseMatrix matA = inputs[0].getOriginal();
            DenseMatrix matB = inputs[1].getOriginal();

            DenseMatrix result = new DenseMatrix(matA.numRows(),matB.numColumns());

            long prev = System.currentTimeMillis();

            for( long i = 0; i < numTrials; i++ ) {
                // in-place operator
                result.set(matA);
                result.add(matB);
            }

            long elapsedTime = System.currentTimeMillis()-prev;
            outputs[0] = new MtjTestMatrix(result);
            return elapsedTime;
        }
    }
      

	public static void main(String args[]) throws Exception {
		Matrix a = Matrices.;
		
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
		
		long t = Add.process(inputs, outputs, 100);
	}

}
