package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.math.Euler;
import de.pesse.gwt.jsinterop.threeJs.math.Vector3;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Object3D
{
	public Vector3 position;
	
	public Euler rotation;
	
	public native void add( Object3D... objects );
}
