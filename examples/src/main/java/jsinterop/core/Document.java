/*
 * Copyright 2015 David Preindl <david.preindl@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jsinterop.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The Document interface represent any web page loaded in the browser and serves as an entry point into the
 * web page's content, the DOM tree including elements such as &lt;body&gt; or &lt;table&gt;, and provides
 * functionality which is global to the document (such as obtaining the page's URL and creating new elements
 * in the document).
 *
 */
@JsType(isNative = true)
public interface Document 
{

	public void appendChild( Object child );
	
    /**
     * Creates the specified HTML element or an HTMLUnknownElement if the given element name isn't a known
     * one.
     *
     * @param tag Is a string that specifies the type of element to be created. The nodeName of the created
     *            element is initialized with the value of tagName. Don't use qualified names (like "html:a")
     *            with this method.
     * @return The created Element object.
     */
    <T> T createElement(String tag);

    @JsType(isNative = true)
    public static class DocumentUtil {

        /**
         * Returns the global scoped Document object.
         */
        @JsProperty(name = "document", namespace = JsPackage.GLOBAL)
        public static Document document;

    }
}