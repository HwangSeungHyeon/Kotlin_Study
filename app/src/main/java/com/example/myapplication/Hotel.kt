package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.Collections
import java.util.Locale

open class Hotel{
    private val today = SimpleDateFormat("yyyyMMdd", Locale.KOREA) //한국 시간대를 20231206 같은 형식으로 출력하기로 정함
    val time = today.format(System.currentTimeMillis()).toInt()

    var guests = ArrayList<String>() // 게스트 이름 저장할 배열
    var roomNums = ArrayList<Int>() // 게스트가 머무를 방 번호 저장할 배열
    var checkInDays = ArrayList<Int>() // 게스트가 체크인한 날짜 저장할 배열
    var checkOutDays = ArrayList<Int>() //게스트가 체크아웃할 날짜 저장할 배열
    var cashes = ArrayList<Int>() //게스트 소지금 저장할 배열
    var paids = ArrayList<Int>() //게스트가 지불한 돈 저장할 배열

    fun display(){
        println("호텔 예약자 목록입니다.")
        for((i, data) in guests.withIndex()){
            println("${i+1}. 사용자: ${data}, 방번호:  ${roomNums[i]}호, 체크인: ${checkInDays[i]}, 체크아웃: ${checkOutDays[i]}")
        }
    }
}