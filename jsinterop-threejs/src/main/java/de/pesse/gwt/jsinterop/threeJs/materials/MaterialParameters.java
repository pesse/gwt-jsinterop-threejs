package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class MaterialParameters
{
	@JsProperty public int color;
	@JsProperty public Texture map;
	public boolean transparent;
	public float opacity;
	public int blending;
	public boolean wireframe;
	
	public static class Builder
	{
		protected MaterialParameters p;
		
		public Builder()
		{
			p = new MaterialParameters();
		}
		
		public Builder color( int color )
		{
			p.color = color;
			return this;
		}
		
		public Builder map( Texture map )
		{
			p.map = map;
			return this;
		}
		
		public Builder transparent( boolean transparent )
		{
			p.transparent = transparent;
			return this;
		}
		
		public Builder opacity( float opacity )
		{
			p.opacity = opacity;
			return this;
		}
		
		public Builder blending( int blending )
		{
			p.blending = blending;
			return this;
		}
		
		public Builder wireframe( boolean wireframe )
		{
			p.wireframe = wireframe;
			return this;
		}
		
		public MaterialParameters build()
		{
			return p;
		}
	}
}
