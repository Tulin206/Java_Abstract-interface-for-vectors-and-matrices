package LinAlg2;

public class MatrixCAdapter implements LinearOperator<Complex>{

    private MatrixC matrix;

    public MatrixCAdapter (MatrixC matrix){
        this.matrix = matrix;
    }

    public void setMatrix (MatrixC matrix){
        this.matrix = matrix;
    }



    @Override
    public VectorC apply(final VectorSpace<Complex> x){
        assert x instanceof VectorC;
        VectorC vector = (VectorC)x;
        return this.matrix.mul(vector);
    }
}
