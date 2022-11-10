package LinAlg2;

public class MatrixDAdapter implements LinearOperator<Double>{

    private MatrixD matrix;

    public MatrixDAdapter (MatrixD matrix){
        this.matrix = matrix;
    }

    public void setMatrix (MatrixD matrix){
        this.matrix = matrix;
    }



    @Override
    public VectorD apply(final VectorSpace<Double> x){
        assert x instanceof VectorD;
        VectorD vector = (VectorD)x;
        return this.matrix.mul(vector);
    }
}
