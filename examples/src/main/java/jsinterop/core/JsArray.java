package jsinterop.core;

import javaemul.internal.ArrayHelper;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/** This is just a wrapper for the native JavaScript Array
 * 
 * @author snitsche
 *
 * @param <T>
 */
@JsType(isNative = true, namespace=JsPackage.GLOBAL, name="Array")
public class JsArray<T>
{
	@JsProperty public native int getLength();
	
	public native void push(T item);
	
}
