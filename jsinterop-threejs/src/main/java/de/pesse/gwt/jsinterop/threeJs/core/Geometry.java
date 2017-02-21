package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.compatibility.JsArray;
import de.pesse.gwt.jsinterop.threeJs.math.Vector;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Geometry
{	
	@JsProperty
	public native int getId();
	
	@JsProperty
	public native int getUuid();
	
	@JsProperty
	public native String getName();
	
	@JsProperty
	public native String getType();
	
	/** Returns an Array of Vertices. 
	 * The array of vertices holds the position of every vertex in the model.
	 * To signal an update in this array, .verticesNeedUpdate needs to be set to true.
	 * 
	 * @return Array of Vertices
	 */
	@JsProperty
	public native JsArray<Vector> getVertices();
	
	
	/** Sets an Array of Vertices
	 * The array of vertices holds the position of every vertex in the model.
	 * To signal an update in this array, .verticesNeedUpdate needs to be set to true.
	 * 
	 * @param Array of Vertices
	 */
	@JsProperty
	public native void setVertices( JsArray<Vector> vertices );
	
	@JsProperty
	public native boolean isGeometry();
	
	public native void applyMatrix( Object matrix ); // TODO: Type
	
}
