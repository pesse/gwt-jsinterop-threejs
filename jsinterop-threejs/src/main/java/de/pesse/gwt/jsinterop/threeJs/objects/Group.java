package de.pesse.gwt.jsinterop.threeJs.objects;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Object3D;

/** This is almost identical to an Object3D. It's purpose is to make working with groups of objects syntactically clearer.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Group extends Object3D
{
	/** A string 'Group'. This should not be changed.
	 * 
	 * @return
	 */
	@JsProperty public native String getType(); 
}
