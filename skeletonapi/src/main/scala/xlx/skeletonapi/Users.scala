package xlx

import collection.mutable.HashMap
import scala.util.Try
import org.http4s._
import org.http4s.server._
import org.http4s.dsl._
import org.http4s.json4s.jackson._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

case class User(id: Int, firstName : String, lastName: String, age:Int)
case class ReturnStatus(response: String)
case class UserRepository(userDictionary: HashMap[Int,User]){
    var allUsers = userDictionary retain {(key,value) => (key == value.id && value.id>0 && value.age>=0)}
    def returnAll(): List[User] = { 
        allUsers.values.toList
    }
    def findUser(id: Int): Option[User] = { 
        if (allUsers.keySet.exists(_ == id)){
            Option(allUsers(id))
        } else {
            Option(null)
        }
    }
    def postUser(user: User): ReturnStatus = { 
        if (user.id > 0 && user.age >= 0) {
            allUsers += (user.id -> user)
            ReturnStatus("Success")
        } else {
            ReturnStatus("Failure")
        }
        
    }
}

object Users {
    implicit val formats = DefaultFormats
    implicit val userReader = new Reader[User] { 
      def read(value: JValue): User = Try(value.extract[User]).getOrElse(User(0,"","",0))
    }
    implicit val userDec = jsonOf[User]
    def userToJson(user:User):String = {
        val userResultJson = (
            ("id" -> user.id) ~
            ("firstName" -> user.firstName) ~
            ("lastName" -> user.lastName) ~
            ("age" -> user.age)
        )
        if (user.id<=0) {""} else {compact(render(userResultJson))}
    }
    def returnStatusToJson(returnStatus:ReturnStatus):String = {
        val returnStatusJson = (
            ("response" -> returnStatus.response) 
        )
        compact(render(returnStatusJson))
    }
    var userRepository = UserRepository(HashMap(1->User(1,"Mickey","Mouse",83)))
    val service = HttpService {
    case GET -> Root / "Users" =>
        Ok("["+userRepository.returnAll().map(x => userToJson(x)).mkString(",")+"]\n")
    case GET -> Root / "Users" / id => {
        userRepository.findUser(Try(id.toInt).getOrElse(-1)) match {
            case Some(user) => Ok(userToJson(user)+"\n")
            case None => Ok("")
        }
    }
    case req @ POST -> Root / "Users" =>
        req.as[User] flatMap ( user => Ok(returnStatusToJson(userRepository.postUser(user))+"\n"))
    }
}