package de.pesse.gwt.jsinterop.threejs.examples.client;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;
import jsinterop.core.Window;
import jsinterop.core.Window.AnimationFrameCallback;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.geometries.BoxBufferGeometry;
import de.pesse.gwt.jsinterop.threeJs.loaders.TextureLoader;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshBasicMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshBasicMaterialParameters;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

@JsType(namespace="ThreeJsExamples")
public class Box
{

	private Object canvas;
	private PerspectiveCamera cam;
	private WebGLRenderer renderer;
	private Mesh mesh;
	private Scene scene;
	
	private AnimationFrameCallback callback;

	@JsIgnore
	public Box()
	{
		this( null );
	}
	
	public Box( Object canvas )
	{

		this.canvas = canvas;
		
		init();
	}

	private void init()
	{

		cam = new PerspectiveCamera(70, (float) Window.getInnerWidth() / (float) Window.getInnerHeight(), 1, 1000);

		cam.position.z = 400;

		scene = new Scene();

		Texture texture = new TextureLoader().load("textures/crate.gif");

		Geometry geometry = new BoxBufferGeometry(200, 200, 200);
		
		Material material = new MeshBasicMaterial(new MeshBasicMaterialParameters.Builder().map(texture).build()); 

		mesh = new Mesh(geometry, material);

		scene.add(mesh);

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
		renderer.setPixelRatio(Window.getDevicePixelRatio());
		renderer.setSize(Window.getInnerWidth(), Window.getInnerHeight());

		com.google.gwt.user.client.Window.addResizeHandler(new ResizeHandler()
		{
			
			@Override
			public void onResize(ResizeEvent event)
			{
				cam.aspect = (float) Window.getInnerWidth() / (float) Window.getInnerHeight();
				cam.updateProjectionMatrix();

				renderer.setSize(Window.getInnerWidth(), Window.getInnerHeight());
			}
		});
		
		callback = new AnimationFrameCallback()
		{
			
			@Override
			public void execute()
			{
				Window.requestAnimationFrame(callback);

				renderer.render(scene, cam);

				mesh.rotation.x += 0.005;
				mesh.rotation.y += 0.01;
			}
		};
		
		Window.requestAnimationFrame(callback);
	}
	
	public Object getCanvas()
	{
		return canvas;
	}
}
