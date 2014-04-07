
package performancetest;

import org.la4j.matrix.Matrix;
import org.la4j.vector.Vector;

/**
 * @author Peter Abeles
 * @author Vladimir Kostyukov
 * 
 * updated by wenlong
 */
public class La4jTestMatrix implements TestMatrix  {

    Matrix matrix;

    public static Vector toVector(Matrix m) {
        return m.toColumnVector();
    }

    public static Matrix toMatrix(Vector v) {
        return v.toColumnMatrix();
    }
    
    public La4jTestMatrix(Matrix matrix) {
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
    public int numRows() {
        return matrix.rows();
    }

    @Override
    public int numCols() {
        return matrix.columns();
    }

    @Override
    public <T> T getOriginal() {
        return (T)matrix;
    }
}
