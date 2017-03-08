package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.compatibility.JsArray;
import de.pesse.gwt.jsinterop.threeJs.math.Vector;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;
import de.pesse.gwt.jsinterop.threeJs.math.Vector3;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Geometry
{	
	@JsProperty
	public native int getId();
	
	@JsProperty
	public native int getUuid();
	
	public String name;
	
	@JsProperty
	public native String getType();
	
	/** Returns an Array of Vertices. 
	 * The array of vertices holds the position of every vertex in the model.
	 * To signal an update in this array, .verticesNeedUpdate needs to be set to true.
	 */
	public JsArray<Vector3> vertices;
	
	public JsArray<Face3> faces;
	
	@JsProperty
	public native boolean isGeometry();
	
	public native void applyMatrix( Object matrix ); // TODO: Type
	
}
