import scala.reflect.ClassManifestFactory.Object
import scala.util.control.Breaks

class Test(idd:Int) {//构造函数加()
  self=>//相当于java中的this
  private[this] var _id:Int=_//设置私有字段 Int=_表示无默认值,必须要写
  self._id=idd//注意重名问题
  def dis={
    println(self._id)
  }
  def id=self._id     //类似于java中的get方法
  def id_=(id:Int)={//类似于java中的set方法
    self._id=id
  }
}


class Person(idd:Int){
  self=>
  var id:Int=_
  self.id=idd
}
class Stu(idd:Int) extends Person(idd){//继承
  def this(){
    this(12)
  }
}


class Per{
  self=>
  //var id:Int=_
  val id:Int=1
}
class Stu1 extends Per{
  self=>
  //override var id:Int=_
  // 本质是个函数,得用override,不可以直接覆盖,变量不可以被覆盖
  override val id:Int=2//常量可以
}


trait Log1{//类似于java中的抽象方法,但是他的方法可以实现
  def log1: Unit ={
    println("log1")
  }
  def log4
}
trait Log2{
  def log2: Unit ={
    println("log2")
  }
}
trait Log3{
  def log3: Unit ={
    println("log3")
  }
}
class Dlog extends Log1 with Log2 with Log3{//继承多个需要用with连接
  override def log4: Unit = ???
}



case class Cc(id:Int,name:String,age:Int)//默认生成get set基本方法即 tostring ,,apply unapply
class TCc(var id:Int,var name:String,var age:Int){//不加var默认private
  self=>
  //自动生成,可以不写
  private[this] var _id:Int=_
  private[this] var _name:String=_
  private[this] var _age:Int=_
  self._id=id
  self._name=name
  self._age=age
}
object TCc{
  def apply(id:Int,name:String,age:Int):TCc={
    new TCc(id,name,age)
  }
  def unapply(t:TCc):Option[(Int,String,Int)]=Some(t.id,t.name,t.age)
}



class MInt{

}
class MyRichInt{
  def xxx={
    println("xxxxxx")
  }
}

object Test{
  def main(args: Array[String]): Unit = {
//    implicit def xxx(i:MInt)=new MyRichInt
//    var m=new MInt
//    m.xxx
//    for(i <- 1 to 10){
//      if (i%2==0){
//        for (j <- 1 to 3){
//          println(i+"  "+j+"  ")
//        }
//      }
//    }

    Breaks.breakable(
      for (i<- 1 to 10){
        if (i==3) Breaks.break()
        println(i)
      }
    )
   /* var a=1
    var d=a match {//类似于java中的switch*/

/*      case i if(i==1)=>i+10
      case i if(i==2)=>i+10
      case i if(i==3)=>i+10

      case 1=>println(1)
      case 2=>println(2)
      case _=>println(3)//类似于java中的def,其他
    }
    println(d)


     var dlog=new Dlog with Log1//可以new对象是继承接口
    dlog.log1*/


    /*var t=new Test
    t.id=1
    println(t.id)
    var t=new Test(12)
    t.dis
    t.id=13
    println(t.id)*/


  }
}