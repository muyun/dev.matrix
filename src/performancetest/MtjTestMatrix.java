/**
 * Copyright (c) 2014. All Rights Reserved.
 * 
 * @author Peter Abeles
 * @author Vladimir Kostyukov
 * 
 * updated by wenlong
 * 
 */
package performancetest;

import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.Matrices;
import no.uib.cipr.matrix.Vector;


public class MtjTestMatrix implements TestMatrix  {

    Matrix matrix;
    
    public MtjTestMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public double get(int row, int col) {
        return matrix.get(row, col);
    }

    @Override
    public void set(int row, int col, double value) {
        matrix.set(row, col, value);
    }

    @Override
    public <T> T getOriginal() {
        return (T)matrix;
    }

	@Override
	public int numRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numCols() {
		// TODO Auto-generated method stub
		return 0;
	}
}
