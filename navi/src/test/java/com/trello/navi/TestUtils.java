package com.trello.navi;

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
