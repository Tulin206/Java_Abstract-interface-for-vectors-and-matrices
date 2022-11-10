package LinAlg;

import java.beans.VetoableChangeSupport;

public interface VectorSpace {
    public VectorSpace add (final VectorSpace other);
    public VectorSpace sub (final VectorSpace other);
    public VectorSpace mul (final double value);

}
