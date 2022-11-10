package LinAlg3;

public interface LinearOperator<F extends Field<F>, V extends VectorSpace<F,V>> {
    public V apply (final V x);
}