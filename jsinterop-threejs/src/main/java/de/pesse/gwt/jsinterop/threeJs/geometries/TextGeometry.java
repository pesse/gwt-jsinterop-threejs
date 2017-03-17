package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for the TextGeometry class of ThreeJS
 * This object creates a 3D object of text as a single object.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class TextGeometry extends ExtrudeGeometry
{
	public TextGeometry( String text, TextGeometryOptions options ) {}
}
