package de.pesse.gwt.jsinterop.threeJs.math;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.BufferAttribute;

/** Wrapper for the Vector2 class of ThreeJS
 * 
 * Class representing a 2D vector. A 2D vector is an ordered pair of numbers (labeled x and y), which can be used to represent a number of things, such as:
 * <ul>
 * 	<li>A point in 2D space (i.e. a position on a plane).</li>
 * 	<li>A direction and length across a plane. In three.js the length will always be the Euclidean distance (straight-line distance) from (0, 0) to (x, y) and the direction is also measured from (0, 0) towards (x, y).</li>
 * 	<li>Any arbitrary ordered pair of numbers.</li>
 * </ul>
 * 
 * There are other things a 2D vector can be used to represent, such as momentum vectors, complex numbers and so on,	however these are the most common uses in three.js.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Vector2 implements Vector
{
	public double x;
	
	public double y;

	/** alias for y */
	public double height;
	
	/** alias for x */
	public double width;
	
	/** Used to check whether this or derived classes are Vector2s. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * 
	 * @return
	 */
	@JsProperty(name="isVector2") public native boolean isVector2();
	
	public Vector2() {}
	public Vector2( double x ) {}
	public Vector2( double x, double y ) {}
	
	/** Adds v to this vector.
	 * 
	 * @param v A vector being added
	 */
	public native void add( Vector2 v );
	
	/** Add the scalar value s to this vector's x and y values
	 * 
	 * @param s
	 */
	public native void addScalar( double s );
	
	/** Adds the multiple of v and s to this vector
	 * 
	 * @param v A vector being multiplied with s
	 * @param s multiplier
	 */
	public native void addScaledVector( Vector2 v, double s );
	
	/** Sets this vector to a + b
	 * 
	 * @param a
	 * @param b
	 */
	public native void addVectors( Vector2 a, Vector2 b );
	
	/** The x and y components of the vector are rounded up to the nearest integer value
	 * 
	 * @return this vector
	 */
	public native Vector2 ceil();
	
	/** If this vector's x or y value is greater than the max vector's x or y value, it is replaced by the corresponding value.
	 * If this vector's x or y value is less than the min vector's x or y value, it is replaced by the corresponding value.
	 * 
	 * @param min the minimum x and y values.
	 * @param max the maximum x and y values in the desired range
	 * @return this vector
	 */
	public native Vector2 clamp( Vector2 min, Vector2 max );
	
	/** If this vector's length is greater than the max value, it is replaced by the max value.
	 * If this vector's length is less than the min value, it is replaced by the min value.
	 * 
	 * @param min the minimum value the length will be clamped to 
	 * @param max the maximum value the length will be clamped to
	 * @return this vector
	 */
	public native Vector2 clampLength( double min, double max );
	
	/** If this vector's x or y values are greater than the max value, they are replaced by the max value. 
	 * If this vector's x or y values are less than the min value, they are replaced by the min value.
	 * 
	 * @param min the minimum value the components will be clamped to 
	 * @param max the maximum value the components will be clamped to 
	 * @return this vector
	 */
	public native Vector2 clampScalar( double min, double max );
	
	/** Returns a new vector2 with the same x and y values as this one.
	 * 
	 */
	public native Vector2 clone();
	
	/** Copies the values of the passed vector2's x and y properties to this vector2.
	 * 
	 * @param v The vector which's x and y properties are being copied to this vector
	 * @return this vector
	 */
	public native Vector2 copy( Vector2 v );
	
	/** Computes the distance from this vector to v.
	 * 
	 * @param v target vector
	 * @return distance
	 */
	public native double distanceTo( Vector2 v );
	
	/** Computes the Manhattan distance from this vector to v
	 * 
	 * @param v target vector
	 * @return Manhattan distance
	 */
	public native double distanceToManhattan( Vector2 v );
	
	
	/** Computes the squared distance from this vector to v. 
	 * If you are just comparing the distance with another distance, you should compare the distance squared instead as it is slightly more efficient to calculate.
	 * 
	 * @param v target vector
	 * @return squared distance
	 */
	public native double distanceToSquared( Vector2 v );
	
	/** Divides this vector by v
	 * 
	 * @param v division vector
	 * @return this vector
	 */
	public native Vector2 divide( Vector2 v );
	
	/** Divides this vector by scalar s. 
	 * Sets vector to ( 0, 0 ) if s = 0.
	 * 
	 * @param s division scalar
	 * @return
	 */
	public native Vector2 divideScalar( double s );
	
	/** Calculate the dot product of this vector and v
	 * 
	 * @param v
	 * @return
	 */
	public native double dot( Vector2 v );
	
	/** Checks for strict equality of this vector and v
	 * 
	 * @param v
	 * @return
	 */
	public native boolean equals( Vector2 v );
	
	/** The components of the vector are rounded down to the nearest integer value.
	 * 
	 * @return this vector
	 */
	public native Vector2 floor();
	
	/** Sets this vector's x value to be array[0] and y value to be array[1].
	 * 
	 * @param array
	 * @return this vector
	 */
	public native Vector2 fromArray( double[] array);
	
	/** Sets this vector's x value to be array[0+offset] and y value to be array[1+offset].
	 * 
	 * @param array
	 * @param offset
	 * @return this vector
	 */
	public native Vector2 fromArray( double[] array, int offset );
	
	/** Sets this vector's x and y values from the attribute
	 * 
	 * @param attribute the source attribute
	 * @param index index in the attribute
	 * @return this vector
	 */
	public native Vector2 fromBufferAttribute( BufferAttribute attribute, int index );
	
	/** If index equals 0 returns the x value.
	 * If index equals 1 returns the y value.
	 * 
	 * @param index 0 or 1
	 * @return
	 */
	public native double getComponent( int index );
	
	/** Computes the Euclidean length (straight-line length) from (0, 0) to (x, y).
	 * 
	 * @return
	 */
	public native double length();
	
	/** Computes the Manhattan length of this vector.
	 * 
	 * @return
	 */
	public native double lengthManhattan();
	
	/** Computes the square of the Euclidean length (straight-line length) from (0, 0) to (x, y). If you are comparing the lengths of vectors, you should compare the length squared instead as it is slightly more efficient to calculate.
	 * 
	 * @return
	 */
	public native double lengthSq();
	
	/** Linearly interpolate between this vector and v, where alpha is the distance along the line - alpha = 0 will be this vector, and alpha = 1 will be v.
	 * 
	 * @param v Vector to interpolate towards
	 * @param alpha interpolation factor in the closed interval [0, 1]
	 * @return this vector
	 */
	public native Vector2 lerp( Vector2 v, double alpha );
	
	/** Sets this vector to be the vector linearly interpolated between v1 and v2 where alpha is the distance along the line connecting the two vectors - alpha = 0 will be v1, and alpha = 1 will be v2.
	 * 
	 * @param v1 the starting Vector2.
	 * @param v2 Vector2 to interpolate towards.
	 * @param alpha interpolation factor in the closed interval [0, 1].
	 * @return this vector
	 */
	public native Vector2 lerpVectors( Vector2 v1, Vector2 v2, double alpha );
	
	/** Inverts this vector - i.e. sets x = -x and y = -y.
	 * 
	 * @return this vector
	 */
	public native Vector2 negate();
	
	/** Convert this vector to a unit vector - that is, sets it equal to the vector with the same direction as this one, but length 1.
	 * 
	 * @return this vector
	 */
	public native Vector2 normalize();
	
	/** If this vector's x or y value is less than v's x or y value, replace that value with the corresponding max value
	 * 
	 * @param v comparing vector
	 * @return this vector
	 */
	public native Vector2 max( Vector2 v );
	
	/** If this vector's x or y value is greater than v's x or y value, replace that value with the corresponding min value.
	 * 
	 * @param v comparing vector
	 * @return this vector
	 */
	public native Vector2 min( Vector2 v );
	
	/** Multiplies this vector by v
	 * 
	 * @param v multiplying vector
	 * @return this vector
	 */
	public native Vector2 multiply( Vector2 v );
	
	/** Multiplies this vector by scalar s
	 * 
	 * @param s a scalar
	 * @return this vector
	 */
	public native Vector2 multiplyScalar( double s );
	
	/** Rotate the vector around center by angle radians
	 * 
	 * @param center the poinot around which to rotate
	 * @param angle the angle to rotate, in radians
	 * @return this vector
	 */
	public native Vector2 rotateAround( Vector2 center, double angle );
	
	/** The compoonents of the vector are rounded to the nearest integer value
	 * 
	 * @return this vector
	 */
	public native Vector2 round();
	
	/** The components of the vector are rounded towards zero (up if negative, down if positive) to an integer value.
	 * 
	 * @return this vector
	 */
	public native Vector2 roundToZero();
	
	/** Sets the x and y components of this vector
	 * 
	 * @param x
	 * @param y
	 * @return this vector
	 */
	public native Vector2 set( double x, double y );
	
	/** If index equals 0 set x to value. 
	 * If index equals 1 set y to value
	 * 
	 * @param index 0 or 1
	 * @param value
	 * @return this vector
	 */
	public native Vector2 setComponent( int index, double value );
	
	/** Set this vector to the vector with the same direction as this one, but length l.
	 * 
	 * @param l
	 * @return this vector
	 */
	public native Vector2 setLength( double l );
	
	/** Set the x and y values of this vector both equal to scalar.
	 * 
	 * @param scalar
	 * @return this vector
	 */
	public native Vector2 setScalar( double scalar );
	
	/** Replace this vector's x value with x
	 * 
	 * @param x
	 * @return this vector
	 */
	public native Vector2 setX( double x );
	
	/** Replace this vector's y value with y
	 * 
	 * @param y
	 * @return this vector
	 */
	public native Vector2 setY( double y );
	
	/** Substracts v from this vector
	 * 
	 * @param v subtracting vector
	 * @return this vector
	 */
	public native Vector2 sub( Vector2 v );
	
	/** Subtracts s from this vector's x and y compnents.
	 * 
	 * @param s scalar to substract
	 * @return this vector
	 */
	public native Vector2 subScalar( double s );
	
	/** Sets this vector to a - b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public native Vector2 subVectors( Vector2 a, Vector2 b );
	
	/** Returns an array [x, y]
	 * 
	 * @return
	 */
	public native double[] toArray(  );
	
	/** Copies x and y into the provided array
	 * 
	 * @param array
	 * @return
	 */
	public native double[] toArray( double[] array );
	
	/** Copies x and y into the provided array, organizing it by the offset
	 * 
	 * @param array
	 * @param offset
	 * @return
	 */
	public native double[] toArray( double[] array, int offset );
}
