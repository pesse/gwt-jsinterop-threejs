package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.core.Shape;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class ExtrudeGeometry extends Geometry
{
	public ExtrudeGeometry() {}
	
	/** This object extrudes a 2D shape to an 3D geometry
	 * 
	 * @param shape a shape
	 */
	public ExtrudeGeometry( Shape shape ) {}
	
	/** This object extrudes a 2D shape to an 3D geometry
	 *
	 * @param shape a shape
	 * @param options Options
	 */
	public ExtrudeGeometry( Shape shape, ExtrudeGeometryOptions options ) {}
	
	/** This object extrudes a 2D shape to an 3D geometry
	 * 
	 * @param shapes Array of shapes
	 */
	public ExtrudeGeometry( Shape[] shapes ) {}
	
	/** This object extrudes a 2D shape to an 3D geometry
	 *
	 * @param shapes Array of shapes
	 * @param options Options
	 */
	public ExtrudeGeometry( Shape[] shapes, ExtrudeGeometryOptions options ) {}

	/** Adds the shapes to the list to extrude.
	 * 
	 * @param shapes Array of shapes
	 */
	public native void addShapeList( Shape[] shapes);
	
	/** Adds the shapes to the list to extrude.
	 * 
	 * @param shapes Array of shapes
	 * @param options options
	 */
	public native void addShapeList( Shape[] shapes, ExtrudeGeometryOptions options );
	
	/** Adds the shape to the list to extrude
	 * 
	 * @param shape
	 */
	public native void addShape( Shape shape );
	
	/** Adds the shape to the list to extrude
	 * 
	 * @param shape
	 * @param options
	 */
	public native void addShape( Shape shape, ExtrudeGeometryOptions options );
}
