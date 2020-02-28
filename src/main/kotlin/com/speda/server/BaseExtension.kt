package com.speda.server

import com.smartfoxserver.v2.core.ISFSEvent
import com.smartfoxserver.v2.core.SFSEventType
import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.entities.data.SFSObject
import com.smartfoxserver.v2.exceptions.SFSException
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import com.smartfoxserver.v2.extensions.BaseServerEventHandler
import com.smartfoxserver.v2.extensions.SFSExtension
import com.speda.utils.user


abstract class BaseExtension : SFSExtension() {
    private inline fun <reified T> addRequestHandler(requestId: String) = this.addRequestHandler(requestId, T::class.java)
    private inline fun <reified T> addEventHandler(eventType: SFSEventType) = this.addEventHandler(eventType, T::class.java)

}
