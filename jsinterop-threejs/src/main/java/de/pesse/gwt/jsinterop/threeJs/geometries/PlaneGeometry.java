package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;

/** A class for generating plane geometries
 * 
 * @author derpesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class PlaneGeometry extends Geometry
{
	public PlaneGeometry( int width, int height ) {}

	public PlaneGeometry( int width, int height, int widthSegments) {}
	
	public PlaneGeometry( int width, int height, int widthSegments, int heightSegments ) {}
}
