package com.example.myapplication

class CheckInInput : Hotel(){
    // 체크인 날짜 입력하는 함수
    fun input(checkInDays:ArrayList<Int>, checkOutDays:ArrayList<Int>, reservedFlag:Boolean, roomNumIdx:Int) : Int{
        var checkIn : Int = 0 //체크인

        while (true){
            try{
                println("체크인 날짜를 입력해주세요 표기형식. ${time}")
                checkIn = readLine()!!.toInt()

                // 만약 손님이 예약된 방을 예약하고 싶다고 한다면
                if(reservedFlag){
                    if(checkIn in checkInDays[roomNumIdx]..checkOutDays[roomNumIdx]){
                        println("해당 날짜에 이미 방을 사용중입니다. 다른 날짜를 입력해주세요")
                        continue
                    }
                }

                // 체크인 날짜가 현재 날짜랑 같거나 더 뒤일 때
                if(checkIn >= time) {
                    break
                }

                // 체크인 날짜가 현재보다 이전일 때
                println("체크인은 지난 날은 선택할 수 없습니다.")
            }
            catch(e:Exception){
                println(e.message)
            }
        }
        return checkIn
    }
}