package de.pesse.gwt.jsinterop.threeJs.cameras;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;

@JsType( namespace=ThreeJsStatics.PACKAGE_NAME, isNative=true)
public class PerspectiveCamera extends Camera
{
	public double aspect;
	public int far;
	public int filmGauge;
	public int filmOffset;
	public int focus;
	public int fov;
	public boolean isPerspectiveCamera;
	public double near;
	public int view;
	public int zoom;
	
	public PerspectiveCamera( int fov, double aspect, double near, int far ) {}
	
	public native void copy( PerspectiveCamera camera );
	
	/**
	 * Sets the FOV by focal length in respect to the current .filmGauge.
	 *
	 * The default film gauge is 35, so that the focal length can be specified for
	 * a 35mm (full frame) camera.
	 *
	 * Values for focal length and film gauge must have the same unit.
	 */
	public native void setFocalLength( float focalLength );
	
	/**
	 * Calculates the focal length from the current .fov and .filmGauge.
	 */
	public native float getFocalLength();
	
	public native float getEffectiveFOV();
	
	public native int getFilmWidth();
	
	public native int getFilmHeight();
	
	/**
	 * Sets an offset in a larger frustum. This is useful for multi-window or
	 * multi-monitor/multi-machine setups.
	 *
	 * For example, if you have 3x2 monitors and each monitor is 1920x1080 and
	 * the monitors are in grid like this
	 *
	 *   +---+---+---+
	 *   | A | B | C |
	 *   +---+---+---+
	 *   | D | E | F |
	 *   +---+---+---+
	 *
	 * then for each monitor you would call it like this
	 *
	 *   var w = 1920;
	 *   var h = 1080;
	 *   var fullWidth = w * 3;
	 *   var fullHeight = h * 2;
	 *
	 *   --A--
	 *   camera.setOffset( fullWidth, fullHeight, w * 0, h * 0, w, h );
	 *   --B--
	 *   camera.setOffset( fullWidth, fullHeight, w * 1, h * 0, w, h );
	 *   --C--
	 *   camera.setOffset( fullWidth, fullHeight, w * 2, h * 0, w, h );
	 *   --D--
	 *   camera.setOffset( fullWidth, fullHeight, w * 0, h * 1, w, h );
	 *   --E--
	 *   camera.setOffset( fullWidth, fullHeight, w * 1, h * 1, w, h );
	 *   --F--
	 *   camera.setOffset( fullWidth, fullHeight, w * 2, h * 1, w, h );
	 *
	 *   Note there is no reason monitors have to be the same size or in a grid.
	 */
	public native void setViewOffset( int fullWidth, int fullHeight, int x, int y, int width, int height );
	
	public native void clearViewOffset();
	
	public native void updateProjectionMatrix();
	
	public native Object toJSON( Object meta );
	
}
