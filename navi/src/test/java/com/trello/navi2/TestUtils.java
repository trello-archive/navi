/*
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

package com.trello.navi2;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestUtils {

  // This horrible hack is used while mockableAndroidJar isn't working properly
  public static void setSdkInt(int value) {
    try {
      Field field = Build.VERSION.class.getField("SDK_INT");
      field.setAccessible(true);

      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

      field.setInt(null, value);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
