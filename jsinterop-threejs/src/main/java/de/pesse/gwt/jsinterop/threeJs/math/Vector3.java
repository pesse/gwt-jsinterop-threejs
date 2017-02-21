package de.pesse.gwt.jsinterop.threeJs.math;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Vector3 implements Vector
{
	public double x;
	public double y;
	public double z;
	
	public native void set( double x, double y, double z );
	
}
