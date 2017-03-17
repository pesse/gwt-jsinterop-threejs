package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for Font class of ThreeJS
 * 
 * Create a set of Shapes representing a font loaded in JSON format.
 * This is used internally by the FontLoader.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Font
{
	/** the JSON data passed in the constructor	 */
	public Object data;
	
	/** Used to check whether this or derived classes are fonts. Default is true.
	 * You should not change this, as it used internally by the renderer for optimisation.
	 * 
	 * @return
	 */
	@JsProperty(name="isFont") public native boolean isFont();
	
	/** This constructor creates a new Font, which is an array of Shapes
	 * 
	 * @param data
	 */
	public Font( Object data ) {}

	/** Creates an array of Shapes representing the text in the font
	 * 
	 * @param text string of text.
	 * @return
	 */
	public native Shape[] generateShapes( String text );
	
	/** Creates an array of Shapes representing the text in the font
	 * 
	 * @param text string of text.
	 * @param size (optional) scale for the Shapes. Default is 100.
	 * @return
	 */
	public native Shape[] generateShapes( String text, double size );
	
	/** Creates an array of Shapes representing the text in the font
	 * 
	 * @param text string of text.
	 * @param size (optional) scale for the Shapes. Default is 100.
	 * @param divisions (optional) fineness of the Shapes. Default is 5.
	 * @return
	 */
	public native Shape[] generateShapes( String text, double size, int divisions );
}
