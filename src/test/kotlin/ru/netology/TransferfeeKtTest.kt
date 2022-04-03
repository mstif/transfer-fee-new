package ru.netology

import org.junit.Assert
import org.junit.Test

class TransferfeeKtTest {

    @Test
    fun getTransferFee_MasterCard_Before_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.MasterCard
        val previosPaymant = 74200
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(0, result)
    }

    @Test
    fun getTransferFee_MasterCard_After_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.MasterCard
        val previosPaymant = 76000
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(170 * 100, result)
    }

    @Test
    fun getTransferFee_Maestro_Before_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.Maestro
        val previosPaymant = 74200
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(0, result)
    }

    @Test
    fun getTransferFee_Maestro_After_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.Maestro
        val previosPaymant = 76000
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(170 * 100, result)
    }
    @Test
    fun getTransferFee_MasterCard_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.MasterCard
        val previosPaymant = 75000
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(0, result)
    }
    @Test
    fun getTransferFee_Maestro_75000() {
        val amount = 25000 * 100
        val typeCard = TypeCard.Maestro
        val previosPaymant = 75000
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(0, result)
    }

    @Test
    fun getTransferFee_Visa() {
        val amount = 25000 * 100
        val typeCard = TypeCard.Visa
        val previosPaymant = 0
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(18750, result)
    }

    @Test
    fun getTransferFee_Mir() {
        val amount = 25000 * 100
        val typeCard = TypeCard.MIR
        val previosPaymant = 0
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(18750, result)
    }

    @Test
    fun getTransferFee_Visa_Min() {
        val amount = 100
        val typeCard = TypeCard.Visa
        val previosPaymant = 0
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(3500, result)
    }

    @Test
    fun getTransferFee_Mir_Min() {
        val amount = 100
        val typeCard = TypeCard.MIR
        val previosPaymant = 0
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(3500, result)
    }

    @Test
    fun getTransferFee_VkPay() {
        val amount = 25000 * 100
        val typeCard = TypeCard.VkPay
        val previosPaymant = 0
        val result = getTransferFee(
            amount = amount,
            previousPaymants = previosPaymant,
            typeCard = typeCard
        )
        Assert.assertEquals(0, result)
    }

}