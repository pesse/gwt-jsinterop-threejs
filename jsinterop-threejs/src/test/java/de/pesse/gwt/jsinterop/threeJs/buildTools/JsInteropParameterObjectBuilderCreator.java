package de.pesse.gwt.jsinterop.threeJs.buildTools;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshBasicMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshBasicMaterialParameters;

public class JsInteropParameterObjectBuilderCreator
{
	private Class<?> jsInteropClass;
	
	private String jsTypeDeclaration = "@JsType( namespace=JsPackage.GLOBAL, isNative=true, name=\"Object\")";
	private String packageName;
	private String parameterClassName;
	private String parameterBuilderClassName;
	
	private Set<String> imports;
	private Map<String, String> fields;
	
	public JsInteropParameterObjectBuilderCreator( Class<?> jsInteropClass )
	{
		this.jsInteropClass = jsInteropClass;
		
		imports = new HashSet<String>();
		
		imports.add("jsinterop.annotations.JsPackage");
		imports.add("jsinterop.annotations.JsType");
		
		initClassNames();
		analyzeFields();
		
		
	}
	
	private void initClassNames()
	{
		String origClassName = jsInteropClass.getSimpleName();
		
		packageName = jsInteropClass.getPackage().getName();
		parameterClassName = origClassName + "Parameters";
		parameterBuilderClassName = "Builder";
	}
	
	private void analyzeFields()
	{
		fields = new HashMap<String, String>();
		
		
		for ( Field field : jsInteropClass.getFields() )
		{
			Class<?> fieldType = field.getType();
			
			String packageName = (fieldType.getPackage() != null) ? fieldType.getName() : null;
			
			if ( fieldType.getName() != null && fieldType.getName().startsWith("[L")) // Arrays
			{
				packageName = fieldType.getName().substring(2, fieldType.getName().length()-1);
			}
			
			if ( packageName != null 
					&& !"java.lang".equals(packageName))
			{
				imports.add(packageName);
			}
			
			fields.put(field.getName(), field.getType().getSimpleName());
		}
	}
	
	private void writeImports( StringBuffer sb )
	{
		sb.append("\n");
		imports.stream().forEach(o -> sb.append("import " + o + ";\n"));
		sb.append("\n");
	}
	
	private void writeParameterClassFields( StringBuffer sb )
	{
		for ( Entry<String, String> field : fields.entrySet() )
		{
			sb.append("\tpublic " + field.getValue() + " " + field.getKey() + ";\n");
			
		}
	}
	
	private void writeParameterClass( StringBuffer sb )
	{
		sb.append(jsTypeDeclaration + "\n");
		sb.append("public class " + parameterClassName + " {\n\n");
		
		writeParameterClassFields(sb);
		
		sb.append("\n");
		writeBuilderClass(sb);
		
		sb.append("\n}\n");
	}
	
	private void writeBuilderFunction( StringBuffer sb, Entry<String, String> fieldEntry )
	{
		sb.append("\t\tpublic " + parameterBuilderClassName + " " + fieldEntry.getKey() + "( " + fieldEntry.getValue() + " " + fieldEntry.getKey() + " ) {\n");
		sb.append("\t\t\tp." + fieldEntry.getKey() + " = " + fieldEntry.getKey() + ";\n");
		sb.append("\t\t\treturn this;\n");
		sb.append("\t\t}\n\n");
		
	}
	
	private void writeBuilderBuildFunction( StringBuffer sb )
	{
		sb.append("\t\tpublic " + parameterClassName + " build() {\n");
		sb.append("\t\t\treturn p;\n");
		sb.append("\t\t}\n");
	}
	
	private void writeBuilderClass( StringBuffer sb )
	{
		sb.append("\tpublic static class " + parameterBuilderClassName + " {\n\n");
		sb.append("\t\tprivate " + parameterClassName + " p;\n");
		sb.append("\n");
		
		for ( Entry<String, String> entry : fields.entrySet() )
		{
			writeBuilderFunction(sb, entry);
		}
		
		writeBuilderBuildFunction(sb);
		
		sb.append("\n\t}\n");
	}
	
	private void writeJavaDoc(StringBuffer sb )
	{
		sb.append("/** Helptype to give access to the possible parameters of the " + jsInteropClass.getSimpleName() + " object\n");
		sb.append(" *\n");
		sb.append(" * @author JsInteropParameterObjectBuilderCreator\n");
		sb.append(" *\n");
		sb.append(" */\n");
	}
	
	public String createParameterClass()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("package " + packageName + ";\n\n");
		
		writeImports(sb);
		
		writeJavaDoc(sb);
		writeParameterClass(sb);
		
		return sb.toString();
	}
	
	private String getClassPath()
	{
		return jsInteropClass.getPackage().getName().replace(".", "/");
	}
	
	private String getDefaultPath() throws IOException
	{
		return new java.io.File(".").getCanonicalPath() + "/src/main/java/" + getClassPath();
	}
	
	private String getFileName()
	{
		return parameterClassName + ".java";
	}
	
	public void writeParameterClass() throws IOException
	{
		writeParameterClass(getDefaultPath());
	}
	
	public void writeParameterClass( String outputFilePath ) throws IOException
	{
		String content = createParameterClass();
		String filePath = outputFilePath + "/" + getFileName();
		
		Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		
		System.out.println("File " + filePath + " successfully written (" + content.getBytes().length + " bytes)");
	}
}
