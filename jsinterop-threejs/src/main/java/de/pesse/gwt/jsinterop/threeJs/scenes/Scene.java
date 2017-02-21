package de.pesse.gwt.jsinterop.threeJs.scenes;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Object3D;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class Scene extends Object3D
{
	public Object background;
	public Fog fog;
	public Material overrideMaterial;
	public boolean autoUpdate;
	
	public native Object toJSON( Object meta );
	
}
