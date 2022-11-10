package LinAlg;

import java.util.Scanner;

public class VectorD implements CoordinateVector, InnerProductSpace {
    private static Scanner scanner;
    private int size;


    //Store the vector elements in a one-dimensional (non-public) array of type double.
    private double [] elem;

    // copy constructor
    public VectorD(VectorD vector){
      this.scanner = vector.scanner;
      this.size = vector.size;
      this.elem = vector.elem;
    }

    // Construct a new vector of given size with all elements initialized by value.
    public VectorD(int size, double value){
      this(size);
      for (int i = 0; i < size; i++){
        this.elem[i] = value;
      }
    }

    //constructor
    //read the number of size as well as the vector entries from keyboard input.
    public VectorD(){
      this(true);
    }

    //with passed number of size.
    public VectorD (int size){
      this.size = size;
      this.elem = new double [size];
    }

    //with passed number of array size. 
    //If the argument keyboardIn is true, read the vector entries from keyboard input.
    public VectorD(int size, boolean keyboardIn){
      this(size);
      if(keyboardIn == true){
        readVector();
      }
    }

    //read the number of rows and columns from keyboard input. 
    //If the argument keyboardIn is true, read the matrix entries(row-wise) from keyboard input.
    public VectorD(boolean keyboardIn){
      System.out.print("Enter the number of size: "); 
      this.size = scanner.nextInt();
      if(keyboardIn){
        readVector();
      }
    }

    //Method for input
    public void readVector(){
      this.elem = new double [size];
      System.out.println("Enter the elements of the array: ");
      for (int i=0; i<elem.length; i++){
        elem [i] = scanner.nextDouble();
      }
    }

    @Override
    public int getSize() {
      return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    @Override
    public double[] getElem() {
      return elem;
    }

    public void setElem(double[] elem) {
      this.elem = elem;
    }

    //@Override
    //Method to compute the Euclidean inner product
    public double inner(final VectorSpace other){
      assert other instanceof VectorD;
      VectorD x = (VectorD)other;
      double sum = 0;
      if (this.size == x.size){
        for (int i=0; i<elem.length; i++){
          sum = sum + (this.elem[i] * x.elem[i]);
        }
      }
      return sum;
    }

    //@Override
    public double norm (){
      // double sum = 0;
      double normalize;
      normalize = Math.sqrt(this.inner(this));
      // for (int i=0; i<elem.length; i++){
      //   sum = sum + (this.elem [i] * this.elem[i]);
      // }
      // normalize = Math.sqrt(sum);
      return normalize;
    }

  private VectorD axpy (final double value, final VectorSpace other){
    assert other instanceof VectorD;
    VectorD v = (VectorD)other;
    if (this.size == v.size){
      for (int i=0; i<elem.length; i++){
          this.elem[i] += v.elem[i] * value;
      }
    } else {
      System.out.println("Vectors are not equal");
    }
    return this;
  }

  // this + other
  @Override
  public VectorD add (final VectorSpace other){
    return new VectorD(this).axpy(1.0, other);
  }

  // this - other
  @Override
  public VectorD sub (final VectorSpace other){
    return new VectorD(this).axpy(-1.0, other);
  }

   // return this *= factor
   public VectorD scale (double value){
    for (int i = 0; i < this.size; i++){
      this.elem[i] = this.elem [i]*value;
    }
    return this;
  }

  // return this*factor
  @Override
  public VectorD mul (final double value){
    return new VectorD(this).scale(value);
  }

  // public VectorD add(VectorD other){
  //   VectorD temp = new VectorD(this.size);
  //   if (this.size == other.size){
  //     for (int i=0; i<elem.length; i++){
  //         temp.elem[i] = this.elem[i] + other.elem[i];
  //     }
  //   } else {
  //     System.out.println("Vectors are not equal");
  //   }
  //   return temp;
  // }


  // public VectorD sub(VectorD other){
  //   VectorD temp = new VectorD(this.size);
  //   if (this.size == other.size){
  //     for (int i=0; i<elem.length; i++){
  //         temp.elem[i] = this.elem[i] - other.elem[i];
  //     }
  //   } else {
  //     System.out.println("Vectors are not equal");
  //   }
  //   return temp;
  // }
}