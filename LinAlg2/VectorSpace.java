package LinAlg2;

public interface VectorSpace<F> {
    // sum of this + other
    public VectorSpace<F> add (final VectorSpace<F> other);

    // subtruction of this - other
    public VectorSpace<F> sub (final VectorSpace<F> other);

    //multiplication of this * value
    public VectorSpace<F> mul (final F value);

}
