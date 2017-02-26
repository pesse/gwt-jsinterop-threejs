package de.pesse.gwt.jsinterop.volumetricFire;

import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative=true, namespace=JsPackage.GLOBAL)
public class VolumetricFire
{
	public static String texturePath;
	
	@JsProperty public native Mesh getMesh();
	
	public VolumetricFire ( double fireWidth, double fireHeight, double fireDepth, double sliceSpacing, Camera camera ) {}

	public native void update(int elapsed);
}
