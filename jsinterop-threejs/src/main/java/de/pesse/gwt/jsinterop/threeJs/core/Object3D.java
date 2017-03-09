package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.compatibility.JsArray;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.math.Euler;
import de.pesse.gwt.jsinterop.threeJs.math.Matrix;
import de.pesse.gwt.jsinterop.threeJs.math.Quaternion;
import de.pesse.gwt.jsinterop.threeJs.math.Vector3;
import de.pesse.gwt.jsinterop.threeJs.objects.Group;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;

/** 
 * Wrapper for the ThreeJs Object3D class
 * 
 * This is the base class for most objects in three.js and provides a set of properties and methods for manipulating objects in 3D space.
 * 
 * 	Note that this can be used for grouping objects via the .add( object ) method which adds the object as a child, however it is better to use Group for this.
 * 
 *  @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Object3D extends EventDispatcher
{
	
	/*
	 * Static Properties
	 */
	/** The default up direction for objects, also used as the default position for DirectionalLight, HemisphereLight and Spotlight (which creates lights shining from the top down).
	Set to (0, 1, 0) by default.*/
	public static Vector3 DefaultUp;

	/** The default setting for [page.matrixAutoUpdate matrixAutoUpdate] for newly created Object3Ds.*/
	public static boolean DefaultMatrixAutoUpdate;
	
	/*
	 * Properties
	 */

	/** Whether the object gets rendered into shadow map. Default is false.
	 */
	public boolean castShadow;

	/** Array with object's children. See Group for info on manually grouping objects.
	 */
	public JsArray<Object3D> children; // TODO: Check if Object3D[] is better

	/** When this is set, it checks every frame if the object is in the frustum of the camera before rendering the object. Otherwise the object gets renderered every frame even if it isn't visible. Default is true.
	 */
	public boolean frustumCulled;
	
	/** readonly – Unique number for this object instance.
	 * 
	 * @return Id of the object instance
	 */
	@JsProperty public native int getId();
	
	/** Used to check whether this or derived classes are Object3Ds. Default is true.
	 * 	You should not change this, as it used internally for optimisation. */
	@JsProperty(name="isObject") public native boolean isObject();

	/** The layer membership of the object. The object is only visible if it has at least one layer in common with the Camera in use.
	 * 
	 * @return
	 */
	@JsProperty public native Object getLayers(); // TODO: Maybe different type

	/** The local transform matrix.
	 */
	public Matrix matrix;

	/** When this is set, it calculates the matrix of position, (rotation or quaternion) and scale every frame and also recalculates the matrixWorld property. Default is Object3D.DefaultMatrixAutoUpdate (true).*/
	public boolean matrixAutoUpdate;

	/** The global transform of the object. If the Object3d has no parent, then it's identical to the local transform .matrix.
	 * 
	 * @return
	 */
	@JsProperty public native Matrix getMatrixWorld();

	/** When this is set, it calculates the matrixWorld in that frame and resets this property to false. Default is false.*/
	public boolean matrixWorldNeedsUpdate;

	/** This is passed to the shader and used to calculate the position of the object. */
	public Matrix modelViewMatrix;

	/** Optional name of the object (doesn't need to be unique). Default is an empty string.*/
	public String name;

	/** This is passed to the shader and used to calculate lighting for the object.*/
	public Matrix normalMatrix;

	/** An optional callback that is executed immediately after the Object3D is rendered. This function is called with the following parameters: renderer, scene, camera, geometry, material, group.
	 * 
	 * @param callback
	 */
	@JsProperty public native void setOnAfterRender( RenderCallback callback ); 

	/** An optional callback that is executed immediately before the Object3D is rendered. This function is called with the following parameters: renderer, scene, camera, geometry, material, group.
	 * 
	 */
	@JsProperty public native void setOnBeforeRender( RenderCallback callback ); 
	
	/** Object's parent in the scene graph.
	 * 
	 * @return Parent object
	 */
	@JsProperty public native Object3D getParent();

	/** The object's local position. */
	public Vector3 position;

	/** Object's local rotation as a Quaternion.*/
	public Quaternion quaternion;
	
	/** Whether the material receives shadows. Default is false. */
	public boolean receiveShadow;

	/** This value allows the default rendering order of scene graph objects to be overridden although opaque and transparent objects remain sorted independently. Sorting is from lowest to highest renderOrder. Default value is 0. */
	public int renderOrder;

	/** Object's local rotation (see Euler angles), in radians. */
	public Euler rotation;

	/** The object's local # .scale . Default is Vector3( 1, 1, 1 ).*/
	public Vector3 scale;

	/** This is used by the lookAt method, for example, to determine the orientation of the result.
	 * 	Default is Object3D.DefaultUp - that is, ( 0, 1, 0 ).
	 */
	public Vector3 up;

	/** An object that can be used to store custom data about the Object3d. It should not hold references to functions as these will not be cloned. */
	public Object userData;

	/** UUID of this object instance. This gets automatically assigned, so this shouldn't be edited.*/
	@JsProperty public native String getUuid();

	/** Object gets rendered if true. Default is true. */
	public boolean visible;
	
	
	/**
	* The constructor takes no arguments.
	*/
	public Object3D() {}
	
	
	/** Adds object as child of this object. An arbitrary number of objects may be added.
	 * See Group for info on manually grouping objects.
	 * 
	 * @param objects
	 */
	public native void add( Object3D... objects );
	
	/** This updates the position, rotation and scale with the matrix.
	 * 
	 * @param matrix
	 */
	public native void applyMatrix ( Matrix matrix );
	
	
	/** Returns a clone of this object and all descendants.
	 * 
	 */
	public native Object3D clone();
	
	/** Returns a clone of this object and optionaly all descendants. 
	 * 
	 * @param recursive if true, descendants of the object are also cloned. Default is true.
	 * @return
	 */
	public native Object3D clone( boolean recursive );
	
	/** Copy the given object and all its decendants into this object.
	 * 
	 * @param object The object to be copied into this object
	 * @return This object
	 */
	public native Object3D copy( Object3D object );
	
	/** Copy the given object into this object.
	 * 
	 * @param object The object to be copied into this object
	 * @param recursive if true, descendants of the object are also copied. Default is true.
	 * @return This object
	 */
	public native Object3D copy( Object3D object, boolean recursive );

	/** Searches through the object's children and returns the first with a matching id.
	 * Note that ids are assigned in chronological order: 1, 2, 3, ..., incrementing by one for each new object.
	 * 
	 * @param id Unique number of the object instance
	 * @return The child object with the appropriate ID or NULL
	 */
	public native Object3D getObjectById( int id );
	
	/** Searches through the object's children and returns the first with a matching name.	
	 * Note that for most objects the # .name is an empty string by default. You will have to set it manually to make use of this method.
	 * 
	 * @param name String to match to the children's Object3d.name property
	 * @return The child object with the appropriate name or NULL
	 */
	public native Object3D getObjectByName( String name );
	
	/** Searches through the object's children and returns the first with a property that matches the value given.
	 * 
	 * @param name the property name to search for. 
	 * @param value value of the given property. 
	 * @return
	 */
	public native Object3D getObjectByProperty( String name, Object value );

	/** Returns a vector representing the position of the object in world space
	 * 
	 * @return
	 */
	public native Vector3 getWorldPosition();
	
	/** Returns a vector representing the position of the object in world space.
	 * 
	 * @param optionalTarget (optional) target to set the result. Otherwise, a new Vector3 is instantiated.
	 * @return
	 */
	public native Vector3 getWorldPosition( Vector3 optionalTarget );
	
	/** Returns a quaternion representing the rotation of the object in world space.
	 * 
	 * @return
	 */
	public native Quaternion getWorldQuaternion();
	
	/** Returns a quaternion representing the rotation of the object in world space.
	 * 
	 * @param optionalTarget (optional) if specified, the result will be copied into this Quaternion, otherwise a new Quaternion will be created. 
	 * @return
	 */
	public native Quaternion getWorldQuaternion( Quaternion optionalTarget );
	
	/** Returns the euler angles representing the rotation of the object in world space.
	 * 
	 * @return
	 */
	public native Euler getWorldRotation();
	
	/** Returns the euler angles representing the rotation of the object in world space.
	 * 
	 * @param optionalTarget (optional) if specified, the result will be copied into this Euler, otherwise a new Euler will be created. 
	 * @return
	 */
	public native Euler getWorldRotation( Euler optionalTarget );
	
	/** Returns a vector of the scaling factors applied to the object for each axis in world space.
	 * 
	 * @return
	 */
	public native Vector3 getWorldScale();
	
	/** Returns a vector of the scaling factors applied to the object for each axis in world space.
	 * 
	 * @param optionalTarget (optional) if specified, the result will be copied into this Vector3, otherwise a new Vector3 will be created. 
	 * @return
	 */
	public native Vector3 getWorldScale( Vector3 optionalTarget );
	
	/** Returns a vector representing the direction of object's positive z-axis in world space.
	 * 
	 * @return
	 */
	public native Vector3 getWorldDirection();
	
	/** Returns a vector representing the direction of object's positive z-axis in world space.
	 * 
	 * @param optionalTarget (optional) if specified, the result will be copied into this Vector3, otherwise a new Vector3 will be created. 
	 * @return
	 */
	public native Vector3 getWorldDirection( Vector3 optionalTarget );
	
	/** Converts the vector from local space to world space.
	 * 
	 * @param vector A vector representing a position in local (object) spave.
	 * @return
	 */
	public native Vector3 localToWorld( Vector3 vector );
	
	/** Rotates the object to face a point in world space.
	 * 
	 * @param vector A vector representing a position in world space.
	 */
	public native void lookAt( Vector3 vector );
	
	/** Abstract (empty) method to get intersections between a casted ray and this object. Subclasses such as Mesh, Line, and Points implement this method in order to use raycasting.
	 * 
	 * @param raycaster
	 * @param intersects
	 */
	public native void raycast( Raycaster raycaster, Object intersects ); // TODO: Define Type
	
	/** Removes object as child of this object. An arbitrary number of objects may be removed.
	 * 
	 * @param objects
	 */
	public native void remove( Object3D... objects );
	
	/** Rotate an object along an axis in object space. The axis is assumed to be normalized.
	 * 
	 * @param axis A normalized vector in object space. 
	 * @param angle The angle in radians.
	 */
	public native void rotateOnAxis( Vector3 axis, int angle );
	
	/** Rotates the object around x axis in local space.
	 * 
	 * @param rad the angle to rotate in radians
	 */
	public native void rotateX( double rad );
	
	/** Rotates the object around y axis in local space.
	 * 
	 * @param rad the angle to rotate in radians
	 */
	public native void rotateY( double rad );
	
	/** Rotates the object around z axis in local space.
	 * 
	 * @param rad the angle to rotate in radians
	 */
	public native void rotateZ( double rad );
	
	/** Calls setFromAxisAngle( axis, angle ) on the .quaternion.
	 * 
	 * @param axis A normalized vector in object space. 
	 * @param angle angle in radians
	 */
	public native void setRotationFromAxisAngle( Vector3 axis, double angle );
	
	/** Calls setRotationFromEuler( euler) on the .quaternion.
	 * 
	 * @param euler Euler angle specifying rotation amount.
	 */
	public native void setRotationFromEuler( Euler euler );
	
	
	/** Calls setFromRotationMatrix( m) on the .quaternion.	
	 * Note that this assumes that the upper 3x3 of m is a pure rotation matrix (i.e, unscaled).
	 * 
	 * @param m rotate the quaternion by the rotation component of the matrix.
	 */
	public native void setRotationFromMatrix( Matrix m );
	
	/** Copy the given quaternion into .quaternion.
	 * 
	 * @param q normalized Quaternion
	 */
	public native void setRotationFromQuaternion( Quaternion q );
	
	/** Convert the object to JSON format.
	 * 
	 * @param q
	 * @return
	 */
	public native Object toJSON( Object q ); // TODO: Maybe type?
	
	/** Translate an object by distance along an axis in object space. The axis is assumed to be normalized.
	 * 
	 * @param axis A normalized vector in object space.
	 * @param distance The distance to translate.
	 */
	public native void translateOnAxis( Vector3 axis, int distance );
	
	/** Translates object along x axis by distance units.
	 * 
	 * @param distance
	 */
	public native void translateX( int distance );
	
	/** Translates object along y axis by distance units.
	 * 
	 * @param distance
	 */
	public native void translateY( int distance );
	
	/** Translates object along z axis by distance units.
	 * 
	 * @param distance
	 */
	public native void translateZ( int distance );
	
	/** Executes the callback on this object and all descendants.
	 * 
	 * @param callback A function with as first argument an object3D object.
	 */
	public native void traverse( TraverseCallback callback );
	
	/** Like traverse, but the callback will only be executed for visible objects. Descendants of invisible objects are not traversed.
	 * 
	 * @param callback A function with as first argument an object3D object.
	 */
	public native void traverseVisible( TraverseCallback callback );
	
	/** Executes the callback on all ancestors.
	 * 
	 * @param callback A function with as first argument an object3D object.
	 */
	public native void traverseAncestors( TraverseCallback callback );
	
	/** Update the local transform.
	 * 
	 */
	public native void updateMatrix();
	
	/** Update the global transform of the object and its children (if matrixWorldNeedsUpdate is true)
	 * 
	 */
	public native void updateMatrixWorld();
	
	/** Update the global transform of the object and its children.
	 * 
	 * @param force if set to true, it will update even if matrixWorldNeedsUpdate is false. Default is false
	 */
	public native void updateMatrixWorld( boolean force );
	
	/** Updates the vector from world space to local space.
	 * 
	 * @param vector A world vector
	 * @return
	 */
	public native Vector3 worldToLocal( Vector3 vector );	
	
	
	@JsType
	@FunctionalInterface
	public static interface RenderCallback
	{
		public void call( WebGLRenderer renderer, Scene scene, Camera camera, Geometry geometry, Material material, Group group );
	}
	
	@JsType
	@FunctionalInterface
	public static interface TraverseCallback
	{
		public void call( Object3D object );
	}
}
