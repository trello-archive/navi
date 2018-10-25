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

package com.trello.navi2.model;

import android.content.Intent;

import com.google.auto.value.AutoValue;

import androidx.annotation.Nullable;

@AutoValue public abstract class ActivityResult {

  public static ActivityResult create(int requestCode, int resultCode, @Nullable Intent data) {
    return new AutoValue_ActivityResult(requestCode, resultCode, data);
  }

  public abstract int requestCode();

  public abstract int resultCode();

  @Nullable public abstract Intent data();
}
