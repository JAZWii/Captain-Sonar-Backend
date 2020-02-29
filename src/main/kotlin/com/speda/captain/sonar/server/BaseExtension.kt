package com.speda.captain.sonar.server

import com.smartfoxserver.v2.core.SFSEventType
import com.smartfoxserver.v2.extensions.SFSExtension


abstract class BaseExtension : SFSExtension() {
    private inline fun <reified T> addRequestHandler(requestId: String) = this.addRequestHandler(requestId, T::class.java)
    private inline fun <reified T> addEventHandler(eventType: SFSEventType) = this.addEventHandler(eventType, T::class.java)

}
