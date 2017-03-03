package de.pesse.gwt.jsinterop.threeJs.loaders;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

/** Wrapper for JSONLoader class of ThreeJS
 * 
 * A loader for loading objects in JSON format. This uses the FileLoader internally for loading files.
 * 
 * @author pesse
 *
 */
@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class JSONLoader
{
	/** The loadingManager the loader is using. Default is DefaultLoadingManager. */
	public LoadingManager manager;
	
	/** Whether the XMLHttpRequest uses credentials. Default is false. */
	public boolean withCredentials;
	
	/** Creates a new JSONLoader
	 * 
	 */
	public JSONLoader() {}
	
	/** Creates a new JSONLoader
	 * 
	 * @param manager The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
	 */
	public JSONLoader( LoadingManager manager ) {}
	
	/** Begin loading from url and pass the JSON to onLoad.
	 * 
	 * @param url
	 * @param onLoad
	 * @return
	 */
	public native Object load( String url, OnJSONLoadCallback onLoad);
	
	/** Begin loading from url and pass the JSON to onLoad.
	 * 
	 * @param url
	 * @param onLoad
	 * @param onProgress
	 * @return
	 */
	public native Object load( String url, OnJSONLoadCallback onLoad, OnProgressCallback onProgress );
	
	/** Begin loading from url and pass the JSON to onLoad.
	 * 
	 * @param url
	 * @param onLoad
	 * @param onProgress
	 * @param onError
	 * @return
	 */
	public native Object load( String url, OnJSONLoadCallback onLoad, OnProgressCallback onProgress, OnErrorCallback onError );
	
	/** Set the base path or URL from which to load files. This can be useful if you are loading many files from the same directory.
	 * 
	 * @param texturePath
	 */
	public native void setTexturePath ( String texturePath );
	
	/** Parse a JSON structure and return an object containing the parsed geometry and materials.
	 * 
	 * @param json
	 * @return
	 */
	public native Object parse( Object json );
	
	/** Parse a JSON structure and return an object containing the parsed geometry and materials.
	 * 
	 * @param json
	 * @param texturePath
	 * @return
	 */
	public native Object parse( Object json, String texturePath );
	
	
	@JsFunction
	@FunctionalInterface
	public static interface OnJSONLoadCallback
	{
		void onLoad( Geometry geometry, Material[] materials );
	}

}
