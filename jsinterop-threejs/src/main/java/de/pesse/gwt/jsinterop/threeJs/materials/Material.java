package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class Material
{
	
	
	/** Return a new materials with the same parameters as this material
	 * 
	 */
	public native Material clone();
	
	/** Copy the parameters from the passed material into this material
	 * 
	 * @param material
	 * @return new Material
	 */
	public native Material copy( Material material );
	
	/** This disposes the material. Textures of a material don't get disposed. These needs to be disposed by Texture
	 * 
	 */
	public native void dispose();
	
	/** Sets the properties based on the values
	 * 
	 * @param values a container with parameters
	 */
	public native void setValues( Object values );
	
	/** Convert the material to three.js JSON format
	 * 
	 * @param meta object containing metadata such as textures or images for the material
	 * @return
	 */
	public native Object toJSON( Object meta );
	
	/** Call .dispatchEvent( { type: 'update' }) on the material
	 * 
	 */
	public native void update();
}
