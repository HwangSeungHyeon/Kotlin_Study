package com.example.myapplication

class RoomNumInput : Hotel(){

    fun input() : Int{
        var room : Int = 0 //입력 받을 방 번호
        while (true){
            try{
                println("예약할 방 번호를 입력해주세요")
                room = readLine()!!.toInt()

                if(room in 100..999) break // 방번호 100에서 999 이내일 때
                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")

            }catch (e:Exception){
                println(e.message)
            }
        }
        return room
    }
}