package performancetest;

/**
 * A generic interface used to setup matrices.
 *
 * @author Peter Abeles
 */
public interface TestMatrix {

    public double get( int row , int col );

    public void set( int row , int col , double value );

    public int numRows();

    public int numCols();

    public <T>T getOriginal();
}