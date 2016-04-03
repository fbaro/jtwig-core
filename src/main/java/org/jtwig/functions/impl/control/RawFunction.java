package org.jtwig.functions.impl.control;

import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.SimpleJtwigFunction;
import org.jtwig.render.context.RenderContextHolder;
import org.jtwig.render.context.model.EscapeMode;
import org.jtwig.render.context.model.RenderContext;

public class RawFunction extends SimpleJtwigFunction {
    @Override
    public String name() {
        return "raw";
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.maximumNumberOfArguments(1).minimumNumberOfArguments(1);
        getRenderContext().getEscapeModeContext().set(EscapeMode.NONE);
        return request.get(0);
    }

    protected RenderContext getRenderContext() {
        return RenderContextHolder.get();
    }
}