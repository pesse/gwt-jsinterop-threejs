package de.pesse.gwt.jsinterop.threeJs.buildTools;

import java.io.IOException;

import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshBasicMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshLambertMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshPhongMaterial;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;

public class BuildWebGLRendererParameters
{

	public static void main(String[] args)
	{
		Class<?>[] classesToBuild = new Class<?>[]{ 
				WebGLRenderer.class };

		for ( Class<?> classToBuild : classesToBuild )
		{
			JsInteropParameterObjectBuilderCreator creator = new JsInteropParameterObjectBuilderCreator(classToBuild);
			
			try
			{
				creator.writeParameterClass();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
