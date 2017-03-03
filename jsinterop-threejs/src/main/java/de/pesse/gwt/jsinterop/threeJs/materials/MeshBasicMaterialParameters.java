package de.pesse.gwt.jsinterop.threeJs.materials;


import de.pesse.gwt.jsinterop.threeJs.textures.Texture;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.math.Plane;

/** Helptype to give access to the possible parameters of the MeshBasicMaterial object
 *
 * @author JsInteropParameterObjectBuilderCreator
 *
 */
@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class MeshBasicMaterialParameters {

	public int shading;
	public boolean needsUpdate;
	public int color;
	public boolean clipShadows;
	public int polygonOffsetUnits;
	public String precision;
	public double overdraw;
	public Plane[] clippingPlanes;
	public double alphaTest;
	public int vertexColors;
	public boolean transparent;
	public boolean colorWrite;
	public boolean clipIntersection;
	public boolean premultipliedAlpha;
	public Long blendSrcAlpha;
	public int blendEquation;
	public Double blendEquationAlpha;
	public int blending;
	public Texture map;
	public int blendDst;
	public Double blendDstAlpha;
	public boolean lights;
	public boolean depthWrite;
	public int side;
	public boolean visible;
	public double polygonOffsetFactor;
	public boolean depthTest;
	public boolean polygonOffset;
	public String name;
	public int blendSrc;
	public double opacity;
	public int depthFunc;
	public boolean fog;

	public static class Builder {

		private MeshBasicMaterialParameters p;

		public Builder() {
			p = new MeshBasicMaterialParameters();
		}

		public Builder shading( int shading ) {
			p.shading = shading;
			return this;
		}

		public Builder needsUpdate( boolean needsUpdate ) {
			p.needsUpdate = needsUpdate;
			return this;
		}

		public Builder color( int color ) {
			p.color = color;
			return this;
		}

		public Builder clipShadows( boolean clipShadows ) {
			p.clipShadows = clipShadows;
			return this;
		}

		public Builder polygonOffsetUnits( int polygonOffsetUnits ) {
			p.polygonOffsetUnits = polygonOffsetUnits;
			return this;
		}

		public Builder precision( String precision ) {
			p.precision = precision;
			return this;
		}

		public Builder overdraw( double overdraw ) {
			p.overdraw = overdraw;
			return this;
		}

		public Builder clippingPlanes( Plane[] clippingPlanes ) {
			p.clippingPlanes = clippingPlanes;
			return this;
		}

		public Builder alphaTest( double alphaTest ) {
			p.alphaTest = alphaTest;
			return this;
		}

		public Builder vertexColors( int vertexColors ) {
			p.vertexColors = vertexColors;
			return this;
		}

		public Builder transparent( boolean transparent ) {
			p.transparent = transparent;
			return this;
		}

		public Builder colorWrite( boolean colorWrite ) {
			p.colorWrite = colorWrite;
			return this;
		}

		public Builder clipIntersection( boolean clipIntersection ) {
			p.clipIntersection = clipIntersection;
			return this;
		}

		public Builder premultipliedAlpha( boolean premultipliedAlpha ) {
			p.premultipliedAlpha = premultipliedAlpha;
			return this;
		}

		public Builder blendSrcAlpha( Long blendSrcAlpha ) {
			p.blendSrcAlpha = blendSrcAlpha;
			return this;
		}

		public Builder blendEquation( int blendEquation ) {
			p.blendEquation = blendEquation;
			return this;
		}

		public Builder blendEquationAlpha( Double blendEquationAlpha ) {
			p.blendEquationAlpha = blendEquationAlpha;
			return this;
		}

		public Builder blending( int blending ) {
			p.blending = blending;
			return this;
		}

		public Builder map( Texture map ) {
			p.map = map;
			return this;
		}

		public Builder blendDst( int blendDst ) {
			p.blendDst = blendDst;
			return this;
		}

		public Builder blendDstAlpha( Double blendDstAlpha ) {
			p.blendDstAlpha = blendDstAlpha;
			return this;
		}

		public Builder lights( boolean lights ) {
			p.lights = lights;
			return this;
		}

		public Builder depthWrite( boolean depthWrite ) {
			p.depthWrite = depthWrite;
			return this;
		}

		public Builder side( int side ) {
			p.side = side;
			return this;
		}

		public Builder visible( boolean visible ) {
			p.visible = visible;
			return this;
		}

		public Builder polygonOffsetFactor( double polygonOffsetFactor ) {
			p.polygonOffsetFactor = polygonOffsetFactor;
			return this;
		}

		public Builder depthTest( boolean depthTest ) {
			p.depthTest = depthTest;
			return this;
		}

		public Builder polygonOffset( boolean polygonOffset ) {
			p.polygonOffset = polygonOffset;
			return this;
		}

		public Builder name( String name ) {
			p.name = name;
			return this;
		}

		public Builder blendSrc( int blendSrc ) {
			p.blendSrc = blendSrc;
			return this;
		}

		public Builder opacity( double opacity ) {
			p.opacity = opacity;
			return this;
		}

		public Builder depthFunc( int depthFunc ) {
			p.depthFunc = depthFunc;
			return this;
		}

		public Builder fog( boolean fog ) {
			p.fog = fog;
			return this;
		}

		public MeshBasicMaterialParameters build() {
			return p;
		}

	}

}
