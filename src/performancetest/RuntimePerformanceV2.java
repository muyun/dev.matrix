/**
 * Copyright (c) 2014
 * 
 * @author Vladimir Kostyukov
 * updated by wenlong
 * 
 * Function - An interface  is used to measure the library's runtime performance.
 * 
 */

package performancetest;


public interface RuntimePerformanceV2 {

    /**
     * Cholesky decomposition
     */
	//MatrixProcessorInterface chol();

    /**
     * LU decomposition
     */
	//MatrixProcessorInterface lu();


    /**
     * Eigenvalue Decomposition
     */
	//MatrixProcessorInterface eigSymm();

    /**
     * Computes the determinant of a matrix.
     */
	//MatrixProcessorInterface det();

    /**
     * <p>
     * Matrix addition :<br>
     * <br>
     * C = A + B
     * </p>
     */
	MatrixProcessorInterface add();

    /**
     * <p>
     * Matrix multiplication :<br>
     * <br>
     * C = A*B
     * </p>
     */
	//MatrixProcessorInterface mult();

    /**
     * <p>
     * Matrix multiplication where B is transposed:<br>
     * <br>
     * C = A*B^T
     * </p>
     */
	//MatrixProcessorInterface multTransB();

    /**
     * <p>
     * Multiplies each element in the matrix by a constant value.<br>
     * <br>
     * b<sub>i,j</sub> = &gamma;a<sub>i,j</sub>
     * </p>
     */
	//MatrixProcessorInterface scale();

    /**
     * Solve a system with square input matrix:<br>
     * <br>
     * A*X = B<br>
     * <br>
     * where A is an m by m matrix.
     */
	//MatrixProcessorInterface solveExact();

    /**
     * Solve a system with a "tall" input matrix:<br>
     * <br>
     * A*X = B<br>
     * <br>
     * where A is an m by n matrix and m > n.
     */
	//MatrixProcessorInterface solveOver();

    /**
     * Matrix transpose
     */
	//MatrixProcessorInterface transpose();
	
	/**
	 * SVD
	 */
   // MatrixProcessorInterface svd();
}

