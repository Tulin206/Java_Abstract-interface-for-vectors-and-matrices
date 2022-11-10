package LinAlg3;

public final class Real implements Field<Real> {
    private final double re;   // real part

    Real(double re){
        // this(re);
        this.re = re;
    }
    
    Real(){
        this(0);
    }

    @Override
    public Real add(Real other){
      return new Real((this.re + other.re));
    }

    @Override
    public Real sub(Real other){
      return new Real((this.re - other.re));
    }

    @Override
    public Real mul(Real other){
      return new Real((this.re * other.re));
    }

    @Override
    public Real div(Real other){
      return new Real((this.re / other.re));
    }

    @Override
    public double abs (){
        return Math.sqrt(this.re * this.re);
      }
}
