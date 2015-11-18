package org.jtwig.model.tree;

import com.google.common.base.Optional;
import org.jtwig.context.model.EscapeMode;
import org.jtwig.context.model.NodeContext;
import org.jtwig.model.expression.Expression;
import org.jtwig.model.position.Position;
import org.jtwig.render.Renderable;
import org.jtwig.value.JtwigValueFactory;
import org.jtwig.value.configuration.DefaultValueConfiguration;
import org.jtwig.value.environment.ValueEnvironment;
import org.jtwig.value.environment.ValueEnvironmentFactory;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OutputNodeTest extends AbstractNodeTest {
    public static final ValueEnvironment VALUE_ENVIRONMENT = new ValueEnvironmentFactory().crete(new DefaultValueConfiguration());
    private final Position position = mock(Position.class);
    private final Expression expression = mock(Expression.class);
    private OutputNode underTest = new OutputNode(position, expression);

    @Test
    public void render() throws Exception {
        NodeContext nodeContext = mock(NodeContext.class);
        when(renderContext().currentNode()).thenReturn(nodeContext);
        when(nodeContext.mode()).thenReturn(Optional.<EscapeMode>absent());
        when(renderContext().environment().rendering().getDefaultOutputCharset()).thenReturn(Charset.defaultCharset());
        when(expression.calculate(renderContext())).thenReturn(JtwigValueFactory.value("test", VALUE_ENVIRONMENT));

        Renderable result = underTest.render(renderContext());

        assertThat(renderResult(result), is("test"));
    }
}