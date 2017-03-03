package de.pesse.gwt.jsinterop.threeJs.lights;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Object3D;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class Light extends Object3D
{
	public double intensity;
}
