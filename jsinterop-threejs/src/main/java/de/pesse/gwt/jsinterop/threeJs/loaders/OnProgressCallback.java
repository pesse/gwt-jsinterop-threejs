package de.pesse.gwt.jsinterop.threeJs.loaders;

import com.google.gwt.xhr.client.XMLHttpRequest;

import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface OnProgressCallback
{
	void onProgress( XMLHttpRequest request );
}
