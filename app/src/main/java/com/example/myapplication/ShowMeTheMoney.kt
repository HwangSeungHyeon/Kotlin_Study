package com.example.myapplication

class ShowMeTheMoney {
    fun display(guests:ArrayList<String>, cashes:ArrayList<Int>, paids:ArrayList<Int>){
        var guestIndex = 0

        try{
            println("조회하실 사용자 이름을 입력하세요.")
            var guestName = readLine().toString()
            if(guests.contains(guestName)){
                guestIndex = guests.indexOf(guestName)
                println("1. 초기 금액으로 ${cashes[guestIndex]}원 입금되었습니다.")
                println("2. 예약금으로 ${paids[guestIndex]}원 출금되었습니다.")
            }
            else{
                println("예약된 사용자를 찾을 수 없습니다.")
            }

        }catch (e:Exception){
            println(e.message)
        }


    }
}