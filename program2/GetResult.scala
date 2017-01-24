import scala.util.Random

case class Baz(result:String){
    def getResult(): Option[String] = { 
        val decision = new Random().nextFloat()
        if (decision>0.3){
            Option(result)
        } else {
            Option(null)
        }
    }
}

case class Bar(baz:Baz){
    def getBaz(): Option[Baz] = { 
        val decision = new Random().nextFloat()
        if (decision>0.1){
            Option(baz)
        } else {
            Option(null)
        }
    }
}

case class Foo(bar:Bar){
    def getSecond(): Option[Bar] = { 
        val decision = new Random().nextFloat()
        if (decision>0.1){
            Option(bar)
        } else {
            Option(null)
        }
    }
}

object GetResult {
    def getFoo(): Option[Foo] = {
            val decision = new Random().nextFloat()
            if (decision>0.1){
                Option(Foo(Bar(Baz("Test result"))))
            } else {
                Option(null)
            }
            
        }
    def main(args:Array[String]):Unit = {
        for {
          foo <- getFoo()
          bar <- foo.getSecond()
          baz <- bar.getBaz()
          result <- baz.getResult()
        } yield println(result)
    }
}