package org.fluentlenium.integration;

import org.assertj.core.api.ThrowableAssert;
import org.fluentlenium.core.annotation.Label;
import org.fluentlenium.core.annotation.LabelHint;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.wait.FluentWait;
import org.fluentlenium.integration.localtest.IntegrationFluentTest;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FluentWaitMessageTest extends IntegrationFluentTest {
    @Override
    public FluentWait await() {
        return super.await().atMost(100).pollingEvery(10);
    }

    @FindBy(css = "#disabled")
    private FluentWebElement disabled;

    @FindBy(css = "#disabled")
    private FluentList<FluentWebElement> disabledList;

    @FindBy(css = "#disabled")
    @Label
    private FluentWebElement disabledDefaultLabel;

    @FindBy(css = "#disabled")
    @Label
    private FluentList<FluentWebElement> disabledDefaultLabelList;

    @FindBy(css = "#disabled")
    @Label("custom")
    @LabelHint("hint")
    private FluentWebElement disabledCustomLabel;

    @FindBy(css = "#disabled")
    @Label("custom")
    @LabelHint("hint")
    private FluentList<FluentWebElement> disabledCustomLabelList;

    @Test
    public void testDisabled() {
        goTo(DEFAULT_URL);
        final FluentWebElement first = $("#disabled").first();
        assertThat(first.toString()).isEqualTo("By.cssSelector: #disabled (first) (Lazy Element)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element By.cssSelector: #disabled (first) (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();
        assertThat(first.toString()).isEqualTo("By.cssSelector: #disabled (first) (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />)");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element By.cssSelector: #disabled (first) (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testDisabledInjection() {
        goTo(DEFAULT_URL);
        final FluentWebElement first = disabled;
        assertThat(first.toString()).isEqualTo("By.cssSelector: #disabled (first) (Lazy Element)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element By.cssSelector: #disabled (first) (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();
        assertThat(first.toString()).isEqualTo("By.cssSelector: #disabled (first) (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />)");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element By.cssSelector: #disabled (first) (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testDisabledDefaultLabelInjection() {
        goTo(DEFAULT_URL);
        final FluentWebElement first = disabledDefaultLabel;
        assertThat(first.toString()).isEqualTo("FluentWaitMessageTest.disabledDefaultLabel (Lazy Element)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element FluentWaitMessageTest.disabledDefaultLabel (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();
        assertThat(first.toString()).isEqualTo("FluentWaitMessageTest.disabledDefaultLabel (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />)");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element FluentWaitMessageTest.disabledDefaultLabel (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testDisabledCustomLabelInjection() {
        goTo(DEFAULT_URL);
        final FluentWebElement first = disabledCustomLabel;
        assertThat(first.toString()).isEqualTo("custom [hint] (Lazy Element)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element custom [hint] (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();
        assertThat(first.toString()).isEqualTo("custom [hint] (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />)");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                first.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element custom [hint] (<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testDisabledList() {
        goTo(DEFAULT_URL);
        final FluentList<FluentWebElement> list = $("#disabled");
        assertThat(list.toString()).isEqualTo("By.cssSelector: #disabled (Lazy Element List)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements By.cssSelector: #disabled (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThat(list.toString()).isEqualTo("By.cssSelector: #disabled ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />])");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements By.cssSelector: #disabled ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />]) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    public void testDisabledListInjection() {
        goTo(DEFAULT_URL);
        final FluentList<FluentWebElement> list = disabledList;
        assertThat(list.toString()).isEqualTo("By.cssSelector: #disabled (Lazy Element List)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements By.cssSelector: #disabled (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThat(list.toString()).isEqualTo("By.cssSelector: #disabled ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />])");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements By.cssSelector: #disabled ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />]) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    public void testDisabledDefaultLabelListInjection() {
        goTo(DEFAULT_URL);
        final FluentList<FluentWebElement> list = disabledDefaultLabelList;
        assertThat(list.toString()).isEqualTo("FluentWaitMessageTest.disabledDefaultLabelList (Lazy Element List)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements FluentWaitMessageTest.disabledDefaultLabelList (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThat(list.toString()).isEqualTo("FluentWaitMessageTest.disabledDefaultLabelList ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />])");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements FluentWaitMessageTest.disabledDefaultLabelList ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />]) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    public void testDisabledCustomLabelListInjection() {
        goTo(DEFAULT_URL);
        final FluentList<FluentWebElement> list = disabledCustomLabelList;
        assertThat(list.toString()).isEqualTo("custom [hint] (Lazy Element List)");
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements custom [hint] (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThat(list.toString()).isEqualTo("custom [hint] ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />])");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                list.await().until().enabled();
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Elements custom [hint] ([<input id=\"disabled\" type=\"checkbox\" value=\"John\" disabled=\"disabled\" />]) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    public void testMessageContext() {
        goTo(DEFAULT_URL);
        final FluentWebElement select = $("#select").first();

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                select.await().until().rectangle().withWidth().lessThan(0);
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element By.cssSelector: #select (first) (Lazy Element) rectangle width is not less than 0")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testMessageContextWithLabel() {
        goTo(DEFAULT_URL);
        final FluentWebElement select = $("#select").first().withLabel("My Value Select").withLabelHint("hint1", "hint2");

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                select.await().until().rectangle().withWidth().lessThan(0);
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element My Value Select [hint1, hint2] rectangle width is not less than 0")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    public void testMessageContextWithLabelBefore() {
        goTo(DEFAULT_URL);
        final FluentWebElement select = $("#select").withLabel("My Value Select").withLabelHint("hint1", "hint2").first();

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                select.await().until().rectangle().withWidth().lessThan(0);
            }
        }).hasMessageStartingWith("Timed out after 0 seconds: Element My Value Select [hint1, hint2] rectangle width is not less than 0")
                .isExactlyInstanceOf(TimeoutException.class);
    }
}
