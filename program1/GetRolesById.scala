import collection.mutable.HashMap
import scala.util.Try

case class User(name : String, roles: List[String])

case class UserRepository(userDictionary: HashMap[Int,User]){
    def findUser(id: Int): User = { 
        if (userDictionary.keySet.exists(_ == id)){
            userDictionary(id)
        } else {
            null
        }
    }
}

object GetRolesById {
    def tryToInt( s: String ) = Try(s.toInt).getOrElse(-1)
    def main(args:Array[String]):Unit = {
        val userDictInit = HashMap(1 -> User("mickey",List("admin","content manager")),2 -> User("donald",List("user")))
        val userRepository = UserRepository(userDictInit)
        if (!args.isEmpty){
            val user = userRepository.findUser(tryToInt(args(0)))
            if (user!= null) {
                user.roles.map(x => println("Role: "+x))
            }
        }
    }
}

