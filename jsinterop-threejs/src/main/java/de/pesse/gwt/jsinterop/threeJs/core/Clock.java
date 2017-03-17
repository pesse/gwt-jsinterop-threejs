package de.pesse.gwt.jsinterop.threeJs.core;

import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/** Wrapper for the Clock class of ThreeJS
 *
 * Object for keeping track of time. This uses performance.now() if it is available, otherwise it reverts to the less accurate Date.now().
 *
 * @author derpesse
 *
 */

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Clock
{
	/** If set, starts the clock automatically when the first update is called. Default is true. */
	public boolean autoStart;

	/** Holds the time at which the clock's start method was last called.
	 *
	 * @return
	 */
	@JsProperty public native double getStartTime();

	/** Holds the time at which the clock's start, getElapsedTime or getDelta methods were last called.
	 *
	 * @return
	 */
	@JsProperty public native double getOldTime();

	/** Whether the clock is running or not. */
	@JsProperty(name="running") public native boolean isRunning();

	/**
	 * Will automatically start the clock
	 */
	public Clock() {}

	/**
	 *
	 * @param autoStart (optional) whether to automatically start the clock. Default is tru
	 */
	public Clock( boolean autoStart ) {}

	/** Starts clock. Also sets the startTime and oldTime to the current time, sets elapsedTime to 0 and running to true.
	 *
	 */
	public native void start();

	/** Stops clock and sets oldTime to the current time.
	 *
	 */
	public native void stop();

	/** Get the seconds passed since the clock started and sets oldTime to the current time.
	 * If autoStart is true and the clock is not running, also starts the clock.
	 * @return
	 */
	public native double getElapsedTime();

	/** Get the seconds passed since the time oldTime was set and sets oldTime to the current time.
	 * If autoStart is true and the clock is not running, also starts the clock.
	 * @return
	 */
	public native double getDelta();

}
