package LinAlg3;

public interface VectorSpace<F extends Field<F>, V extends VectorSpace<F, V>> {
    // sum of this + other
    public V add (final V other);

    // subtruction of this - other
    public V sub (final V other);

    //multiplication of this * value
    public V mul (final F value);

    // this += alpha * other
    public V axpy (final F value, final V other);
}
