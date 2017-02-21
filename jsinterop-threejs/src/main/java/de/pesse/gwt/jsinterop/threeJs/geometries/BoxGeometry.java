package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class BoxGeometry extends Geometry
{
	public BoxGeometry() {}
	
	public BoxGeometry(int width, int height, int depth) {}
	
	public BoxGeometry(int width, int height, int depth, int widthSegments) {}
	
	public BoxGeometry(int width, int height, int depth, int widthSegments, int heightSegments) {}
	
	public BoxGeometry( int width, int height, int depth, int widthSegments, int heightSegments, int depthSegments ) {}
	
	@JsProperty
	public native Object getParameters();
	
	@JsProperty
	public native void setParameters( Object parameters ); // TODO: Type?
	
}
