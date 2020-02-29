package com.speda.captain.sonar.utils

import com.smartfoxserver.v2.core.ISFSEvent
import com.smartfoxserver.v2.core.SFSEventParam
import com.smartfoxserver.v2.entities.User


val ISFSEvent.user get() = getParameter(SFSEventParam.USER) as User
