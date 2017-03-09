package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.compatibility.JsArray;
import de.pesse.gwt.jsinterop.threeJs.math.Box3;
import de.pesse.gwt.jsinterop.threeJs.math.Vector;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;
import de.pesse.gwt.jsinterop.threeJs.math.Vector3;
import de.pesse.gwt.jsinterop.threeJs.math.Vector4;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Geometry
{	
	/** Bounding box for the Geometry, which can be calculated with .computeBoundingBox(). Default is null. */
	public Box3 boundingBox;
	
	/** Bounding sphere for the Geometry, which can be calculated with .computeBoundingSphere(). Default is null. */
	public Object boundingSphere; // TODO: Type
	
	/** Array of vertex colors, matching number and order of vertices.
	 * This is used by Points and Line and any classes derived from those such as LineSegments and various helpers. Meshes use Face3.vertexColors instead of this.
	 * To signal an update in this array, Geometry.colorsNeedUpdate needs to be set to true.
	 */
	public int[] colors;
	
	/** The array of faces describe how each vertex in the model is connected to form faces. Additionally it holds information about face and vertex normals and colors.
	 * To signal an update in this array, Geometry.elementsNeedUpdate needs to be set to true.
	 */
	public JsArray<Face3> faces;
	
	/** Helper-function to get the faces as native Java Array
	 * 
	 * @return
	 */
	@JsProperty(name="faces") public native Face3[] getFacesArray(); 
	
	/** Array of face UV layers, used for mapping textures onto the geometry.
	 * Each UV layer is an array of UVs matching the order and number of vertices in faces.
	 * To signal an update in this array, Geometry.uvsNeedUpdate needs to be set to true.
	 */
	public Object faceVertexUvs; // TODO: Investigate Type
	
	/** Unique number for this geometry instance.
	 * 
	 * @return
	 */
	@JsProperty
	public native int getId();

	/** Used to check whether this or derived classes are Geometries. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * @return
	 */
	@JsProperty
	public native boolean isGeometry();
	
	/** An array containing distances between vertices for Line geometries. This is required for LineSegments / LineDashedMaterial to render correctly. Line distances can be generated automatically with .computeLineDistances. */
	public double[] lineDistances;
	
	/** Array of morph targets. Each morph target is a Javascript object:
	 * { name: "targetName", vertices: [ new THREE.Vector3(), ... ] } Morph vertices match number and order of primary vertices.
	 */
	public Object[] morphTargets; // TODO: Create Type
	
	/** Array of morph normals. Morph normals have similar structure as morph targets, each normal set is a Javascript object:
	 * morphNormal = { name: "NormalName", normals: [ new THREE.Vector3(), ... ] } See the WebGL / morphNormals example.
	 */
	public Object[] morphNormals; // TODO: Create Type;
	
	public String name;
	
	/** When working with a SkinnedMesh, each vertex can have up to 4 bones affecting it. The skinWeights property is an array of weight values that correspond to the order of the vertices in the geometry. So for instance, the first skinWeight would correspond to the first vertex in the geometry. Since each vertex can be modified by 4 bones, a Vector4 is used to represent the skin weights for that vertex.
	 * The values of the vector should typically be between 0 and 1. For instance when set to 0 the bone transformation will have no affect. When set to 0.5 it will have 50% affect. When set to 100%, it will have 100% affect. If there is only 1 bone associated with the vertex then you only need to worry about the first component of the vector, the rest can be ignored and set to 0.
	 */
	public Vector4[] skinWeights;
	
	/** Just like the skinWeights property, the skinIndices' values correspond to the geometry's vertices. Each vertex can have up to 4 bones associated with it. So if you look at the first vertex, and the first skinIndex, this will tell you the bones associated with that vertex. For example the first vertex could have a value of ( 10.05, 30.10, 12.12 ). Then the first skin index could have the value of ( 10, 2, 0, 0 ). The first skin weight could have the value of ( 0.8, 0.2, 0, 0 ). In affect this would take the first vertex, and then the bone mesh.bones[10] and apply it 80% of the way. Then it would take the bone skeleton.bones[2] and apply it 20% of the way. The next two values have a weight of 0, so they would have no affect.<br>
		In code another example could look like this:<br>
		<pre>
		// e.g.
		geometry.skinIndices[15] = new THREE.Vector4(   0,   5,   9, 0 );
		geometry.skinWeights[15] = new THREE.Vector4( 0.2, 0.5, 0.3, 0 );
		
		// corresponds with the following vertex
		geometry.vertices[15];
		
		// these bones will be used like so:
		skeleton.bones[0]; // weight of 0.2
		skeleton.bones[5]; // weight of 0.5
		skeleton.bones[9]; // weight of 0.3
		skeleton.bones[10]; // weight of 0
		</pre>
	 */
	public Vector4[] skinIndices;
	
	/** UUID of this object instance. This gets automatically assigned and shouldn't be edited.
	 * 
	 * @return
	 */
	@JsProperty
	public native int getUuid();
	
	
	/** Returns an Array of Vertices. 
	 * The array of vertices holds the position of every vertex in the model.
	 * To signal an update in this array, .verticesNeedUpdate needs to be set to true.
	 */
	public JsArray<Vector3> vertices;
	
	/** Helper-function to get the vertices as native Java-Array
	 * 
	 * @return
	 */
	@JsProperty(name="vertices") public native Vector3[] getVerticesArray();

	/** Set to true if the vertices array has been updated.*/
	public boolean verticesNeedUpdate;

	/** Set to true if the faces array has been updated. */
	public boolean elementsNeedUpdate;
	
	/** Set to true if the uvs array has been updated. */
	public boolean uvsNeedUpdate;
	
	/** Set to true if the normals array has been updated. */
	public boolean normalsNeedUpdate;
	
	/** Set to true if the colors array or a face3 color has been updated. */
	public boolean colorsNeedUpdate;
	
	/** Set to true if a face3 materialIndex has been updated. */
	public boolean groupsNeedUpdate;
	
	/** Set to true if the linedistances array has been updated. */
	public boolean lineDistancesNeedUpdate;
	
	/** The constructor takes no arguments
	 * 
	 */
	public Geometry() {}
	
	
	public native void applyMatrix( Object matrix ); // TODO: Type

	/** Center the geometry based on the bounding box.
	 * 
	 * @return Offset
	 */
	public native Vector3 center();

	/** Creates a new clone of the Geometry. 
	 * This method copies only vertices, faces and uvs. It does not copy any other properties of the geometry.
	 * 
	 */
	public native Geometry clone();
	
	/** Computes bounding box of the geometry, updating Geometry.boundingBox attribute.
	 * 
	 */
	public native void computeBoundingBox();

	/** Computes bounding sphere of the geometry, updating Geometry.boundingSphere attribute.
	 * Neither bounding boxes or bounding spheres are computed by default. They need to be explicitly computed, otherwise they are null.
	 */
	public native void computeBoundingSphere();

	/** Computes face normals. 
	 * 
	 */
	public native void computeFaceNormals();

	/** Computes flat vertex normals. Sets the vertex normal of each vertex of each face to be the same as the face's normal.
	 * 
	 */
	public native void computeFlatVertexNormals();

	/** Compute .lineDistances. 
	 * 
	 */
	public native void computeLineDistances();
	
	/** Computes .morphNormals.
	 * 
	 */
	public native void computeMorphNormals();

	/** Computes vertex normals by averaging face normals.
	 * The contribution of each face normal to the vertex normal is weighted by the area of the face.
	 */
	public native void computeVertexNormals();
	
	/** Computes vertex normals by averaging face normals.
	 * 
	 * @param areaWeighted If true the contribution of each face normal to the vertex normal is weighted by the area of the face. Default is true.
	 */
	public native void computeVertexNormals( boolean areaWeighted );

	/** Copies vertices, faces and uvs into this geometry. It does not copy any other properties of the geometry.
	 * 
	 * @param geometry Geometry to copy things from
	 * @return this geometry
	 */
	public native Geometry copy( Geometry geometry );

	/** Removes The object from memory. 
	 * Don't forget to call this method when you remove a geometry because it can cause memory leaks.
	 */
	public native void dispose();

	/** Convert a BufferGeometry to a Geometry.
	 * 
	 * @param geometry
	 * @return
	 */
	public native Geometry fromBufferGeometry( Object geometry ); // TODO: Add BufferGeometry

	/** Rotates the geometry to face point in space. This is typically done as a one time operation, and not during a loop Use Object3D.lookAt for typical real-time mesh usage.
	 * 
	 * @param vector A world vector to look at
	 */
	public native void lookAt( Vector3 vector );

	/** Merge two geometries or geometry and geometry from object (using object's transform)
	 * 
	 * @param geometry
	 * @param matrix
	 * @param materialIndexOffset
	 */
	public native void merge( Geometry geometry, Object matrix, int materialIndexOffset ); // TODO: Investigate more
	

	/** Merge the mesh's geometry with this, also applying the mesh's transform.
	 * 
	 * @param mesh
	 */
	public native void mergeMesh( Mesh mesh );

	/** Checks for duplicate vertices using hashmap.
	 * Duplicated vertices are removed and faces' vertices are updated.
	 * 
	 * @return Number of differences
	 */
	public native int mergeVertices();

	/** Normalize the geometry. 
	 * Make the geometry centered and have a bounding sphere of radius 1.0.
	 * 
	 * @return this geometry
	 */
	public native Geometry normalize();

	/** Rotate the geometry about the X axis. This is typically done as a one time operation, and not during a loop Use Object3D.rotation for typical real-time mesh rotation.
	 * 
	 * @param radians
	 * @return this geometry
	 */
	public native Geometry rotateX( double radians );
	
	/** Rotate the geometry about the Y axis. This is typically done as a one time operation, and not during a loop Use Object3D.rotation for typical real-time mesh rotation.
	 * 
	 * @param radians
	 * @return this geometry
	 */
	public native Geometry rotateY( double radians );
	
	/** Rotate the geometry about the Z axis. This is typically done as a one time operation, and not during a loop Use Object3D.rotation for typical real-time mesh rotation.
	 * 
	 * @param radians
	 * @return this geometry
	 */
	public native Geometry rotateZ( double radians );

	/** Sorts the faces array according to material index. For complex geometries with several materials, this can result in reduced draw call and improved performance. */
	public native void sortFacesByMaterialIndex();

	/** Scale the geometry data. This is typically done as a one time operation, and not during a loop Use Object3D.scale for typical real-time mesh scaling.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this geometry
	 */
	public native Geometry scale( double x, double y, double z );

	/** Convert the geometry to JSON format.
	 * 
	 * @return
	 */
	public native Object toJSON();

	/** Translate the geometry. This is typically done as a one time operation, and not during a loop Use Object3D.position for typical real-time mesh translation.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return this geometry
	 */
	public native Geometry translate( double x, double y, double z );

}
