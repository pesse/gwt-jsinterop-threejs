package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;

/** Wrapper for the PlaneBufferGeometry class of ThreeJS
 * 
 * This is the BufferGeometry port of PlaneGeometry.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class PlaneBufferGeometry extends Geometry
{
	/** Will create a new PlaneBufferGeometry with widhtSegments = 1 and heightSegments = 1
	 * 
	 * @param width Width along the X axis
	 * @param height Height along the Y axis
	 */
	public PlaneBufferGeometry( double width, double height ) {}
	
	/** Will create a new PlaneBufferGeometry with widhtSegments = 1
	 * 
	 * @param width Width along the X axis
	 * @param height Height along the Y axis
	 * @param widthSegments
	 */
	public PlaneBufferGeometry( double width, double height, int widthSegments ) {}
	
	/** Will create a new PlaneBufferGeometry
	 * 
	 * @param width Width along the X axis
	 * @param height Height along the Y axis
	 * @param widthSegments
	 * @param heightSegments
	 */
	public PlaneBufferGeometry( double width, double height, int widthSegments, int heightSegments ) {}
}
