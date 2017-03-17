package de.pesse.gwt.jsinterop.threejs.examples.client;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;
import jsinterop.core.Window;
import jsinterop.core.Window.AnimationFrameCallback;
import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Clock;
import de.pesse.gwt.jsinterop.threeJs.core.Font;
import de.pesse.gwt.jsinterop.threeJs.geometries.TextGeometry;
import de.pesse.gwt.jsinterop.threeJs.geometries.TextGeometryOptions;
import de.pesse.gwt.jsinterop.threeJs.helpers.AxisHelper;
import de.pesse.gwt.jsinterop.threeJs.lights.PointLight;
import de.pesse.gwt.jsinterop.threeJs.loaders.FontLoader;
import de.pesse.gwt.jsinterop.threeJs.loaders.OnLoadCallback;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshPhongMaterial;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRendererParameters;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;
import de.pesse.gwt.jsinterop.volumetricFire.VolumetricFire;

@JsType(namespace="ThreeJsExamples")
public class ByeApollon
{
	private Object canvas;
	private Clock clock;
	private PerspectiveCamera cam;
	private WebGLRenderer renderer;
	private Mesh mesh;
	private Scene scene;
	private Mesh textMesh;
	
	private AnimationFrameCallback callback;

	@JsIgnore
	public ByeApollon()
	{
		this( null );
	}
	
	public ByeApollon( Object canvas )
	{

		this.canvas = canvas;
		
		init();
	}

	private void init()
	{
		VolumetricFire.texturePath = "textures/";
		
		int width = Window.getInnerWidth();
		int height = Window.getInnerHeight();
		
		clock = new Clock();
		scene = new Scene();
		cam = new PerspectiveCamera(60, (double)width/(double)height, .1, 1000);
		cam.position.set(0, 0, 10);
		
		if ( canvas != null )
		{
			renderer = new WebGLRenderer( new WebGLRendererParameters.Builder()
				.canvas(canvas)
				.build() );
		}
		else
		{
			renderer = new WebGLRenderer();
			canvas = renderer.domElement;
		}
		
		renderer.setSize(width, height);
		
//		AxisHelper axisHelper = new AxisHelper(5);
//		scene.add(axisHelper);
		
		VolumetricFire fire = new VolumetricFire(8, 8, 5, 0.6, cam);
		fire.getMesh().position.set(-8, 3.8, 0);
		scene.add(fire.getMesh());
		
		PointLight light = new PointLight(0xFFE785, 2, 10);
		light.position.set(-8, 3.8, 0);
		

		scene.add(light);
		
		
		VolumetricFire fire2 = new VolumetricFire(8, 8, 5, 0.6, cam);
		fire2.getMesh().position.set(0, 3.8, 0);
		scene.add(fire2.getMesh());
		
		PointLight light2 = new PointLight(0xFFE785, 2, 10);
		light2.position.set(0, 3.8, 0);
		
		scene.add(light2);
		
		VolumetricFire fire3 = new VolumetricFire(8, 8, 5, 0.6, cam);
		fire3.getMesh().position.set(8, 3.8, 0);
		scene.add(fire3.getMesh());
		
		PointLight light3 = new PointLight(0xFFE785, 2, 10);
		light3.position.set(8, 3.8, 0);
		
		scene.add(light3);
		
		FontLoader fontLoader = new FontLoader();
		fontLoader.load("fonts/helvetiker_bold.typeface.json", new OnLoadCallback<Font>()
		{
			
			@Override
			public void onLoad(Font object)
			{
				TextGeometry textGeom = new TextGeometry("Bye, bye apollon", new TextGeometryOptions.Builder()
				.font(object)
				.size(2)
				.bevelEnabled(true)
				.bevelSize(0.1)
				.bevelThickness(0.1)
				.height(2)
				.build());
				textMesh = new Mesh(textGeom, new MeshPhongMaterial());
				textMesh.position.set(-10, 0, -1.5);
				
				scene.add(textMesh);
			}
		});
		
		
		
		callback = new AnimationFrameCallback()
		{
			
			@Override
			public void execute()
			{
				Window.requestAnimationFrame(callback);

				int elapsed = clock.getElapsedTime();

				  cam.position.set(
				    Math.sin( elapsed * 0.1 ) * 8,
				    Math.sin( elapsed * 0.5 ) * 10,
				    Math.cos( elapsed * 0.1 ) * 12
				  );
				  cam.lookAt( scene.position );

				  fire.update( elapsed );
				  fire2.update(elapsed);
				  fire3.update(elapsed);

				  renderer.render( scene, cam );
			}
		};
		
		Window.requestAnimationFrame(callback);
	}
	
	public Object getCanvas()
	{
		return canvas;
	}
}
