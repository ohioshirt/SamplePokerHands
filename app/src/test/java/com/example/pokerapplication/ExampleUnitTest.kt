package com.example.pokerapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 *
 * Spade, Heart, Diamond, Clover
 */
class ExampleUnitTest {
    @Test
    fun test_fullHouse() {
        val input = "D3C3C10D10S3"
        val output = PokerHands.makeHands(input)
        assertEquals("FH", output)
    }

    @Test
    fun test_4Cards() {
        val input = "D3C3C3D10S3"
        val output = PokerHands.makeHands(input)
        assertEquals("4K", output)
    }

    @Test
    fun test_3Cards() {
        val input = "D3C3C8DQS3"
        val output = PokerHands.makeHands(input)
        assertEquals("3K", output)
    }

    @Test
    fun test_2Pairs() {
        val input = "S8D10HJS10CJ"
        val output = PokerHands.makeHands(input)
        assertEquals("2P", output)
    }

    @Test
    fun test_1Pair() {
        val input = "SAD10HJS4CJ"
        val output = PokerHands.makeHands(input)
        assertEquals("1P", output)
    }

    @Test
    fun test_noPair() {
        val input = "S2D3H4S5C6"
        val output = PokerHands.makeHands(input)
        assertEquals("--", output)
    }
}
