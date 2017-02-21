package de.pesse.gwt.jsinterop.threejs.examples.client;

import jsinterop.core.Window;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.animation.client.AnimationScheduler.AnimationCallback;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.Composite;

import de.pesse.gwt.jsinterop.threeJs.Constants;
import de.pesse.gwt.jsinterop.threeJs.cameras.Camera;
import de.pesse.gwt.jsinterop.threeJs.cameras.PerspectiveCamera;
import de.pesse.gwt.jsinterop.threeJs.core.Clock;
import de.pesse.gwt.jsinterop.threeJs.core.Geometry;
import de.pesse.gwt.jsinterop.threeJs.geometries.BoxGeometry;
import de.pesse.gwt.jsinterop.threeJs.geometries.PlaneGeometry;
import de.pesse.gwt.jsinterop.threeJs.lights.DirectionalLight;
import de.pesse.gwt.jsinterop.threeJs.lights.Light;
import de.pesse.gwt.jsinterop.threeJs.loaders.TextureLoader;
import de.pesse.gwt.jsinterop.threeJs.materials.Material;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshLambertMaterial;
import de.pesse.gwt.jsinterop.threeJs.materials.MeshLambertMaterialParameters;
import de.pesse.gwt.jsinterop.threeJs.objects.Mesh;
import de.pesse.gwt.jsinterop.threeJs.renderers.WebGLRenderer;
import de.pesse.gwt.jsinterop.threeJs.scenes.Scene;
import de.pesse.gwt.jsinterop.threeJs.textures.Texture;

public class Smoke extends Composite implements AnimationCallback
{
	private Clock clock;
	private Camera camera;
	private Scene scene;
	private WebGLRenderer renderer;
	private Geometry geometry;
	private Material material;
	private Mesh mesh;
	
	private float cubeSineDriver = 0;
	private Canvas canvas;

	private Mesh[] smokeParticles;
	
	public Smoke()
	{		
		canvas = Canvas.createIfSupported();
		

		initWidget(canvas);

		
	}

	@Override
	protected void onLoad()
	{
		super.onLoad();
		
		clock = new Clock();
		
		renderer = new WebGLRenderer( new WebGLRenderer.ParameterBuilder()
			.canvas(canvas.getCanvasElement())
			.build() );
		renderer.setSize(Window.getInnerWidth(), Window.getInnerHeight());

		scene = new Scene();

		// Setting up camera
		camera = new PerspectiveCamera(75, (float) Window.getInnerWidth() / (float) Window.getInnerHeight(), 1, 10000);
		camera.position.z = 1000;

		scene.add(camera);

		geometry = new BoxGeometry(200, 200, 200);
		
		 material = new MeshLambertMaterial( new MeshLambertMaterialParameters.Builder()
			.color(0xaa6666)
			.wireframe(false)
			.build() );

		mesh = new Mesh(geometry, material);
		
		Geometry textGeo = new PlaneGeometry(300, 300);
		Texture textTexture = new TextureLoader().load("textures/quickText.png");
		
		Material textMaterial = new MeshLambertMaterial( new MeshLambertMaterialParameters.Builder()
			.color(0x00ffff)
			.opacity(1)
			.map(textTexture)
			.transparent(true)
			.blending(Constants.AdditiveBlending)
			.build());
		
		Mesh text = new Mesh(textGeo, textMaterial);
		text.position.z = 800;
		
		scene.add(text);
		
		Light light = new DirectionalLight(0xffffff, 0.5f);
		light.position.set(-1, 0, 1);
		scene.add(light);
		
		Texture smokeTexture = new TextureLoader().load("textures/Smoke-Element.png");
		Material smokeMaterial = new MeshLambertMaterial( new MeshLambertMaterialParameters.Builder()
			.color(0x00dddd)
			.map(smokeTexture)
			.transparent(true).build());
		Geometry smokeGeometry = new PlaneGeometry(300, 300);
		
		smokeParticles = new Mesh[150];
		
		for ( int i = 0; i <150; i++ )
		{
			Mesh particle = new Mesh(smokeGeometry, smokeMaterial);
			particle.position.set(Math.random()*500f-250f, Math.random()*500f-250f, Math.random()*1000f-100f);
			particle.rotation.z = Math.random()*360;
			
			scene.add(particle);
			
			smokeParticles[i] = particle;
		}
		
		renderer.render(scene, camera);
		
		AnimationScheduler.get().requestAnimationFrame(this);
	}
	
	@Override
	public void execute(double timestamp)
	{

		AnimationScheduler.get().requestAnimationFrame(this);
		
		double delta = clock.getDelta();
		evolveSmoke(delta);
		render();
	}
	
	private void evolveSmoke( double delta )
	{
		for ( Mesh particle : smokeParticles )
			particle.rotation.z += delta*0.2;
		
	}
	
	private void render()
	{
		mesh.rotation.x += 0.005;
	    mesh.rotation.y += 0.01;
	    cubeSineDriver += .01;
	    mesh.position.z = 100 + (Math.sin(cubeSineDriver) * 500);
	    renderer.render( scene, camera );
	}

}
