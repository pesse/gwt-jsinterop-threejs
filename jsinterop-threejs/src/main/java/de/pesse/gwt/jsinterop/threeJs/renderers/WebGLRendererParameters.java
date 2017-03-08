package de.pesse.gwt.jsinterop.threeJs.renderers;


import java.lang.Object;
import java.lang.String;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Helptype to give access to the possible parameters of the WebGLRenderer object
 *
 * @author pesse
 *
 */
@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class WebGLRendererParameters {

	public Object canvas;
	public boolean depth;
	public boolean premultipliedAlpha;
	public boolean loagrithmicDepthBuffer;
	public boolean antialias;
	public boolean preserveDrawingBuffer;
	public String precision;
	public boolean alpha;
	public Object context;
	public boolean stencil;

	public static class Builder {

		private WebGLRendererParameters p;

		public Builder() {
			p = new WebGLRendererParameters();
		}

		public Builder canvas( Object canvas ) {
			p.canvas = canvas;
			return this;
		}

		public Builder depth( boolean depth ) {
			p.depth = depth;
			return this;
		}

		public Builder premultipliedAlpha( boolean premultipliedAlpha ) {
			p.premultipliedAlpha = premultipliedAlpha;
			return this;
		}

		public Builder loagrithmicDepthBuffer( boolean loagrithmicDepthBuffer ) {
			p.loagrithmicDepthBuffer = loagrithmicDepthBuffer;
			return this;
		}

		public Builder antialias( boolean antialias ) {
			p.antialias = antialias;
			return this;
		}

		public Builder preserveDrawingBuffer( boolean preserveDrawingBuffer ) {
			p.preserveDrawingBuffer = preserveDrawingBuffer;
			return this;
		}

		public Builder precision( String precision ) {
			p.precision = precision;
			return this;
		}

		public Builder alpha( boolean alpha ) {
			p.alpha = alpha;
			return this;
		}

		public Builder context( Object context ) {
			p.context = context;
			return this;
		}

		public Builder stencil( boolean stencil ) {
			p.stencil = stencil;
			return this;
		}

		public WebGLRendererParameters build() {
			return p;
		}

	}

}
