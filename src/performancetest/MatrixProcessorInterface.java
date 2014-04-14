/**
 * Copyright (c) 2014, Hong Kong Creative & Technology Limited. All Rights Reserved.
 * 
 * @author Peter Abeles
 * updated wenlong
 *
 */

package performancetest;

public interface MatrixProcessorInterface {

    /**
     * Measures the amount of time it takes to complete an operation 'numTrials' times.
     *
     * @param inputs - Input matrices.
     * @param outputs - Resulting output matrices.
     * @param numTrials - times the operation should be performed.
     */
    public long process(TestMatrix[] inputs, TestMatrix[] outputs, long numTrials);

}