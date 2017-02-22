package de.pesse.gwt.jsinterop.threejs.examples.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Examples implements EntryPoint {
  
  private VerticalPanel panel = new VerticalPanel();
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {	  
	  init();
	}
  
  @JsMethod(namespace=JsPackage.GLOBAL)
  public static native void init();
}
