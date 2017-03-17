package de.pesse.gwt.jsinterop.threeJs.geometries;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.core.CurvePath;

@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class ExtrudeGeometryOptions
{
	/**  number of points on the curves */
	public int curveSegments;
	
	/** number of points used for subdividing segements of extrude spline */
	public int steps;
	
	/** Depth to extrude the shape */
	public int amount;
	
	/** turn on bevel */
	public boolean bevelEnabled;
	
	/** how deep into the original shape bevel goes */
	public double bevelThickness;
	
	/** how far from shape outline is bevel */
	public double bevelSize;
	
	/** number of bevel layers */
	public int bevelSegments;
	
	/** 3d spline path to extrude shape along. (creates Frames if frames aren't defined) */
	public CurvePath extrudePath;
	
	/** THREE.TubeGeometry.FrenetFrames. containing arrays of tangents, normals, binormals */
	public Object frames; // TODO: Type?
	
	/** material index for front and back faces */
	public int material;
	
	/** material index for extrusion and beveled faces */
	public int extrudeMaterial;
	
	/** object that provides UV generator functions */
	public Object UVGenerator;
	
	public static class Builder {

		private ExtrudeGeometryOptions p;

		public Builder() {
			p = new ExtrudeGeometryOptions();
		}

		/** how far from shape outline is bevel
		 * 
		 * @param bevelSize
		 * @return
		 */
		public Builder bevelSize( double bevelSize ) {
			p.bevelSize = bevelSize;
			return this;
		}

		/**  number of bevel layers
		 * 
		 * @param bevelSegments
		 * @return
		 */
		public Builder bevelSegments( int bevelSegments ) {
			p.bevelSegments = bevelSegments;
			return this;
		}

		/** Depth to extrude the shape
		 * 
		 * @param amount
		 * @return
		 */
		public Builder amount( int amount ) {
			p.amount = amount;
			return this;
		}

		/** THREE.TubeGeometry.FrenetFrames. containing arrays of tangents, normals, binormals
		 * 
		 * @param frames
		 * @return
		 */
		public Builder frames( Object frames ) {
			p.frames = frames;
			return this;
		}

		/** material index for front and back faces
		 * 
		 * @param material
		 * @return
		 */
		public Builder material( int material ) {
			p.material = material;
			return this;
		}

		/** number of points on the curves
		 * 
		 * @param curveSegments
		 * @return
		 */
		public Builder curveSegments( int curveSegments ) {
			p.curveSegments = curveSegments;
			return this;
		}

		/** THREE.CurvePath. 3d spline path to extrude shape along. (creates Frames if frames aren't defined)
		 * 
		 * @param extrudePath
		 * @return
		 */
		public Builder extrudePath( CurvePath extrudePath ) {
			p.extrudePath = extrudePath;
			return this;
		}

		/**  material index for extrusion and beveled faces
		 * 
		 * @param extrudeMaterial
		 * @return
		 */
		public Builder extrudeMaterial( int extrudeMaterial ) {
			p.extrudeMaterial = extrudeMaterial;
			return this;
		}

		/** object that provides UV generator functions
		 * 
		 * @param UVGenerator
		 * @return
		 */
		public Builder UVGenerator( Object UVGenerator ) {
			p.UVGenerator = UVGenerator;
			return this;
		}

		/**  turn on bevel
		 * 
		 * @param bevelEnabled
		 * @return
		 */
		public Builder bevelEnabled( boolean bevelEnabled ) {
			p.bevelEnabled = bevelEnabled;
			return this;
		}

		/** number of points used for subdividing segements of extrude spline
		 * 
		 * @param steps
		 * @return
		 */
		public Builder steps( int steps ) {
			p.steps = steps;
			return this;
		}

		/** how deep into the original shape bevel goes
		 * 
		 * @param bevelThickness
		 * @return
		 */
		public Builder bevelThickness( double bevelThickness ) {
			p.bevelThickness = bevelThickness;
			return this;
		}

		public ExtrudeGeometryOptions build() {
			return p;
		}

	}
}