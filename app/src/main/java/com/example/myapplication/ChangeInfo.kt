package com.example.myapplication

class ChangeInfo {
    fun changeInfo(hotel: Hotel){
        var guestIndex = 0
        var changeNum = 0
        var commend = 0

        try {
            println("예약을 변경할 사용자 이름을 입력하세요")
            var guestName = readLine().toString()

            if(hotel.guests.contains(guestName)){
                println("${guestName} 님이 예약한 목록입니다. 변경하실 예약번호를 입력해주세요")
                for ((i, data) in hotel.guests.withIndex()){
                    if(guestName == data){
                        println(". 사용자: ${hotel.guests[i]}, 방번호:  ${hotel.roomNums[i]}호, 체크인: ${hotel.checkInDays[i]}, 체크아웃: ${hotel.checkOutDays[i]}")
                    }
                }
                changeNum = readLine()!!.toInt()
                println("해당 예약을 어떻게 하시겠어요? 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기")
                commend = readLine()!!.toInt()
                when(commend){
                    1 -> {println("변경한다.")}
                    2 -> {
                        println("취소한다.")
                    }
                    else -> {println("메뉴로 돌아갑니다.")}
                }
            }
            else{
                println("사용자 이름으로 예약된 목록을 찾을 수 없습니다.")
            }

        }catch (e:Exception){
            println(e.message)
        }
    }
}