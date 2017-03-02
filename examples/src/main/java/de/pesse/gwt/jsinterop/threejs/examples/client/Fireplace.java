package de.pesse.gwt.jsinterop.threejs.examples.client;

import de.pesse.gwt.jsinterop.threeJs.Constants;
import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Clock;
import de.pesse.gwt.jsinterop.threeJs.geometries.PlaneBufferGeometry;
import de.pesse.gwt.jsinterop.threeJs.helpers.AxisHelper;
import de.pesse.gwt.jsinterop.threeJs.lights.AmbientLight;
import de.pesse.gwt.jsinterop.threeJs.lights.Light;
import de.pesse.gwt.jsinterop.threeJs.lights.PointLight;
import de.pesse.gwt.jsinterop.threeJs.loaders.TextureLoader;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;
import de.pesse.gwt.jsinterop.volumetricFire.VolumetricFire;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;
import jsinterop.core.Window;
import jsinterop.core.Window.AnimationFrameCallback;

@JsType(namespace="ThreeJsExamples")
public class Fireplace
{
	private Object canvas;
	private Clock clock;
	private PerspectiveCamera cam;
	private WebGLRenderer renderer;
	private Mesh mesh;
	private Scene scene;
	
	private AnimationFrameCallback callback;

	@JsIgnore
	public Fireplace()
	{
		this( null );
	}
	
	public Fireplace( Object canvas )
	{

		this.canvas = canvas;
		
		init();
	}

	private void init()
	{
		if ( canvas != null )
		{
			renderer = new WebGLRenderer( new WebGLRenderer.ParameterBuilder()
				.canvas(canvas)
				.build() );
		}
		else
		{
			renderer = new WebGLRenderer();
			canvas = renderer.domElement;
		}
		
		VolumetricFire.texturePath = "textures/";
		
		int width = Window.getInnerWidth();
		int height = Window.getInnerHeight();
		
		clock = new Clock();
		scene = new Scene();
		cam = new PerspectiveCamera(60, (double)width/(double)height, .1, 1000);
		cam.position.set(0, 0, 3);
		
		renderer.setSize(width, height);
		
		Light ambientLight = new AmbientLight(0x666655);
		scene.add(ambientLight);
		
		Light pointLight = new PointLight(0xff9933, 1, 1.5);
		pointLight.position.set(0, 1, 0);
		scene.add(pointLight);
		
		TextureLoader textureLoader = new TextureLoader();
		
		Texture groundColor = textureLoader.load("images/groundcolor.jpg");
		groundColor.wrapS = groundColor.wrapT = Constants.RepeatWrapping;
		groundColor.repeat.set(6, 6);
		
		Texture groundNormal = textureLoader.load("images/groundnormal.jpg");
		groundNormal.wrapS = groundNormal.wrapT = Constants.RepeatWrapping;
		groundNormal.repeat.set(6, 6);
		
		Mesh ground = new Mesh(new PlaneBufferGeometry(10, 10), null);
		
		
		VolumetricFire fire = new VolumetricFire(2.5, 4, 2.5, 0.5, cam);
		
		scene.add(fire.getMesh());
		
		
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
				    Math.cos( elapsed * 0.1 ) * 8
				  );
				  cam.lookAt( scene.position );

				  fire.update( elapsed );

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
