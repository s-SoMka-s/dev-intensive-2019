package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extension.TimeUnits
import ru.skillbranch.devintensive.extension.add
import ru.skillbranch.devintensive.extension.format
import ru.skillbranch.devintensive.extension.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun init_test(){
        var user1 = User("1")
        var user2 = User("2")
        var user3 = User("3")

        user1.printMe()

        println("$user1 $user2 $user3")
    }

    @Test
    fun testFactory(){
        var user0 = User.makeUser("John Dow")
        var user1 = user0.copy(lastVisit = Date());
        var user2 = user1.copy(lastVisit = Date().add(3, TimeUnits.SECOND))
        var user3 = user1.copy(lastVisit = Date().add(-2, TimeUnits.MINUTE))
        //user1.printMe()
        //user2.printMe()
        //println(user2);
        //println(user3);

        println("""
            ${user1.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_userView(){
        var user0 = User.makeUser("Игорь Чиёсов")
        var user1 = user0.toUserView();

        user1.printMe()
    }

    @Test
    fun test_abstractFactory(){
        var user0 = User.makeUser("Игорь Чиёсов")
        var textMessage = BaseMessage.makeMessage(user0, Chat("0"), type = "text", payload = "any text message")
        var imageMessage = BaseMessage.makeMessage(user0, Chat("0"), type = "image", payload = "any url")

        when(textMessage){
            is TextMessage -> println("this is textMessage")
            is ImageMessage -> println("this is Image Message")
        }
    }

    @Test
    fun test_message(){
        var user0 = User.makeUser("Игорь Чиёсов")
        var imageMessage = BaseMessage.makeMessage(from = user0, chat = Chat("0"), type = "image", payload = "any url", date = Date().add(2, TimeUnits.MINUTE))
        println(imageMessage.formatMessage())

    }
}