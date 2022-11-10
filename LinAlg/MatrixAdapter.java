package LinAlg;

public class MatrixAdapter implements LinearOperator{

    private MatrixD matrix;

    public MatrixAdapter (MatrixD matrix){
        this.matrix = matrix;
    }

    public void setMatrix (MatrixD matrix){
        this.matrix = matrix;
    }



    @Override
    public VectorD apply(final VectorSpace x){
        assert x instanceof VectorD;
        VectorD vector = (VectorD)x;
        return this.matrix.mul(vector);
    }
}
