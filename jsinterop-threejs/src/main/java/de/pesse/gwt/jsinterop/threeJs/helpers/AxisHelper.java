package de.pesse.gwt.jsinterop.threeJs.helpers;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Object3D;

/** Wrapper for the AxisHelper class of ThreeJS
 * 
 * An axis object to visualize the the 3 axes in a simple way. 
 * The X axis is red. The Y axis is green. The Z axis is blue.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class AxisHelper extends Object3D
{
	public AxisHelper() {}
	
	public AxisHelper ( int size ) {}
}
