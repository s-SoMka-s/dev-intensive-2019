package ru.skillbranch.devintensive.extension

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView() : UserView{
    val nickName = Utils.transliteration("$firstName $lastName", "_")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Последный раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id = id,
        fullName = "$firstName $lastName",
        nickname = nickName,
        avatar = avatar,
        status = status,
        initials = initials
    )
}



