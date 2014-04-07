
package performancetest;

/**
 * 
 * @author Peter Abeles
 * updated wenlong
 */
public interface MatrixProcessorInterface {

    /**
     * Measures the amount of time it takes to complete an operation 'numTrials' times.
     *
     * @param inputs Input matrices. MUST NOT BE MODIFIED.
     * @param outputs Resulting output matrices.
     * @param numTrials How many times the operation should be performed.
     * @return Elapsed time in nanoseconds.  If a failure was detected and gracefully handled then -1 is returned.
     */
    public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials);

}