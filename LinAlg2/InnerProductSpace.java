package LinAlg2;

class Field{

    public static double abs (final double x){
        return x < 0 ? -x : x;
    }

    public static double abs (final Complex z){
        return z.abs();
    }

    public static double abs (final Number n){
        return abs(n.doubleValue());
    }

    public static <F> double abs (final F f){
        if(f instanceof Number){
            return abs((Number)f);
        } else if (f instanceof Complex){
            return abs((Complex)f);
        }
        assert false : "Type F has no overload Field.abs";
        return 0.0;
    }
}

public interface InnerProductSpace<F> extends NormedVectorSpace<F> {

    public F inner (final VectorSpace<F> other);

    @Override
    default double norm(){
        return Math.sqrt(Field.abs(this.inner(this)));
    }
}