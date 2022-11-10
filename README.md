# Java_Abstract-interface-for-vectors-and-matrices

LinAlg:

a matrix is a representation of a linear operator and vectors are elements of a vector space. A LinearOperator maps a vector from a VectorSpace into a vector from the same space. A vector of a VectorSpace provides vector space operations, like addition, subtraction and scaling by a scalar factor coming from a number field F. Elements of a “normed vector space” V over the field F, denoted by NormedVectorSpace 3 , provide an unary operation called norm : V → R ≥0 . An InnerProductSpace 4 additionally provides a binary operation called inner : V ×V → F, representing an inner product between vectors
from a vector space.

An interface class is described for the vector spaces over the field double. Thereby, the interfaces should be structured hierarchically.

The class VectorD should be modified such that it implements a corresponding vector space interface.

An adapter class MatrixAdapter is developed that wraps a given matrix of type MatrixD and implements the LinearOperator interface by redirecting to the matrix-vector multiplication method.


LinAlg2:

The classes VectorD and VectorC differ mainly in the element type and the implementation of the operations. But also in the public interface. The scaling method by a scalar gets a different scalar type, i.e., a vector of double can be scaled by a double factor, whereas a vector of Complex is also multiplied by a Complex value. This corresponds to the field type of the associated vector space. We denote by VectorF an element of a vector space over the field F. Thus, the space is parametrized with the type F of scalars that are allowed in the multiplication operation. Typically, this scalar also reflects the
element type of the vector.

Interface VectorSpace is extended by a generic typeparameter <F> representing the field type the vector space is defined with.

NormedVectorSpace and InnerProductSpace are introduced where a norm is a mapping into the real numbers and an inner product maps into the field type.

VectorD and VectorC class has been implemented.

A linear operator is a mapping between vector spaces. More precisely, between vector spaces over the same field type. Thus, also in the definition of LinearOperator some adjustments are necessary to account for the field typeparameter. MatrixAdapter is implemented correspondingly. Note that both matrix types MatrixD and MatrixC might require a different adapter type.

MatrixD and MatrixC classes also implement a VectorSpace interface.


LinAlg3:

Implemented the LinAlg2 by a bit more generic way
