package de.pesse.gwt.jsinterop.threeJs.geometries;

import de.pesse.gwt.jsinterop.threeJs.core.Font;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class TextGeometryOptions
{
	public Font font;
	public double size;
	public double height;
	public int curveSegments;
	public boolean bevelEnabled;
	public double bevelThickness;
	public double bevelSize;
	public int bevelSegments;
	
	public static class Builder {

		private TextGeometryOptions p;

		public Builder() {
			p = new TextGeometryOptions();
		}

		/** How far from text outline is bevel. Default is 8.
		 * 
		 * @param bevelSize
		 * @return
		 */
		public Builder bevelSize( double bevelSize ) {
			p.bevelSize = bevelSize;
			return this;
		}

		/** Number of bevel segments. Default is 3.
		 * 
		 * @param bevelSegments
		 * @return
		 */
		public Builder bevelSegments( int bevelSegments ) {
			p.bevelSegments = bevelSegments;
			return this;
		}

		/** Size of the text.
		 * 
		 * @param size
		 * @return
		 */
		public Builder size( double size ) {
			p.size = size;
			return this;
		}

		/** Number of points on the curves. Default is 12.
		 * 
		 * @param curveSegments
		 * @return
		 */
		public Builder curveSegments( int curveSegments ) {
			p.curveSegments = curveSegments;
			return this;
		}

		/** Turn on bevel. Default is False.
		 * 
		 * @param bevelEnabled
		 * @return
		 */
		public Builder bevelEnabled( boolean bevelEnabled ) {
			p.bevelEnabled = bevelEnabled;
			return this;
		}

		/** The font to use
		 * 
		 * @param font
		 * @return
		 */
		public Builder font( Font font ) {
			p.font = font;
			return this;
		}

		/** Thickness to extrude text. Default is 50.
		 * 
		 * @param height
		 * @return
		 */
		public Builder height( double height ) {
			p.height = height;
			return this;
		}

		/** How deep into text bevel goes. Default is 10
		 * 
		 * @param bevelThickness
		 * @return
		 */
		public Builder bevelThickness( double bevelThickness ) {
			p.bevelThickness = bevelThickness;
			return this;
		}

		public TextGeometryOptions build() {
			return p;
		}

	}
}	
