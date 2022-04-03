package ru.netology

import kotlin.math.roundToInt

const val PERCENT_MAESTRO_MASTERCARD_FIRST = 0.6f / 100
const val ADD_MAESTRO_MASTERCARD_FIRST = 20 * 100
const val PERCENT_VISA_MIR_FIRST = 0.75f / 100
const val MIN_VISA_MIR_FEE = 35 * 100

fun main() {
    val amount = 25000 * 100
    println(
        "Комиссия с перевода $amount копеек составит ${
            getTransferFee(
                amount,
                74200 ,
                TypeCard.MasterCard
            )
        } копеек"
    )
}


enum class TypeCard {
    VkPay,
    MasterCard,
    Visa,
    Maestro,
    MIR
}


fun getTransferFee(amount: Int, previousPaymants: Int = 0, typeCard: TypeCard = TypeCard.VkPay): Int {
    return when (typeCard) {
        TypeCard.VkPay -> 0
        TypeCard.Maestro, TypeCard.MasterCard -> when (previousPaymants) {
            in 0..75_000  -> 0
            else -> (amount * PERCENT_MAESTRO_MASTERCARD_FIRST  + ADD_MAESTRO_MASTERCARD_FIRST ).roundToInt()
        }
        TypeCard.MIR, TypeCard.Visa -> Math.max((amount * PERCENT_VISA_MIR_FIRST ).roundToInt(), MIN_VISA_MIR_FEE)
    }


}
