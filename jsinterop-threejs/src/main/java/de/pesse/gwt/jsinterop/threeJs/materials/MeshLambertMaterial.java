package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

/**
 * A material for non-shiny surfaces, without specular highlights.
 * 
 * The uses a non-physically based Lambertian model	for calculating reflectance. This can simulate some surfaces (such as untreated wood or stone) well, but cannot simulate shiny surfaces with specular highlights (such as varnished wood).
 * 
 * Shading is calculated using a Gouraud shading model. This calculates shading per vertex (i.e. in the vertex shader) and interpolates the results over the polygon's faces.
 * 
 * Due to the simplicity of the reflectance and illumination models, performance will be greater when using this material over the MeshPhongMaterial,	MeshStandardMaterial or MeshPhysicalMaterial, at the cost of some graphical accuracy.
 * @author derpesse
 *
 */
@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class MeshLambertMaterial extends Material
{
	public int color;
	

	public Texture map;
	
	public boolean wireframe;
	
	public MeshLambertMaterial() {}
	
	/** parameters - (optional) an object with one or more properties defining the material's appearance. Any property of the material (including any property inherited from Material) can be passed in here.
	 *  
	 *  The exception is the property color, which can be passed in as a hexadecimal string and is 0xffffff (white) by default. Color.set( color ) is called internally.
	 */
	public MeshLambertMaterial( MeshLambertMaterialParameters parameters ) {}
	
	
	
	
	
}
