package de.pesse.gwt.jsinterop.threeJs.math;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for the Box3 class of ThreeJS
 * 
 * Represents a box or cube in 3D space. The main purpose of this is to represent the Minimum Bounding Boxes for objects.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Box3
{
	public Box3() {}
	public Box3( Vector3 min ) {}
	public Box3( Vector3 min, Vector3 max ) {}
	
	// TODO: Finish
}
