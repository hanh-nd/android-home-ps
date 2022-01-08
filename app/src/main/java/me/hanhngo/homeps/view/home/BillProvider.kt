package me.hanhngo.homeps.view.home

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.hanhngo.homeps.domain.Bill

class BillProvider {

    private val gson = Gson()

    suspend fun getBillListData(): List<Bill> {
        val typeToken = object : TypeToken<List<Bill>>(){}.type
        return gson.fromJson(getBillDataString(), typeToken)
    }

    private fun getBillDataString(): String {
        return """
            [
            {
            orderServices: [ ],
            billId: 5,
            timeStart: "2021-12-23T01:32:24.448593Z",
            timeEnd: "2021-12-24T14:30:43.106770Z",
            playStation: {
            psId: 3,
            psName: "Máy 03",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 37,
            totalPrice: 1110000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 14,
            timeStart: "2021-12-24T17:06:42.531751Z",
            timeEnd: "2021-12-24T19:28:28.817251Z",
            playStation: {
            psId: 2,
            psName: "Máy 02",
            psStatus: 0,
            psState: "Trống",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 2.5,
            totalPrice: 75000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 15,
            timeStart: "2021-12-24T17:10:58.052602Z",
            timeEnd: "2021-12-24T19:22:00.491098Z",
            playStation: {
            psId: 3,
            psName: "Máy 03",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 2.5,
            totalPrice: 75000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 16,
            timeStart: "2021-12-24T19:59:39.076192Z",
            timeEnd: "2021-12-24T20:02:26.806417Z",
            playStation: {
            psId: 1,
            psName: "Máy 01",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 17,
            timeStart: "2021-12-24T20:00:00.332697Z",
            timeEnd: "2021-12-24T20:03:56.148051Z",
            playStation: {
            psId: 2,
            psName: "Máy 02",
            psStatus: 0,
            psState: "Trống",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 18,
            timeStart: "2021-12-24T20:00:11.608679Z",
            timeEnd: "2021-12-24T20:03:29.297906Z",
            playStation: {
            psId: 3,
            psName: "Máy 03",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 19,
            timeStart: "2021-12-24T20:01:29.920341Z",
            timeEnd: "2021-12-24T20:07:05.171740Z",
            playStation: {
            psId: 4,
            psName: "Máy 04",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 20,
            timeStart: "2021-12-24T20:04:16.316363Z",
            timeEnd: "2021-12-24T20:05:36.648551Z",
            playStation: {
            psId: 1,
            psName: "Máy 01",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 21,
            timeStart: "2021-12-24T20:04:45.508402Z",
            timeEnd: "2021-12-24T20:07:21.513501Z",
            playStation: {
            psId: 2,
            psName: "Máy 02",
            psStatus: 0,
            psState: "Trống",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            },
            {
            orderServices: [ ],
            billId: 22,
            timeStart: "2021-12-24T20:07:29.348508Z",
            timeEnd: "2021-12-24T20:07:39.513764Z",
            playStation: {
            psId: 1,
            psName: "Máy 01",
            psStatus: 1,
            psState: "Đang sử dụng",
            hibernateLazyInitializer: { }
            },
            event: null,
            dailyEvent: null,
            totalHourPlayed: 0.5,
            totalPrice: 15000,
            paid: true
            }
            ]           
        """.trimIndent()
    }
}