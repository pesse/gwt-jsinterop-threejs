package de.pesse.gwt.jsinterop.threeJs.loaders;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class TextureLoader
{
	public Object crossOrigin; // TODO: Type
	public LoadingManager manager;
	public String path;
	public Object withCredentials;
	
	public TextureLoader() {}
	
	public TextureLoader( LoadingManager manager ) {}
	
	public native Texture load( String url );
	
	public native Texture load( String url, OnLoadCallback<Texture> onLoad, OnProgressCallback onProgress, OnErrorCallback onError );
	
	public native void setCrossOrigin( Object value ); // TODO: Type
	
	public native void setPath( String value );
}

