package org.jboss.weld.junit5.auto;

import org.jboss.weld.junit5.basic.Foo;
import org.jboss.weld.junit5.basic.SomeFoo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Produces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@EnableAutoWeld
@AddBeanClasses(SomeFoo.class)
class ExcludeBeanTest {

    @Produces
    @ExcludeBean
    Foo fakeFoo = new Foo("non-baz");

    @Test
    @DisplayName("Ensure @ExcludeBean excludes the implied bean class")
    void test(Foo myFoo) {
        assertNotNull(myFoo);
        assertEquals(myFoo.getBar(), "non-baz");
    }

}
