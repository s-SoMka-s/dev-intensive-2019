package ru.skillbranch.devintensive.models

import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        TODO("not yet imp")
    }
}