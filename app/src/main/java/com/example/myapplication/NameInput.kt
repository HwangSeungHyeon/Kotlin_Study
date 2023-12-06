package com.example.myapplication

class NameInput : Hotel(){

    fun input(): String{
        var name = "" // 입력 받을 사람 이름
        while (true){
            try{
                println("예약자분의 성함을 입력해주세요")
                name = readLine().toString() // 예약자 이름 입력 받음

                if(name.isBlank()){
                    throw IllegalArgumentException("공백은 입력할 수 없습니다.")
                }
                break

            }
            catch(e:Exception){ // 예외가 발생할 때(공백 있다던가)
                println(e.message)
            }
        }
        return name
    }
}