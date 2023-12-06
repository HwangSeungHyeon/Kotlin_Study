package com.example.myapplication

class CheckOutInput : Hotel(){
    // 체크아웃 입력하는 함수
    fun input(_checkIn:Int, checkInDays:ArrayList<Int>, checkOutDays:ArrayList<Int>, reservedFlag:Boolean, roomNumIdx:Int): Int{
        var checkOut : Int = 0
        val checkIn:Int = _checkIn

        while (true){
            try{
                println("체크아웃 날짜를 입력해주세요 표기형식. ${time}")
                checkOut = readLine()!!.toInt()

                // 만약 손님이 예약된 방을 예약하고 싶다고 한다면
                if(reservedFlag){
                    if(checkOut in checkInDays[roomNumIdx]..checkOutDays[roomNumIdx]){
                        println("해당 날짜에 이미 방을 사용중입니다. 다른 날짜를 입력해주세요")
                        continue
                    }
                }

                if (checkOut > checkIn){ //체크인 날짜보다 뒤일 때
                    break
                }

                // 체크아웃 날짜가 체크인 날짜과 같거나 이전일 때
                println("체크인 날짜보다 이전이거나 같을 수는 없습니다.")

            }catch (e:Exception){
                println(e.message)
            }
        }
        return checkOut
    }
}