package de.pesse.gwt.jsinterop.threeJs.loaders;

import jsinterop.annotations.JsFunction;

@JsFunction
@FunctionalInterface
public interface OnErrorCallback
{
	void onError();
}
