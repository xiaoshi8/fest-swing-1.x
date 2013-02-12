/*
 * Created on Aug 9, 2009
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2009-2013 the original author or authors.
 */
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.test.core.CommonAssertions.failWhenExpectingException;
import static org.fest.swing.test.core.Regex.regex;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for {@link AbstractButtonDriver#requireText(javax.swing.AbstractButton, Pattern)}.
 * 
 * @author Alex Ruiz
 */
public class AbstractButtonDriver_requireTextAsPattern_Test extends AbstractButtonDriver_TestCase {
  @Test
  public void should_pass_if_text_matches_regex_pattern() {
    driver.requireText(checkBox, regex("Hell."));
  }

  @Test
  public void should_fail_if_text_does_not_match_regex_pattern() {
    try {
      Pattern pattern = regex("Bye.");
      driver.requireText(checkBox, pattern);
      failWhenExpectingException();
    } catch (AssertionError e) {
      System.out.println(e.getMessage());
      assertThat(e.getMessage()).contains("property:'text'").contains(
          "actual value:<'Hello'> does not match pattern:<'Bye.'>");
    }
  }
}
