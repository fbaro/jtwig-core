package org.jtwig.resource;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Representation of a Jtwig resource. It only requires a way to retrieve an input stream containing the content.
 * This wrapper interface was meant to allow complex constructions on top of specific implementations, like caching mechanisms.
 */
public interface Resource {
    InputStream getContent();
    Charset getCharset();
}
