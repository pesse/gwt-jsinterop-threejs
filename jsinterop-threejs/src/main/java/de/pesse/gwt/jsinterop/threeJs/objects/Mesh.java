package de.pesse.gwt.jsinterop.threeJs.objects;

import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.ThreeJsStatics;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.core.Object3D;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;

@JsType(isNative=true, namespace=ThreeJsStatics.PACKAGE_NAME)
public class Mesh extends Object3D
{	
	/** Creates a new Mesh with a new BufferGeometry and a new MeshBasicMaterial with a random color
	 */
	public Mesh() {}
	
	/** Creates a new Mesh with the given Geometry and a new MeshBasicMaterial with a random color
	 * 
	 * @param geometry an instance of Geometry or BufferGeometry
	 * @param material a Material
	 */
	public Mesh( Geometry geometry) {}
	
	/** Creates a new Mesh with the given Geometry and Material
	 * 
	 * @param geometry an instance of Geometry or BufferGeometry
	 * @param material a Material
	 */
	public Mesh( Geometry geometry, Material material ) {}
	
	/** Set the value of drawMode
	 * 
	 */
	public native void setDrawMode( int drawMode );
	
	/** Returns a clone of this Mesh object and its descendants
	 * 
	 */
	public native Mesh clone();
	
	/** Get intersections between a casted ray and this mesh. Raycaster.instersectObject will call this method
	 * 
	 * @param raycaster
	 * @param intersects
	 */
	public native void raycast( Object raycaster, Object intersects );
	
	/** Updates the morphtargets to have no influence on the object. Resets the morphTargetInfluences and morphTargetDictionary properties.
	 * 
	 */
	public native void updateMorphTargets();
	
}
