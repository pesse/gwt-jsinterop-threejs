package de.pesse.gwt.jsinterop.threeJs.renderers;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class WebGLRenderer
{
	@JsType(isNative=true, namespace=JsPackage.GLOBAL, name="Object")
	public static class Parameters
	{
		public Object canvas; // TODO: Type
		public Object context; // TODO: Type
		public String precision;
		public boolean alpha;
		public boolean premultipliedAlpha;
		public boolean antialias;
		public boolean stencil;
		public boolean preserveDrawingBuffer;
		public boolean depth;
		public boolean loagrithmicDepthBuffer;
	}
	
	public static class ParameterBuilder
	{
		private Parameters p;
		
		public ParameterBuilder()
		{
			p = new Parameters();
		}
		
		public ParameterBuilder canvas( Object canvas )
		{
			p.canvas = canvas;
			return this;
		}
		
		public Parameters build()
		{
			return p;
		}
	}
	
	public Object domElement;
	
	public WebGLRenderer() {}
	
	public WebGLRenderer( Parameters parameters ) {}
	
	/** Attempt to allocate a texture unit for use by a shader. Will warn if trying to allocate more texture units than the GPU supports. 
	 * This is mainly used internally. See capabilities.maxTextures.
	 */
	public native void allocTextureUnit();
	
	/** Tells the renderer to clear its color, depth or stencil drawing buffer(s).
	 */
	public native void clear();
	
	public native void clear( boolean color);
	
	public native void clear( boolean color, boolean depth);
	
	/** Tells the renderer to clear its color, depth or stencil drawing buffer(s). This method initializes the color buffer to the current clear color value. Arguments default to true.
	 * 
	 * @param color
	 * @param depth
	 * @param stencil
	 */
	public native void clear( boolean color, boolean depth, boolean stencil );
	
	/** Clear the color buffer. Equivalent to calling .clear( true, false, false )´
	 * 
	 */
	public native void clearColor();
	
	/** Clear the depth buffer. Equivalent to calling .clear( false, true, false ).
	 * 
	 */
	public native void clearDepth();
	
	/** Clear the stencil buffers. Equivalent to calling .clear( false, false, true ).
	 * 
	 */
	public native void clearStencil();
	

	/** This method clears a rendertarget. To do this, it activates the rendertarget.
	 * Will clear color, depth and stencil.
	 * 
	 * @param renderTarget The renderTarget that needs to be cleared
	 */
	public native void clearTarget( Object renderTarget );
	
	/**  This method clears a rendertarget. To do this, it activates the rendertarget.
	 * Will clear depth and stencil. Will clear color if set
	 * 
	 * @param renderTarget The renderTarget that needs to be cleared
	 * @param color If set, then the color gets cleared
	 */
	public native void clearTarget( Object renderTarget, boolean color );
	
	/**  This method clears a rendertarget. To do this, it activates the rendertarget.
	 * Will clear depth. Will clear color and stencil if set
	 * 
	 * @param renderTarget The renderTarget that needs to be cleared
	 * @param color If set, then the color gets cleared
	 * @param depth If set, then the depth gets cleared
	 */
	public native void clearTarget( Object renderTarget, boolean color, boolean depth );
	
	/** This method clears a rendertarget. To do this, it activates the rendertarget.
	 * 
	 * @param renderTarget The renderTarget that needs to be cleared
	 * @param color If set, then the color gets cleared
	 * @param depth If set, then the depth gets cleared
	 * @param stencil If set, then the stencil gets cleared
	 */
	public native void clearTarget( Object renderTarget, boolean color, boolean depth, boolean stencil );
	
	/** Dispose of the current rendering context
	 * 
	 */
	public native void dispose();
	
	// TODO: Not including extensions.get. Still have to think about the How and If
	
	/** Simulate loss of the WebGL context. This requires support for the WEBGL_lose_context extensions. 
	 * According to WebGLStats, as of February 2016 90% of WebGL enabled devices support this.
	 */
	public native void forceContextLoss();
	
	/** Returns a float with the current clear alpha. Ranges from 0 to 1
	 * 
	 * @return float from 0 to 1
	 */
	public native float getClearAlpha();
	
	/** Returns a THREE.Color instance with the current clear color
	 * 
	 * @return THREE.Color
	 */
	public native Object getClearColor(); // TODO: Type
	
	/** Returns the current WebGL context
	 * 
	 * @return WebGL context
	 */
	public native Object getContext(); // TODO: Type
	
	// TODO: Continue
	
	/** Sets device pixel ratio. This is usually used for HiDPI device to prevent bluring output canvas.
	 * 
	 * @param value
	 */
	public native void setPixelRatio( float value );
	
	/** Resizes the output canvas to (width, height) with device pixel ratio taken into account, and also sets the viewport to fit that size, starting in (0, 0)
	 * Implicitly sets updateStyle to true
	 * 
	 * @param width
	 * @param height
	 */
	public native void setSize( int width, int height );
	
	/** Resizes the output canvas to (width, height) with device pixel ratio taken into account, and also sets the viewport to fit that size, starting in (0, 0). 
	 * Setting updateStyle to true (default) adds explicit pixel units to the output canvas style.
	 * 
	 * @param width
	 * @param height
	 * @param updateStyle
	 */
	public native void setSize( int width, int height, boolean updateStyle );
	
	public native void render( Scene scene, Camera camera );
	
	public native void render( Scene scene, Camera camera, Object renderTarget );
	
	public native void render( Scene scene, Camera camera, Object renderTarget, boolean forceClear );
	
}
