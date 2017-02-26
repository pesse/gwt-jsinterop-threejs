package de.pesse.gwt.jsinterop.threeJs.textures;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;

/** Wrapper for the Texture class in ThreeJS
 * 
 * Create a texture to apply to a surface or as a reflection or refraction map.
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Texture
{
	/** Readonly - unique number for this texture instance. */
	@JsProperty public native int getId();
	
	/** UUID of this object instance. This gets automatically assigned, so this shouldn't be edited. */
	@JsProperty public native String getUuid();

	/** Optional name of the object (doesn't need to be unique). Default is an empty string. */
	public String name;
	
	/** An image object, typically created using the TextureLoader.load method. This can be any image (e.g., PNG, JPG, GIF, DDS) or video (e.g., MP4, OGG/OGV) type supported by three.js.
	 * To use video as a texture you need to have a playing HTML5 video element as a source for your texture image and continuously update this texture as long as video is playing - the VideoTexture class handles this automatically.
	 */
	public Object image;
	
	/** Array of user-specified mipmaps (optional). */
	public Object mipmaps; // TODO: Type
	
	/** How the image is applied to the object. An object type of THREE.UVMapping is the default, where the U,V coordinates are used to apply the map.
	 * See the texture constants page for other mapping types.
	 */
	public int mapping;
	
	/** This defines how the texture is wrapped horizontally and corresponds to U in UV mapping.
	 * The default is THREE.ClampToEdgeWrapping, where the edge is clamped to the outer edge texels. The other two choices are THREE.RepeatWrapping and THREE.MirroredRepeatWrapping. See the texture constants page for details.
	 */
	public int wrapS;
	
	/** This defines how the texture is wrapped vertically and corresponds to V in UV mapping.
	 * The same choices are available as for # .wrapS .
	 * 
	 * NOTE: tiling of images in textures only functions if image dimensions are powers of two (2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, ...) in terms of pixels. Individual dimensions need not be equal, but each must be a power of two. This is a limitation of WebGL, not three.js.
	 */
	public int wrapT;

	/** How the texture is sampled when a texel covers more than one pixel. The default is THREE.LinearFilter, which takes the four closest texels and bilinearly interpolates among them. The other option is THREE.NearestFilter, which uses the value of the closest texel.
	 * See the texture constants page for details.
	 */
	public int magFilter;
	
	/** How the texture is sampled when a texel covers less than one pixel. The default is THREE.LinearMipMapLinearFilter, which uses mipmapping and a trilinear filter. 
	 * See the texture constants page for all possible choices.
	 */
	public int minFilter;
	
	/** The number of samples taken along the axis through the pixel that has the highest density of texels. By default, this value is 1. A higher value gives a less blurry result than a basic mipmap, at the cost of more texture samples being used. Use renderer.getMaxAnisotropy() to find the maximum valid anisotropy value for the GPU; this value is usually a power of 2. */
	public int anisotropy;
	
	/** The default is THREE.RGBAFormat, although the TextureLoader will automatically et this to THREE.RGBFormat for JPG images. 
	 * See the texture constants page for details of other formats.
	 */
	public int format;
	
	/** This must correspond to the .format. The default is THREE.UnsignedByteType, which will be used for most texture formats.
	 * See the texture constants page for details of other formats.
	 */
	public int type;

	/** How much a single repetition of the texture is offset from the beginning, in each direction U and V. Typical range is 0.0 to 1.0. */
	public Vector2 offset;

	/** How many times the texture is repeated across the surface, in each direction U and V. */
	public Vector2 repeat;

	/** Whether to generate mipmaps (if possible) for a texture. True by default. Set this to false if you are creating mipmaps manually. */
	public boolean generateMipmaps;

	/** False by default, which is the norm for PNG images. Set to true if the RGB values have been stored premultiplied by alpha. */
	public boolean premultiplyAlpha;

	/** True by default. Flips the image's Y axis to match the WebGL texture coordinate space. */
	public boolean flipY;

	/** 4 by default. Specifies the alignment requirements for the start of each pixel row in memory. The allowable values are 1 (byte-alignment), 2 (rows aligned to even-numbered bytes), 4 (word-alignment), and 8 (rows start on double-word boundaries). See glPixelStorei for more information. */
	public int unpackAlignment;

	/** THREE.LinearEncoding is the default. See the texture constants page for details of other formats.
	 * Note that ff this value is changed on a texture after the material has been used, it is necessary to trigger a Material.needsUpdate for this value to be realized in the shader.
	 */
	public int encoding;

	/** This starts at 0 and counts how many times # .needsUpdate is set to true. */
	@JsProperty public native int getVersion();

	/** A callback function, called when the texture is updated (e.g., when needsUpdate has been set to true and then the texture is used). */
	@JsProperty(name="onUpdate") public native UpdateCallback getOnUpdateCallback();
	
	/** A callback function, called when the texture is updated (e.g., when needsUpdate has been set to true and then the texture is used). */
	@JsProperty(name="onUpdate") public native void setOnUpdateCallback( UpdateCallback callback );

	/** Set this to true to trigger an update next time the texture is used. Particularly important for setting the wrap mode. */
	public boolean needsUpdate;
	
	public Texture( Object image, int mapping, int wrapS, int wrapT, int magFilter, int minFilter, int format, int type, int anisotropy ) {}

	/** Make copy of the texture. Note this is not a "deep copy", the image is shared.
	 * 
	 * @param texture
	 * @return
	 */
	public native Texture clone( Texture texture );
	
	/** Convert the material to three.js JSON format.
	 * 
	 * @return
	 */
	public native Object toJSON();
	
	/** Convert the material to three.js JSON format.
	 * 
	 * @param meta optional object containing metadata
	 * @return
	 */
	public native Object toJSON( Object meta );
	
	/** Call EventDispatcher.dispatchEvent with a 'dispose' event type.
	 * 
	 */
	public native void dispose();
	
	/** Transform the uv based on the value of this texture's .repeat, .offset, .wrapS, .wrapT and .flipY properties.
	 *
	 */
	public native void transformUv ( Vector2 uv ); // TODO: Check type

	
	@JsType
	@FunctionalInterface
	public static interface UpdateCallback
	{
		public void call( Texture texture );
	}
}
