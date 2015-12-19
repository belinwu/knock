/*
The MIT License (MIT)

Copyright (c) 2015 Belin Wu (http://wujilin.com)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.wujilin.doorbell.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * The fragment starter to start activities.
 */
class FragmentStarter extends AbstractStarter {
  /**
   * The weak refrence to the fragment.
   */
  private WeakReference<Fragment> fragmentReference;

  /**
   * Constructs a FragmentStarter with the given fragment object.
   *
   * @param fragment The fragment object
   */
  public FragmentStarter(Fragment fragment) {
    this.fragmentReference = new WeakReference<>(fragment);
  }

  @Override
  public void startActivity(Intent intent, Bundle options) {
    Fragment fragment = fragmentReference.get();
    if (fragment != null) {
      fragment.startActivity(intent);
    }
  }

  @Override
  public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
    Fragment fragment = fragmentReference.get();
    if (fragment != null) {
      fragment.startActivityForResult(intent, requestCode);
    }
  }

  @Override
  public Activity getActivity() {
    Fragment fragment = fragmentReference.get();
    if (fragment == null) {
      return null;
    }
    return fragment.getActivity();
  }
}
