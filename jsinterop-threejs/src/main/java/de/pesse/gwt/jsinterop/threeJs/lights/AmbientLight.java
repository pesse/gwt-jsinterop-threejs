package de.pesse.gwt.jsinterop.threeJs.lights;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for AmbientLight Class in ThreeJS
 * 
 * This light globally illuminates all objects in the scene equally.
 * This light cannot be used to cast shadows as it does not have a direction.
 * 
 * @author pesse
 *
 */
@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class AmbientLight extends Light
{
	/** This is set to undefined in the constructor as ambient lights cannot cast shadows.*/
	@JsProperty public native Boolean getCastShadow();
	
	/** Used to check whether this or derived classes are ambient lights. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * 
	 * @return
	 */
	@JsProperty(name="isAmbientLight") public native boolean isAmbientLight();
	
	
	public AmbientLight() {}
	public AmbientLight( int color ) {}
	
	/** Creates a new AmbientLight. 
	 * 
	 * @param color Numeric value of the RGB component of the color. 
	 * @param intensity Numeric value of the light's strength/intensity.
	 */
	public AmbientLight( int color, double intensity ) {}
	
	
}
