package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.math.Vector3;

/** Wrapper for Face3 class of ThreeJS
 * Triangular face used in Geometry. These are created automatically for all standard geometry types, however if you are building a custom geometry you will have to create them manually.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Face3
{

	/** Vertex A index */
	public int a;
	
	/** Vertex B index */
	public int b;
	
	/** Vertex C index */
	public int c;
	
	/** Face normal - vector showing the direction of the Face3. If calculated automatically (using Geometry.computeFaceNormals), this is the normalized cross product of two edges of the triangle. Default is (0, 0, 0). */
	public Vector3 normal;

	/** Face color - for this to be used a material's vertexColors property must be set to THREE.FaceColors. */
	public int color;

	/** Array of 3 vertex normals. */
	public Vector3[] vertexNormals;

	/** Array of 3 vertex colors - for these to be used a material's vertexColors property must be set to THREE.VertexColors. */
	public int[] vertexColors;
	
	/** Material index (points to MultiMaterial.materials). Default is 0. */
	public int materialIndex;	
	
	/** Creates a new Face3
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 */
	public Face3( int a, int b, int c) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 */
	public Face3( int a, int b, int c, Vector3 normal ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 */
	public Face3( int a, int b, int c, Vector3[] normal ) {}

	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 */
	public Face3( int a, int b, int c, Vector3 normal, int color ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 */
	public Face3( int a, int b, int c, Vector3 normal, int[] color ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 */
	public Face3( int a, int b, int c, Vector3[] normal, int color ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 */
	public Face3( int a, int b, int c, Vector3[] normal, int[] color ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 * @param materialIndex materialIndex — (optional) which index of a MultiMaterial to associate with the face.
	 */
	public Face3( int a, int b, int c, Vector3 normal, int color, int materialIndex ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 * @param materialIndex materialIndex — (optional) which index of a MultiMaterial to associate with the face.
	 */
	public Face3( int a, int b, int c, Vector3 normal, int[] color, int materialIndex ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 * @param materialIndex materialIndex — (optional) which index of a MultiMaterial to associate with the face.
	 */
	public Face3( int a, int b, int c, Vector3[] normal, int color, int materialIndex ) {}
	
	/** Creates a new Face3 
	 * 
	 * @param a Vertex A index
	 * @param b Vertex B index
	 * @param c Vertex C index
	 * @param normal (optional) Face normal (Vector3) or array of vertex normals. If a single vector is passed in, this sets .normal, otherwise if an array of three vectors is passed in this sets .vertexNormals
	 * @param color (optional) Face color or array of vertex colors. If a single vector is passed in, this sets .color, otherwise if an array of three vectors is passed in this sets .vertexColors
	 * @param materialIndex materialIndex — (optional) which index of a MultiMaterial to associate with the face.
	 */
	public Face3( int a, int b, int c, Vector3[] normal, int[] color, int materialIndex ) {}
	
	/** Creates a new clone of the Face3 object.
	 * 
	 */
	public native Face3 clone();

	/** Copy the paramaters of another Face3 into this.
	 * 
	 * @param face Face to copy the parameters from
	 * @return this Face
	 */
	public native Face3 copy( Face3 face );
	
}
