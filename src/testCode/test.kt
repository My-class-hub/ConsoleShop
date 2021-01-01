package testCode
fun main(args:Array<String>){
    println("sssss")
    Cat("白猫").eat()
}
class Cat(val name: String){
    fun eat(){
        print("肉肉")
    }
}