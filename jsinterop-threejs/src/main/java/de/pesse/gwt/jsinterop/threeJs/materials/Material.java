package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.math.Plane;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class Material
{
	/** Sets the alpha value to be used when running an alpha test. The material will not be renderered if the opacity is lower than this value. Default is 0. */
	public double alphaTest;
	
	/** Blending destination. Default is OneMinusSrcAlphaFactor. See the destination factors constants for all possible values. 
	 * The material's blending-Property must be set to CustomBlending for this to have any effect.
	 */
	public int blendDst;
	
	/** The tranparency of the .blendDst. Default is null. */
	public Double blendDstAlpha;
	
	/** Blending equation to use when applying blending. Default is AddEquation. See the blending equation constants for all possible values.
	 * The material's # .blending must be set to CustomBlending for this to have any effect.
	 */
	public int blendEquation;
	
	/** The tranparency of the .blendEquation. Default is null. */
	public Double blendEquationAlpha;
	
	/** Which blending to use when displaying objects with this material. 
	 * This must be set to CustomBlending to use custom # .blendSrc , # .blendDst or # .blendEquation .
	 * See the blending mode constants for all possible values. Default is NormalBlending.
	*/
	public int blending;
	
	/** Blending source. Default is SrcAlphaFactor. See the source factors constants for all possible values.
	 * The material's # .blending must be set to CustomBlending for this to have any effect.
	 */
	public int blendSrc;
	
	/** The tranparency of the .blendSrc. Default is null. */
	public Long blendSrcAlpha;
	
	/** Changes the behavior of clipping planes so that only their intersection is clipped, rather than their union. Default is false. */
	public boolean clipIntersection;
	
	/** User-defined clipping planes specified as THREE.Plane objects in world space. These planes apply to the objects this material is attached to. Points in space whose dot product with the plane is negative are cut away. See the WebGL / clipping /intersection example. Default is null. */
	public Plane[] clippingPlanes;
	
	/** Defines whether to clip shadows according to the clipping planes specified on this material. Default is false. */
	public boolean clipShadows;
	
	/** Whether to render the material's color. This can be used in conjunction with a mesh's # .renderOrder property to create invisible objects that occlude other objects. Default is true. */
	public boolean colorWrite;

	/** Which depth function to use. Default is LessEqualDepth. See the depth mode constants for all possible values. */
	public int depthFunc;

	/** Whether to have depth test enabled when rendering this material. Default is true. */
	public boolean depthTest;

	/** Whether rendering this material has any effect on the depth buffer. Default is true.
	 * When drawing 2D overlays it can be useful to disable the depth writing in order to layer several things together without creating z-index artifacts.
	 */
	public boolean depthWrite;
	
	/** Whether the material is affected by fog. Default is true. */
	public boolean fog;
	
	/** Unique number for this material instance.
	 * 
	 * @return
	 */
	@JsProperty public native int getId();

	/** Used to check whether this or derived classes are materials. Default is true.
	 * You should not change this, as it used internally for optimisation.
	 * @return
	 */
	@JsProperty(name="isMaterial") public native boolean isMaterial();
	
	/** Whether the material is affected by lights. Default is true. */
	public boolean lights;

	/** Optional name of the object (doesn't need to be unique). Default is an empty string. */
	public String name;

	/** Specifies that the material needs to be updated at the WebGL level. Set it to true if you made changes that need to be reflected in WebGL.
	 * This property is automatically set to true when instancing a new material.
	 */
	public boolean needsUpdate;

	/** Float in the range of 0.0 - 1.0 indicating how transparent the material is. A value of 0.0 indicates fully transparent, 1.0 is fully opaque. 
	 * If the material's # .transparent property is not set to true, the material will remain fully opaque and this value will only affect its color.
	 * Default is 1.0.
	 */
	public double opacity;

	/** Amount of triangle expansion at draw time. This is a workaround for cases when gaps appear between triangles when using CanvasRenderer. 0.5 tends to give good results across browsers. Default is 0. */
	public double overdraw;

	/** Whether to use polygon offset. Default is false. This corresponds to the GL_POLYGON_OFFSET_FILL WebGL feature. */
	public boolean polygonOffset;

	/** Sets the polygon offset factor. Default is 0. */
	public double polygonOffsetFactor;

	/** Sets the polygon offset units. Default is 0. */
	public int polygonOffsetUnits;
	
	/** Override the renderer's default precision for this material. Can be "highp", "mediump" or "lowp". Defaults is null. */ 
	public String precision;

	/** Whether to premultiply the alpha (transparency) value. See WebGL / Materials / Transparency for an example of the difference. Default is false. */
	public boolean premultipliedAlpha;

	/** Defines how the material is shaded. This can be either THREE.SmoothShading (default)	or THREE.FlatShading. */
	public int shading;
	
	/** Defines which side of faces will be rendered - front, back or both. Default is THREE.FrontSide. Other options are THREE.BackSide and THREE.DoubleSide. */
	public int side;
	
	/** Defines whether this material is transparent. This has an effect on rendering as transparent objects need special treatment and are rendered after non-transparent objects. 
	 * When set to true, the extent to which the material is transparent is controlled by setting it's # .opacity property. 
	 * Default is false.
	 */
	public boolean transparent;
	
	/** Value is the string 'Material'. This shouldn't be changed, and can be used to find all objects of this type in a scene.
	 * 
	 * @return
	 */
	@JsProperty public native String getType();
	
	/** UUID of this material instance. This gets automatically assigned, so this shouldn't be edited.
	 * 
	 * @return
	 */
	@JsProperty public native String getUuid();

	/** Defines whether vertex coloring is used. Default is THREE.NoColors. Other options are THREE.VertexColors and THREE.FaceColors. */
	public int vertexColors;

	/** Defines whether this material is visible. Default is true. */
	public boolean visible;
		
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
