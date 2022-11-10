package LinAlg2;

public interface LinearOperator<F> {
    public VectorSpace<F> apply (final VectorSpace<F> x);
}
