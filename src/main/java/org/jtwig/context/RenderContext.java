package org.jtwig.context;

import org.jtwig.environment.Environment;
import org.jtwig.context.impl.NodeRenderer;
import org.jtwig.context.impl.ResourceRenderer;
import org.jtwig.context.model.EscapeModeContext;
import org.jtwig.context.model.NodeContext;
import org.jtwig.context.model.ResourceContext;
import org.jtwig.context.values.ValueContext;

public interface RenderContext {
    Environment environment();
    ResourceRenderer resourceRenderer();
    NodeRenderer nodeRenderer();
    ResourceContext currentResource();
    ValueContext valueContext();
    NodeContext currentNode();
    EscapeModeContext escapeContext();
}
