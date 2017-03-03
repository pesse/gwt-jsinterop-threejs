package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class MeshPhongMaterial extends Material
{
	public int color;
	
	public MeshPhongMaterial() {}
	
	/** parameters - (optional) an object with one or more properties defining the material's appearance. Any property of the material (including any property inherited from Material) can be passed in here.
	 *  
	 *  The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is called internally.
	 */
	public MeshPhongMaterial( MeshPhongMaterialParameters parameters ) {}
}
