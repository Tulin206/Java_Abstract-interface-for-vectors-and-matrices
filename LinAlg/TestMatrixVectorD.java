package LinAlg;

public class TestMatrixVectorD {

  // check almost equality between double values
  private static boolean almost_equals(double x, double y, double tol) {
    return Math.abs(x-y) <= tol * Math.abs(x+y);
  }

  // overload of the almost_equals method without a tolerance argument
  private static boolean almost_equals(double x, double y) {
    return almost_equals(x,y,1.e-15);
  }


  /// Check some methods of the matrix, assuming it is given as in the main() method
  private static void testMatrix(MatrixD A) {
    assert A.getRowCount() == 2;
    assert A.getColCount() == 2;

    MatrixD At = A.transposed();
    assert A.getRowCount() == At.getColCount();
    assert A.getColCount() == At.getRowCount();

    assert At.transposed().equals(A);
  }

  /// Check some methods of the vectors, assuming they are given as in the main() method
  private static void testVector(VectorD x, VectorD b) {
    assert x.getSize() == 2;
    assert b.getSize() == 2;

    VectorD xb = x.add(b);
    assert xb.getSize() == x.getSize();

    assert b.add(x).equals(xb);

    double d = x.inner(b);
    assert almost_equals(d, 20.0);

    double n = x.norm();
    assert almost_equals(n, Math.sqrt(x.inner(x)));
  }

  /// Check the interaction of matrix and vector
  private static void testMatrixVector(MatrixD A, VectorD x, VectorD b) {
    assert A.getColCount() == x.getSize();
    assert A.getRowCount() == b.getSize();

    // A is identity matrix
    assert A.mul(x).equals(x);
    assert A.mul(b).equals(b);

    VectorD r = b.sub(A.mul(x));
    assert r.getSize() == b.getSize();

    VectorD r0 = x.sub(A.mul(x));
    VectorD zero = new VectorD(2, 0.0);
    assert r0.equals(zero);
  }

  private static void testInterfaces(LinearOperator A, VectorSpace x, VectorSpace b)
  {
    var r = b.sub(A.apply(x));
    double residuum = ((NormedVectorSpace)r).norm();
    assert almost_equals(residuum, 0.0);
  }


  public static void main(String[] args) {
    // Assume we can access the data of the matrix directly, i.e., it is package-private

    MatrixD A = new MatrixD(2,2);
    double[][] arr = new double[2][2];
    arr[0][0] = 1.0;
    arr[0][1] = 0.0;
    arr[1][0] = 0.0;
    arr[1][1] = 1.0;
    A.setElem(arr);

    VectorD x = new VectorD(2);
    double[] array = new double[2];
    array[0] = 4.0;
    array[1] = 2.0;
    x.setElem(array);

    VectorD b = A.mul(x);

    testMatrix(A);
    testVector(x,b);
    testMatrixVector(A,x,b);

    MatrixAdapter linOp = new MatrixAdapter(A);
    testInterfaces(linOp,x,b);
  }
}
