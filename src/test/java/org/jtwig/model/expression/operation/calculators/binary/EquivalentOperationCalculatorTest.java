package org.jtwig.model.expression.operation.calculators.binary;

import org.jtwig.context.RenderContext;
import org.jtwig.model.expression.Expression;
import org.jtwig.model.expression.operation.binary.calculators.EquivalentOperationCalculator;
import org.jtwig.model.position.Position;
import org.jtwig.value.JtwigValue;
import org.jtwig.value.JtwigValueFactory;
import org.jtwig.value.configuration.DefaultValueConfiguration;
import org.jtwig.value.environment.ValueEnvironment;
import org.jtwig.value.environment.ValueEnvironmentFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class EquivalentOperationCalculatorTest {
    public static final ValueEnvironment VALUE_ENVIRONMENT = new ValueEnvironmentFactory().crete(new DefaultValueConfiguration());
    private final Position position = mock(Position.class);
    private final RenderContext context = mock(RenderContext.class, RETURNS_DEEP_STUBS);
    private final Expression leftOperand = mock(Expression.class);
    private final Expression rightOperand = mock(Expression.class);

    private EquivalentOperationCalculator underTest = new EquivalentOperationCalculator();


    @Before
    public void setUp() throws Exception {
        when(context.environment().value()).thenReturn(VALUE_ENVIRONMENT);
    }


    @Test
    public void calculateWhenEqual() throws Exception {
        when(leftOperand.calculate(context)).thenReturn(JtwigValueFactory.value("", VALUE_ENVIRONMENT));
        when(rightOperand.calculate(context)).thenReturn(JtwigValueFactory.value("", VALUE_ENVIRONMENT));

        JtwigValue result = underTest.calculate(context, position, leftOperand, rightOperand);

        assertThat(result.asBoolean(), is(true));
    }

    @Test
    public void calculateWhenNotEqual() throws Exception {
        when(leftOperand.calculate(context)).thenReturn(JtwigValueFactory.value("a", VALUE_ENVIRONMENT));
        when(rightOperand.calculate(context)).thenReturn(JtwigValueFactory.value("", VALUE_ENVIRONMENT));

        JtwigValue result = underTest.calculate(context, position, leftOperand, rightOperand);

        assertThat(result.asBoolean(), is(false));
    }
}