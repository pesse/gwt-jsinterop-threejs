package de.pesse.gwt.jsinterop.threeJs.lights;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class DirectionalLight extends Light
{
	public DirectionalLight() {}
	public DirectionalLight( int color ) {}
	public DirectionalLight( int color, float intensity ) {}
	
}
