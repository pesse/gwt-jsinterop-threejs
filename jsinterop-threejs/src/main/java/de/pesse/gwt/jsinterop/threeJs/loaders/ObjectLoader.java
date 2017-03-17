package de.pesse.gwt.jsinterop.threeJs.loaders;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/** Wrapper for the ObjectLoader class of ThreeJS
 * A loader for loading a JSON resource. Unlike the JSONLoader, this one make use of the .type attributes of objects to map them to their original classes.
 * Note that this loader can't load Geometries. Use JSONLoader instead for that.
 * This uses the FileLoader internally for loading files.
 * 
 * @author pesse
 *
 */
@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class ObjectLoader
{

	/** If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is undefined. */
	public String crossOrigin;

	/** The loadingManager the loader is using. Default is DefaultLoadingManager.*/
	public LoadingManager manager;

	/** The base path or URL from which textures will be loaded. See .setTexturePath. Default is the empty string. */
	public String texturePath;
	
	/** Creates a new ObjectLoader
	 * 
	 */
	public ObjectLoader() {}
	
	/** Creates a new ObjectLoader.
	 * 
	 * @param manager The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
	 */
	public ObjectLoader( LoadingManager manager ) {}
	

	/** Begin loading from url and call onLoad with the parsed response content.
	 * 
	 * @param url the path or URL to the file. This can also be a Data URI.
	 * @param onLoad Will be called when load completes. The argument will be the loaded object.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public native Object load( String url, OnLoadCallback onLoad );
	
	/** Begin loading from url and call onLoad with the parsed response content.
	 * 
	 * @param url the path or URL to the file. This can also be a Data URI.
	 * @param onLoad Will be called when load completes. The argument will be the loaded object.
	 * @param onProgress Will be called while load progresses. The argument will be the XmlHttpRequest instance, that contain .total and .loaded bytes.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public native Object load( String url, OnLoadCallback onLoad, OnProgressCallback onProgress );
	
	/** Begin loading from url and call onLoad with the parsed response content.
	 * 
	 * @param url the path or URL to the file. This can also be a Data URI.
	 * @param onLoad Will be called when load completes. The argument will be the loaded object.
	 * @param onProgress Will be called while load progresses. The argument will be the XmlHttpRequest instance, that contain .total and .loaded bytes.
	 * @param onError Will be called when load errors.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public native Object load( String url, OnLoadCallback onLoad, OnProgressCallback onProgress, OnErrorCallback onError );

	/** Parse a JSON structure and return a threejs object. This is used internally by .load, but can also be used directly to parse a previously loaded JSON structure.
	 * 
	 * @param json required. The JSON source to parse.
	 */
	public native Object parse( Object json );
	

	/** Parse a JSON structure and return a threejs object. This is used internally by .load, but can also be used directly to parse a previously loaded JSON structure.
	 * 
	 * @param json required. The JSON source to parse.
	 * @param onLoad Will be called when parsed completes. The argument will be the parsed object.
	 */
	public native Object parse( Object json, OnLoadCallback onLoad );
	
	/** This is used .parse to parse any geometries or buffer geometries in the JSON structure. Internally it uses JSONLoader for geometries and BufferGeometryLoader for buffer geometries.
	 * 
	 * @param json the JSON source to parse
	 * @return
	 */
	public native Object parseGeometries( Object json );
	
	/** This is used .parse to parse any materials in the JSON structure using MaterialLoader.
	 * 
	 * @param json the JSON source to parse
	 * @return
	 */
	public native Object parseMaterials( Object json );
	
	/** This is used .parse to parse any animations in the JSON structure, using AnimationClip.parse.
	 * 
	 * @param json the JSON source to parse
	 * @return
	 */
	public native Object parseAnimations( Object json );
	
	
	/** This is used .parse to parse any images in the JSON structure, using ImageLoader.
	 * 
	 * @param json the JSON source to parse
	 * @return
	 */
	public native Object parseImages( Object json );
	
	
	/** This is used .parse to parse any textures in the JSON structure.
	 * 
	 * @param json the JSON source to parse
	 * @return
	 */
	public native Object parseTextures( Object json );
	
	/** This is used .parse to parse any objects in the JSON structure. Objects can be of the following types:
	 * <ul>
	 * 	<li>Scene</li>
		<li>PerspectiveCamera</li>
		<li>OrthographicCamera</li>
		<li>AmbientLight</li>
		<li>DirectionalLight</li>
		<li>PointLight</li>
		<li>SpotLight</li>
		<li>HemisphereLight</li>
		<li>Mesh</li>
		<li>LOD</li>
		<li>Line</li>
		<li>LineSegments</li>
		<li>Points</li>
		<li>Sprite</li>
		<li>Group</li>
		<li>Object3D</li>
		</ul>
		
		@param json the JSON source to parse
	*/
	public native Object parseObject( Object json );
	
	/** Sets the crossOrigin
	 * 
	 * @param value The crossOrigin string to implement CORS for loading the url from a different domain that allows CORS.
	 */
	public native void setCrossOrigin( String value );
	
	/** Sets the texturePath
	 * 
	 * @param value The base path or URL from which textures will be loaded.
	 */
	public native void setTexturePath( String value );
	
}
