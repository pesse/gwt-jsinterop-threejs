package de.pesse.gwt.jsinterop.threejs.examples.client;

import de.pesse.gwt.jsinterop.threeJs.Constants;
import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Clock;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.geometries.PlaneBufferGeometry;
import de.pesse.gwt.jsinterop.threeJs.helpers.AxisHelper;
import de.pesse.gwt.jsinterop.threeJs.lights.AmbientLight;
import de.pesse.gwt.jsinterop.threeJs.lights.Light;
import de.pesse.gwt.jsinterop.threeJs.lights.PointLight;
import de.pesse.gwt.jsinterop.threeJs.loaders.JSONLoader;
import de.pesse.gwt.jsinterop.threeJs.loaders.JSONLoader.OnJSONLoadCallback;
import de.pesse.gwt.jsinterop.threeJs.loaders.OnLoadCallback;
import de.pesse.gwt.jsinterop.threeJs.loaders.TextureLoader;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshPhongMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshPhongMaterialParameters;
import de.pesse.gwt.jsinterop.threeJs.materials.MultiMaterial;
import de.pesse.gwt.jsinterop.threeJs.math.Vector2;
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
	private Mesh fireplace;
	
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
		
		Mesh ground = new Mesh(
				new PlaneBufferGeometry(10, 10), 
				new MeshPhongMaterial(new MeshPhongMaterialParameters.Builder()
					.map(groundColor)
					.normalMap(groundNormal)
					.normalScale(new Vector2(0.8, 0.8))
					.build()));
		ground.rotation.x = Math.PI / -2;
		
		scene.add(ground);
		
		JSONLoader loader = new JSONLoader();
		loader.load("./models/fireplace.json", new OnJSONLoadCallback()
		{
			
			@Override
			public void onLoad(Geometry geometry, Material[] materials)
			{
				fireplace = new Mesh(geometry, new MultiMaterial(materials));
				
				scene.add(fireplace);
			}
		});
		
		double fireWidth = 1.5;
		double fireHeight = 2;
		double fireDepth = 1.5;
		double sliceSpacing = 0.5;
		
		
		
		VolumetricFire fire = new VolumetricFire(fireWidth, fireHeight, fireDepth, sliceSpacing, cam);
		
		scene.add(fire.getMesh());
		
		fire.getMesh().position.set(0, fireHeight/2f, 0);
		
		callback = new AnimationFrameCallback()
		{
			
			@Override
			public void execute()
			{
				Window.requestAnimationFrame(callback);

				int elapsed = clock.getElapsedTime();

				  cam.position.set(
				    Math.sin( elapsed * 0.1 ) * 4,
				    Math.sin( elapsed * 0.5 ) * 1 + 2,
				    Math.cos( elapsed * 0.1 ) * 4
				  );
				  cam.lookAt( scene.position );

				  pointLight.intensity = Math.sin(elapsed*30) * 0.25 + 3;
				  
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
