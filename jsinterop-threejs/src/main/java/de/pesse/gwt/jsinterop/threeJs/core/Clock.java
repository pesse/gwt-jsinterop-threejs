package de.pesse.gwt.jsinterop.threeJs.core;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

/**
 * Object for keeping track of time. This uses performance.now() if it is available, otherwise it reverts to the less accurate Date.now().
 * 
 * @author derpesse
 *
 */

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Clock
{
	
	/** 
	 * Will automatically start the clock
	 */
	public Clock() {}
	
	/** 
	 * 
	 * @param autoStart (optional) whether to automatically start the clock. Default is tru
	 */
	public Clock( boolean autoStart ) {}
	
	public native double getDelta();
	
	
}
