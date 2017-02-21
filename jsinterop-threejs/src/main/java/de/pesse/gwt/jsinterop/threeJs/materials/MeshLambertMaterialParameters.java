package de.pesse.gwt.jsinterop.threeJs.materials;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

/** Helptype to give access to the possible parameters of the material object
 * 
 * @author derpesse
 *
 */
@JsType( namespace=JsPackage.GLOBAL, isNative=true, name="Object")
public class MeshLambertMaterialParameters extends MaterialParameters
{
	public int test;
	
	public static class Builder extends MaterialParameters.Builder
	{
		public Builder()
		{
			p = new MeshLambertMaterialParameters();
		}
		
		public Builder test( int test )
		{
			((MeshLambertMaterialParameters)p).test = test;
			return this;
		}		
		
		@Override
		public Builder color(int color)
		{
			return (Builder) super.color(color);
		}

		@Override
		public Builder wireframe(boolean wireframe)
		{
			return (Builder) super.wireframe(wireframe);
		}

		@Override
		public Builder map(Texture map)
		{
			return (Builder) super.map(map);
		}

		@Override
		public Builder transparent(boolean transparent)
		{
			return (Builder) super.transparent(transparent);
		}

		@Override
		public Builder opacity(float opacity)
		{
			return (Builder) super.opacity(opacity);
		}

		@Override
		public Builder blending(int blending)
		{
			return (Builder) super.blending(blending);
		}

		@Override
		public MeshLambertMaterialParameters build()
		{
			return (MeshLambertMaterialParameters) p;
		}
	}
}