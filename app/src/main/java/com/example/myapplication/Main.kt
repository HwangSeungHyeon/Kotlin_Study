package com.example.myapplication

fun main() {
    hotelBookingProgram() // 호텔 예약 프로그램 함수 실행
}

fun hotelBookingProgram(){
    val hotel = Hotel() // 호텔 객체 생성
    val nameInputClass = NameInput() //이름 입력 기능 객체 생성
    val roomNumInputClass = RoomNumInput() // 방번호 입력 기능 객체 생성
    val checkInInputClass = CheckInInput() // 체크인 날짜 입력 기능 객체 생성
    val checkOutInputClass = CheckOutInput() // 체크아웃 날짜 입력 기능 객체 생성
    val sortedDisplayClass = SortedDisplay() // 정렬해서 출력하는 객체 생성
    val showmethemoneyClass = ShowMeTheMoney() // 금액 입출금 내역 목록 출력
    val changeInfoClass = ChangeInfo() // 정보 수정

    var command = 0 // 입력한 메뉴 번호를 저장할 변수 선언
    var name = ""
    var roomNum = 0
    var checkIn = 0
    var checkOut = 0
    var myMoney = 0
    var payment = 0

    var reservedFlag = false // 방이 예약되어 있다면 플래그가 true로 변함
    
    while (true){
        try {
            displayHotelMenu() // 호텔 메뉴 출력
            command = readLine()!!.toInt() // 메뉴 번호 입력 받음

            when(command){
                1 -> {
                    reservedFlag = false //예약 플래그를 false로 초기화

                    // 일단 입력 받음
                    name = nameInputClass.input()
                    roomNum = roomNumInputClass.input()
                    if(hotel.roomNums.contains(roomNum)) reservedFlag = true //방이 예약된 기록이 있으면 true로 변함

                    checkIn = checkInInputClass.input(hotel.checkInDays, hotel.checkOutDays, reservedFlag, hotel.roomNums.indexOf(roomNum)) // 방이 예약된 기록이 있으면 true가 갈 거고,예약된 기록 없으면 false가 갈 거임
                    checkOut = checkOutInputClass.input(checkIn, hotel.checkInDays, hotel.checkOutDays, reservedFlag, hotel.roomNums.indexOf(roomNum))

                    myMoney = randomMoney(true)
                    payment = randomMoney(false)


                    // 여기부터는 클래스에 저장함
                    hotel.guests.add(name)
                    hotel.roomNums.add(roomNum)
                    hotel.checkInDays.add(checkIn)
                    hotel.checkOutDays.add(checkOut)
                    hotel.cashes.add(myMoney)
                    hotel.paids.add(payment)
                    println("호텔 예약이 완료되었습니다.")
                }
                2 -> {
                    hotel.display() // 호텔 예약자 목록
                }
                3 -> {
                    sortedDisplayClass.display(hotel) //체크인 날짜순으로 오름차순 정렬된 예약자 목록
                }
                4 -> {
                    println("프로그램을 종료합니다.")
                    break
                }
                5 -> {
                    showmethemoneyClass.display(hotel.guests, hotel.cashes, hotel.paids)
                }
                6 -> {
                    changeInfoClass.changeInfo(hotel)
                }
                else -> println("지원하지 않는 기능입니다.\n") // 다른 번호는 지원하지 않음
            }
        }catch(e:Exception){ // 메뉴 실행 도중 에러 발생 했다면
            println("에러가 발생했습니다.\n")
        }
    }
}

// 메뉴 띄우는 함수
fun displayHotelMenu(){
    println("호텔예약 프로그램 입니다.")
    println("[메뉴]")
    println("1. 방예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입출금 내역 목록 출력, 6. 예약 변경/취소")
}

fun randomMoney(flag: Boolean): Int{
    val cashRange = (50000 .. 200000) // 랜덤 소지금 범위
    val paidRange = (10000 .. 35000) // 랜덤 지불 금액 범위

    return if(flag){
        cashRange.random()
    }
    else{
        paidRange.random()
    }
}