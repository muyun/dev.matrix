package performancetest;

//author@ wenlong

import org.la4j.LinearAlgebra;
import org.la4j.decomposition.MatrixDecompositor;
import org.la4j.matrix.Matrices;
import org.la4j.matrix.Matrix;
//import org.la4j.LinearAlgebra;

//import java.io.IOException;

public class PerformanceTest implements RuntimePerformance {
	
	@Override
	public MatrixProcessorInterface add(){
		return new Add();
	}
	
	public class Add implements MatrixProcessorInterface {
		@Override
		public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials){
			Matrix a = inputs[0].getOriginal();
			Matrix b = inputs[1].getOriginal();
			
			Matrix C = null;
			
			long prev = System.currentTimeMillis();
			
			for( long i = 0; i < numTrials; i++ ) {
                C = a.add(b);
            }
			
			long elapsed = System.currentTimeMillis() - prev;
			
            outputs[0] = new La4jTestMatrix(C);
            
            System.out.println("La4j Matrix addition:");
            return elapsed;
		}
	}
	
    @Override
    public MatrixProcessorInterface mult() {
        return new Mult();
    }

    public static class Mult implements MatrixProcessorInterface {
        @Override
        public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials) {
            Matrix a = inputs[0].getOriginal();
            Matrix b = inputs[1].getOriginal();

            long prev = System.currentTimeMillis();

            Matrix C = null;

            for( long i = 0; i < numTrials; i++ ) {
                C = a.multiply(b);
            }

            long elapsed = System.currentTimeMillis() - prev;
            outputs[0] = new La4jTestMatrix(C);
            
            System.out.println("La4j Matrix multiplication:");
            return elapsed;
        }
    }
    
    @Override
    public MatrixProcessorInterface det() {
        return new Det();
    }

    public static class Det implements MatrixProcessorInterface {
        @Override
        public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials) {
            Matrix a = inputs[0].getOriginal();

            long prev = System.currentTimeMillis();

            for( long i = 0; i < numTrials; i++ ) {
                a.determinant();
            }

            System.out.println("Computes the determinant of a La4j matrix:");
            return System.currentTimeMillis() - prev;
        }
    }
	
    @Override
    public MatrixProcessorInterface eigSymm() {
        return new Eig();
    }

    public static class Eig implements MatrixProcessorInterface {
        @Override
        public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials) {
            Matrix a = inputs[0].getOriginal();

            Matrix D = null;
            Matrix V = null;

            long prev = System.currentTimeMillis();

            for( long i = 0; i < numTrials; i++ ) {
                MatrixDecompositor decompositor = a.withDecompositor(LinearAlgebra.EIGEN);
                Matrix vd[] = decompositor.decompose();
                V = vd[0];
                D = vd[1];
            }

            long elapsed = System.currentTimeMillis() - prev;
            outputs[0] = new La4jTestMatrix(D);
            outputs[1] = new La4jTestMatrix(V);
            
            System.out.println("La4j Eigenvalue Decomposition:");
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
	*/
}
