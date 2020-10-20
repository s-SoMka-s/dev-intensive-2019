package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extension.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date){

    override fun formatMessage(): String {
        val status = if (isIncoming) "отправил" else "получил"
        val now = Date().time

        var time = "";

        return "${from?.firstName} $status изображение \"$image\" ${date.humanizeDiff(date)}"
    }
}