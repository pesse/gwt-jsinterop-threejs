package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class MeshBasicMaterial extends Material
{
	public int color;
	
	public Texture map;
	
	public MeshBasicMaterial() {} 
	
	public MeshBasicMaterial( Object parameters ) {}
}
