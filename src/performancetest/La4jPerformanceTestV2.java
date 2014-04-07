package performancetest;

//author@ wenlong
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
import org.la4j.LinearAlgebra;

import java.io.IOException;
import java.util.Random;

public class La4jPerformanceTestV2 implements RuntimePerformance {
	
	@Override
	public MatrixProcessorInterface add(){
		return new Add();
	}
	
	public static class Add implements MatrixProcessorInterface {
		@Override
		public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials){
			Matrix a = inputs[0].getOriginal();
			Matrix b = inputs[1].getOriginal();
			
			Matrix C = null;
			
			long prev = System.currentTimeMillis();
			
			for( long i = 0; i < numTrials; i++ ) {
                C = a.add(b);
            }
			
			long elapsed = System.nanoTime() - prev;
            outputs[0] = new La4jTestMatrix(C);
            
            return elapsed;
		}
	}
	/*
	public static void main(String args[]) throws Exception {
		Matrix a = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		String stra = a.mkString(";", ",");
		System.out.println("Matrix a is:" + stra);
	 
		a1 = new La4jTestMatrix(a);
		
		Matrix b = Matrices.asBuilder(LinearAlgebra.BASIC2D_FACTORY)
				   .shape(3,3) // 10x10 matrix
				   .source(new Random())
				   .buildSymmetric();
		String strb = b.mkString(";", ",");
		System.out.println("Matrix b is:" + strb);
		
		La4jTestMatrix
		
		process();
	}
*/
}
