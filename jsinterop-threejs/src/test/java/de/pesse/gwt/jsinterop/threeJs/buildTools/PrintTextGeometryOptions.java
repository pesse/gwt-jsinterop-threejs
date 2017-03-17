package de.pesse.gwt.jsinterop.threeJs.buildTools;

import java.io.IOException;

import de.pesse.gwt.jsinterop.threeJs.geometries.ExtrudeGeometryOptions;
import de.pesse.gwt.jsinterop.threeJs.geometries.TextGeometryOptions;

public class PrintTextGeometryOptions
{

	public static void main(String[] args)
	{
		JsInteropParameterObjectBuilderCreator creator = new JsInteropParameterObjectBuilderCreator(TextGeometryOptions.class);
		
		try
		{
			System.out.print(creator.createParameterClass());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
