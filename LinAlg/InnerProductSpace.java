package LinAlg;

public interface InnerProductSpace extends NormedVectorSpace {
    public double inner (final VectorSpace other);
    public double norm ();
}
