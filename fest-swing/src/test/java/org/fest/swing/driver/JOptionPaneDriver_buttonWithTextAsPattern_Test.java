/*
 * Created on Mar 11, 2008
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
 * Copyright @2008-2013 the original author or authors.
 */
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.driver.AbstractButtonTextQuery.textOf;
import static org.fest.swing.test.core.Regex.regex;
import static org.fest.swing.test.swing.JOptionPaneLauncher.launch;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Tests for {@link JOptionPaneDriver#buttonWithText(JOptionPane, java.util.regex.Pattern)}.
 * 
 * @author Alex Ruiz
 */
public class JOptionPaneDriver_buttonWithTextAsPattern_Test extends JOptionPaneDriver_TestCase {
  @Test
  public void should_find_button_with_text_matching_pattern() {
    JOptionPane optionPane = messageWithOptions("First", "Second");
    launch(optionPane, title());
    JButton button = driver.buttonWithText(optionPane, regex("Sec.*"));
    assertThat(textOf(button)).isEqualTo("Second");
  }
}
