package de.pesse.gwt.jsinterop.threeJs.loaders;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Font;

/** Wrapper for the FontLoader class of ThreeJS
 * 
 * Class for loading a font in JSON format. Returns a Font, which is an array of Shapes representing the font. This uses the FileLoader internally for loading files. 
 * You can convert fonts online using facetype.js
 * 
 * @author pesse
 *
 */
@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class FontLoader
{
	/** The loading manager the loader is using. Default is DefaultLoadingManager */
	public LoadingManager manager;
	
	/** Creates a new FontLoader with THREE.DefaultLoadingManager
	 * 
	 */
	public FontLoader() {}
	
	/** Creates a new FontLoader
	 * 
	 * @param manager the loadingManager for the loader to use
	 */
	public FontLoader( LoadingManager manager ) {}
	
	/** Loads the requested font
	 * 
	 * @param url
	 * @return
	 */
	public native void load( String url );
	
	/** Loads the requested font
	 * 
	 * @param url
	 * @param onLoad
	 * @return
	 */
	public native void load( String url, OnLoadCallback<Font> onLoad );
	
	/** Loads the requested font
	 * 
	 * @param url
	 * @param onLoad
	 * @param onProgress
	 * @return
	 */
	public native void load( String url, OnLoadCallback<Font> onLoad, OnProgressCallback onProgress );
	
	/** Loads the requested font
	 * 
	 * @param url
	 * @param onLoad
	 * @param onProgress
	 * @param onError
	 * @return
	 */
	public native void load( String url, OnLoadCallback<Font> onLoad, OnProgressCallback onProgress, OnErrorCallback onError );
	
	/** Parse a JSON structure and return a Font
	 * 
	 * @param json
	 * @return
	 */
	public native Font parse( Object json );
}
