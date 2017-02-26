package de.pesse.gwt.jsinterop.threejs.examples.client;

import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Clock;
import de.pesse.gwt.jsinterop.threeJs.helpers.AxisHelper;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;
import de.pesse.gwt.jsinterop.volumetricFire.VolumetricFire;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;
import jsinterop.core.Window;
import jsinterop.core.Window.AnimationFrameCallback;

@JsType(namespace="ThreeJsExamples")
public class Fire
{
	private Object canvas;
	private Clock clock;
	private PerspectiveCamera cam;
	private WebGLRenderer renderer;
	private Mesh mesh;
	private Scene scene;
	
	private AnimationFrameCallback callback;

	@JsIgnore
	public Fire()
	{
		this( null );
	}
	
	public Fire( Object canvas )
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
		cam.position.set(0, 0, 3);
		
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
		
		renderer.setSize(width, height);
		
		AxisHelper axisHelper = new AxisHelper(5);
		scene.add(axisHelper);
		
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
