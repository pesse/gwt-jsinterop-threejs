package de.pesse.gwt.jsinterop.threeJs.lights;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for the PointLight class of ThreeJS
 * 
 *  A light that gets emitted from a single point in all directions. A common use case for this is to replicate the light emitted from a bare lightbulb.
 *  This light can cast shadows - see LightShadow page for details.
 * 
 * @author pesse
 *
 */
@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class PointLight extends Light
{
	/** The amount the light dims along the distance of the light
	 * In physically correct mode, decay = 2 leads to physically realistic light falloff.
	 * Default is 1.
	 */
	public float decay;
	
	/** If non-zero, light will attenuate linearly from maximum intensity at the light's position down to zero at this distance from the light. Default is 0.0. */
	public float distance;
	
	/** Used to check whether this or derived classes are point lights. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * @return
	 */
	@JsProperty(name="isPointLight") public native boolean isPointLight();
	
	/** The light's power.
	 * In physically correct mode, the luminous power of the light measured in lumens. Default - 4PI.
	 * This is directly related to the intensity in the ratio
	 * power = intensity * 4Π and changing this will also change the intensity.
	 */
	@JsProperty public native double getPower();
	
	/** The light's power.
	 * In physically correct mode, the luminous power of the light measured in lumens. Default - 4PI.
	 * This is directly related to the intensity in the ratio
	 * power = intensity * 4Π and changing this will also change the intensity.
	 */
	@JsProperty public native void setPower( double power );
	
	/** A LightShadow used to calculate shadows for this light.
	 * The lightShadow's camera is set to a PerspectiveCamera with fov of 90, aspect of 1, near clipping plane at 0.5 and	far clipping plane at 500.
	 */
	public LightShadow shadow;

	public PointLight( ) {}
	public PointLight( int color ) {}
	public PointLight( int color, double intensity ) {}
	public PointLight( int color, double intensity, double distance) {}
	
	/** Creates a new PointLight
	 * 
	 * @param color (optional) hexadecimal color of the light. Default is 0xffffff (white).
	 * @param intensity (optional) numeric value of the light's strength/intensity. Default is 1.
	 * @param distance The distance from the light where the intensity is 0. When set to 0, then the light never stops. Default is 0.
	 * @param decay The amount the light dims along the distance of the light. Default is 1. For physically correct lighting, set this to 2.
	 */
	public PointLight( int color, double intensity, double distance, double decay ) {}
	
	/** Copies value of all the properties from the source to this PointLight.
	 * 
	 * @param pointLight PointLight to copy properties from
	 * @return This PointLight
	 */
	public native PointLight copy ( PointLight pointLight );

}
