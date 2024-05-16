/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.sample.feature.chat

import com.google.ai.sample.BuildConfig
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

enum class Participant {
    USER {
        override fun getName(): String {
            return "王仁甫"
        }
    },
    MODEL {
        override fun getName(): String {
            return BuildConfig.chatModelVersion
        }
    },
    ERROR {
        override fun getName(): String {
            return BuildConfig.chatModelVersion
        }
    };

    abstract fun getName(): String
}

data class ChatMessage(
    val id: String = UUID.randomUUID().toString(),
    var text: String = "",
    val participant: Participant = Participant.USER,
    var isPending: Boolean = false,
    val currentTime: LocalDateTime = LocalDateTime.now()

) {
    fun getTime(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return currentTime.format(formatter)
    }
}
