package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class BoxBufferGeometry extends BoxGeometry
{	
	public BoxBufferGeometry(int width, int height, int depth) {}
	
	public BoxBufferGeometry(int width, int height, int depth, int widthSegments) {}
	
	public BoxBufferGeometry(int width, int height, int depth, int widthSegments, int heightSegments) {}
	
	public BoxBufferGeometry(int width, int height, int depth, int widthSegments, int heightSegments, int depthSegments) {}

}
