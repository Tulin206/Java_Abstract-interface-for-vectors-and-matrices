package LinAlg3;

import java.util.Scanner;

public class VectorC implements InnerProductSpace<Complex, VectorC>{
    private static Scanner scanner;
    private int size;


    //Store the vector elements in a one-dimensional (non-public) array of type double.
    private Complex [] elem;

    //constructor
    //read the number of size as well as the vector entries from keyboard input.
    public VectorC(){
      this(true);
    }

    // Copy Constructor
    public VectorC(VectorC v){
      this.size = v.size;
      this.elem = v.elem;
    }

    //with passed number of size.
    public VectorC (int size){
      this.size = size;
      this.elem = new Complex [size];
    }

    //with passed number of array size. 
    //If the argument keyboardIn is true, read the vector entries from keyboard input.
    public VectorC(int size, boolean keyboardIn){
      this(size);
      if(keyboardIn == true){
        readVector();
      }
    }

    //read the number of rows and columns from keyboard input. 
    //If the argument keyboardIn is true, read the matrix entries(row-wise) from keyboard input.
    public VectorC(boolean keyboardIn){
      System.out.print("Enter the number of size: "); 
      this.size = scanner.nextInt();
      if(keyboardIn){
        readVector();
      }
    }

    //Method for input
    public void readVector(){
      this.elem = new Complex [size];
      System.out.println("Enter the elements of the array: ");
      for (int i=0; i<elem.length; i++){
        elem [i] = Complex.readComplex();
        // elem [i] = scanner.nextDouble();
      }
    }

    public int getSize() {
      return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    public Complex[] getElem() {
      return elem;
    }

    public void setElem(Complex[] elem) {
      this.elem = elem;
    }

    //Method to compute the Euclidean inner product
    public Complex dot(VectorC other){
      Complex sum = new Complex();
      if (this.size == other.size){
        for (int i=0; i<elem.length; i++){
          // sum = sum + (this.elem[i] * other.elem[i]);
          sum = sum.add(this.elem[i].mul(other.elem[i]));
        }
      }
      return sum;
    }

    // return this *= factor
    @Override
    public VectorC mul (final Complex value){
      for (int i = 0; i < this.size; i++){
        this.elem[i] = this.elem [i].mul(value);
      }
      return this;
    }

  //   @Override
  //   public Double norm (){
  //     Complex sum = new Complex();
  //     Double normalize = 0.0;
  //     for (int i=0; i<elem.length; i++){
  //       sum = sum.add(this.elem[i].mul(this.elem[i]));
  //     }
  //     normalize = sum.abs();
  //     return normalize;
  // }


    @Override
    public VectorC axpy (final Complex value, final VectorC other){
    // assert other instanceof VectorD;
    // VectorD v = (VectorD)other;
    if (this.size == other.size){
      for (int i=0; i<elem.length; i++){
          this.elem[i] = this.elem[i].add((other.elem[i].mul(value)));
      }
    } else {
      System.out.println("Vectors are not equal");
    }
    return this;
  }

  @Override
  //Method to compute the Euclidean inner product
  public Complex inner(final VectorC other){
    // assert other instanceof VectorC;
    // VectorC x = (VectorC)other;
    Complex sum = new Complex();
    if (this.size == other.size){
      for (int i=0; i<elem.length; i++){
        sum  = sum.add(this.elem[i].mul(other.elem[i]));
      }
    }
    return sum;
  }

  @Override
  public VectorC add(final VectorC other){
    // assert other instanceof VectorC;
    // VectorC v = (VectorC)other;
    return new VectorC(this).axpy(new Complex(1), other);
    // VectorC temp = new VectorC(this.size);
    // if (this.size == other.size){
    //   for (int i=0; i<elem.length; i++){
    //       temp.elem[i] = this.elem[i].add(other.elem[i]);
    //   }
    // } else {
    //   System.out.println("Vectors are not equal");
    // }
    // return temp;
  }

  @Override
  public VectorC sub(final VectorC other){
    // assert other instanceof VectorC;
    // VectorC v = (VectorC)other;
    return new VectorC(this).axpy(new Complex(-1), other);
  //   VectorC temp = new VectorC(this.size);
  //   if (this.size == other.size){
  //     for (int i=0; i<elem.length; i++){
  //         temp.elem[i] = this.elem[i].sub(other.elem[i]);
  //         // temp.elem[i] = this.elem[i] - other.elem[i];
  //     }
  //   } else {
  //     System.out.println("Vectors are not equal");
  //   }
  //   return temp;
  // }
  }
}