package com.example.myapplication

class SortedDisplay {
    fun display(hotel: Hotel){
        val sortedCheckInDays = hotel.checkInDays.sorted()
        var originalIdx = 0

        println(sortedCheckInDays)
        for((i, data) in sortedCheckInDays.withIndex()){ // 정렬되어 있으니까 날짜가 순서대로 나온다.
            originalIdx = hotel.checkInDays.indexOf(data) // 정렬되어 있는 날짜의 원래 리스트에서의 위치를 가져옮

            println("${i+1}. 사용자: ${hotel.guests[originalIdx]}, 방번호:  ${hotel.roomNums[originalIdx]}호, 체크인: ${hotel.checkInDays[originalIdx]}, 체크아웃: ${hotel.checkOutDays[originalIdx]}")
        }
    }
}