/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.fabric.interop

import com.facebook.react.uimanager.events.BatchEventDispatchedListener
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.EventDispatcher
import com.facebook.react.uimanager.events.EventDispatcherListener
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.facebook.react.uimanager.events.RCTModernEventEmitter

@SuppressWarnings("rawtypes")
class FakeEventDispatcher : EventDispatcher {
  private val recordedDispatchedEvents = mutableListOf<Event<*>>()

  fun getRecordedDispatchedEvents(): List<Event<*>> {
    return recordedDispatchedEvents
  }

  override fun dispatchEvent(event: Event<*>) {
    recordedDispatchedEvents.add(event)
  }

  override fun dispatchAllEvents() {}

  override fun addListener(listener: EventDispatcherListener) {}

  override fun removeListener(listener: EventDispatcherListener) {}

  override fun addBatchEventDispatchedListener(listener: BatchEventDispatchedListener) {}

  override fun removeBatchEventDispatchedListener(listener: BatchEventDispatchedListener) {}

  override fun registerEventEmitter(uiManagerType: Int, eventEmitter: RCTEventEmitter) {}

  override fun registerEventEmitter(uiManagerType: Int, eventEmitter: RCTModernEventEmitter) {}

  override fun unregisterEventEmitter(uiManagerType: Int) {}

  override fun onCatalystInstanceDestroyed() {}
}
