import scala.util.Random

case class Baz(result:String){
    def getResult(): String = { 
        val decision = new Random().nextFloat()
        if (decision>0.5){
            result
        } else {
            null
        }
    }
}

case class Bar(baz:Baz){
    def getBaz(): Baz = { 
        val decision = new Random().nextFloat()
        if (decision>0.1){
            baz
        } else {
            null
        }
    }
}

case class Foo(bar:Bar){
    def getSecond(): Bar = { 
        val decision = new Random().nextFloat()
        if (decision>0.1){
            bar
        } else {
            null
        }
    }
}

object GetResult {
    def getFoo(): Foo = {
            val decision = new Random().nextFloat()
            if (decision>0.1){
                Foo(Bar(Baz("Test result")))
            } else {
                null
            }
            
        }
    def main(args:Array[String]):Unit = {
        val foo = getFoo()
        if (foo!= null){
            val bar = foo.getSecond()
            if (bar!=null){
                val baz = bar.getBaz()
                if(baz!=null){
                    val result = baz.getResult()
                    if(result!=null){
                        println(result)
                    }
                }
            }
        }
    }
}