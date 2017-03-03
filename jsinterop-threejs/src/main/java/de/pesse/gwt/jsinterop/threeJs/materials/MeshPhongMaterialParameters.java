package de.pesse.gwt.jsinterop.threeJs.materials;


import de.pesse.gwt.jsinterop.threeJs.textures.Texture;
import java.lang.Double;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.math.Plane;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;

/** Helptype to give access to the possible parameters of the MeshPhongMaterial object
 *
 * @author JsInteropParameterObjectBuilderCreator
 *
 */
@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class MeshPhongMaterialParameters {

	public int polygonOffsetUnits;
	public String precision;
	public double overdraw;
	public double reflectivity;
	public double alphaTest;
	public int vertexColors;
	public double emissiveIntensity;
	public double shininess;
	public double displacementScale;
	public boolean premultipliedAlpha;
	public Long blendSrcAlpha;
	public int blendEquation;
	public Texture specularMap;
	public Double blendEquationAlpha;
	public int blending;
	public Vector2 normalScale;
	public Double blendDstAlpha;
	public int combine;
	public boolean depthWrite;
	public boolean visible;
	public double polygonOffsetFactor;
	public int specular;
	public double displacementBias;
	public boolean polygonOffset;
	public boolean morphTargets;
	public Object envMap;
	public boolean morphNormals;
	public double bumpScale;
	public String name;
	public double wireframeLinewidth;
	public int blendSrc;
	public Texture bumpMap;
	public String wireframeLinejoin;
	public int depthFunc;
	public boolean fog;
	public int shading;
	public int emissive;
	public double aoMapIntensity;
	public boolean needsUpdate;
	public Texture aoMap;
	public int color;
	public String wireframeLinecap;
	public Texture displacementMap;
	public double lightMapIntensity;
	public boolean clipShadows;
	public Plane[] clippingPlanes;
	public boolean transparent;
	public boolean colorWrite;
	public boolean clipIntersection;
	public boolean wireframe;
	public Texture map;
	public int blendDst;
	public boolean lights;
	public boolean skinning;
	public int side;
	public Texture alphaMap;
	public boolean depthTest;
	public Texture normalMap;
	public Texture lightMap;
	public Texture emissiveMap;
	public double refractionRatio;
	public double opacity;

	public static class Builder {

		private MeshPhongMaterialParameters p;

		public Builder() {
			p = new MeshPhongMaterialParameters();
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

		public Builder reflectivity( double reflectivity ) {
			p.reflectivity = reflectivity;
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

		public Builder emissiveIntensity( double emissiveIntensity ) {
			p.emissiveIntensity = emissiveIntensity;
			return this;
		}

		public Builder shininess( double shininess ) {
			p.shininess = shininess;
			return this;
		}

		public Builder displacementScale( double displacementScale ) {
			p.displacementScale = displacementScale;
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

		public Builder specularMap( Texture specularMap ) {
			p.specularMap = specularMap;
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

		public Builder normalScale( Vector2 normalScale ) {
			p.normalScale = normalScale;
			return this;
		}

		public Builder blendDstAlpha( Double blendDstAlpha ) {
			p.blendDstAlpha = blendDstAlpha;
			return this;
		}

		public Builder combine( int combine ) {
			p.combine = combine;
			return this;
		}

		public Builder depthWrite( boolean depthWrite ) {
			p.depthWrite = depthWrite;
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

		public Builder specular( int specular ) {
			p.specular = specular;
			return this;
		}

		public Builder displacementBias( double displacementBias ) {
			p.displacementBias = displacementBias;
			return this;
		}

		public Builder polygonOffset( boolean polygonOffset ) {
			p.polygonOffset = polygonOffset;
			return this;
		}

		public Builder morphTargets( boolean morphTargets ) {
			p.morphTargets = morphTargets;
			return this;
		}

		public Builder envMap( Object envMap ) {
			p.envMap = envMap;
			return this;
		}

		public Builder morphNormals( boolean morphNormals ) {
			p.morphNormals = morphNormals;
			return this;
		}

		public Builder bumpScale( double bumpScale ) {
			p.bumpScale = bumpScale;
			return this;
		}

		public Builder name( String name ) {
			p.name = name;
			return this;
		}

		public Builder wireframeLinewidth( double wireframeLinewidth ) {
			p.wireframeLinewidth = wireframeLinewidth;
			return this;
		}

		public Builder blendSrc( int blendSrc ) {
			p.blendSrc = blendSrc;
			return this;
		}

		public Builder bumpMap( Texture bumpMap ) {
			p.bumpMap = bumpMap;
			return this;
		}

		public Builder wireframeLinejoin( String wireframeLinejoin ) {
			p.wireframeLinejoin = wireframeLinejoin;
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

		public Builder shading( int shading ) {
			p.shading = shading;
			return this;
		}

		public Builder emissive( int emissive ) {
			p.emissive = emissive;
			return this;
		}

		public Builder aoMapIntensity( double aoMapIntensity ) {
			p.aoMapIntensity = aoMapIntensity;
			return this;
		}

		public Builder needsUpdate( boolean needsUpdate ) {
			p.needsUpdate = needsUpdate;
			return this;
		}

		public Builder aoMap( Texture aoMap ) {
			p.aoMap = aoMap;
			return this;
		}

		public Builder color( int color ) {
			p.color = color;
			return this;
		}

		public Builder wireframeLinecap( String wireframeLinecap ) {
			p.wireframeLinecap = wireframeLinecap;
			return this;
		}

		public Builder displacementMap( Texture displacementMap ) {
			p.displacementMap = displacementMap;
			return this;
		}

		public Builder lightMapIntensity( double lightMapIntensity ) {
			p.lightMapIntensity = lightMapIntensity;
			return this;
		}

		public Builder clipShadows( boolean clipShadows ) {
			p.clipShadows = clipShadows;
			return this;
		}

		public Builder clippingPlanes( Plane[] clippingPlanes ) {
			p.clippingPlanes = clippingPlanes;
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

		public Builder wireframe( boolean wireframe ) {
			p.wireframe = wireframe;
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

		public Builder lights( boolean lights ) {
			p.lights = lights;
			return this;
		}

		public Builder skinning( boolean skinning ) {
			p.skinning = skinning;
			return this;
		}

		public Builder side( int side ) {
			p.side = side;
			return this;
		}

		public Builder alphaMap( Texture alphaMap ) {
			p.alphaMap = alphaMap;
			return this;
		}

		public Builder depthTest( boolean depthTest ) {
			p.depthTest = depthTest;
			return this;
		}

		public Builder normalMap( Texture normalMap ) {
			p.normalMap = normalMap;
			return this;
		}

		public Builder lightMap( Texture lightMap ) {
			p.lightMap = lightMap;
			return this;
		}

		public Builder emissiveMap( Texture emissiveMap ) {
			p.emissiveMap = emissiveMap;
			return this;
		}

		public Builder refractionRatio( double refractionRatio ) {
			p.refractionRatio = refractionRatio;
			return this;
		}

		public Builder opacity( double opacity ) {
			p.opacity = opacity;
			return this;
		}

		public MeshPhongMaterialParameters build() {
			return p;
		}

	}

}
