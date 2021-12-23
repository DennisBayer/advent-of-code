package de.courson.adventofcode.aoc2021

import readInput

fun main() {
	fun List<String>.countBitPair(index: Int): Pair<Int, Int> {
		var zeros = 0
		var ones = 0

		this.forEach { measurement ->
			when (measurement[index]) {
				'0' -> zeros++
				'1' -> ones++
			}
		}

		return zeros to ones
	}

	fun List<Pair<Int, Int>>.buildBinaryValue(): String {
		return joinToString("") { (first, second) ->
			if (first > second) "1" else "0"
		}
	}

	fun part1(input: List<String>): Int {
		val measurementLength = input.first().length

		val gamma = (0 until measurementLength)
			.map { index -> input.countBitPair(index) }
			.buildBinaryValue()

		val epsilon = gamma
			.map { bitValue -> if (bitValue == '1') "0" else "1" }
			.joinToString("")

		return gamma.toInt(2) * epsilon.toInt(2)
	}

//	fun part2(input: List<String>): Int {
//		return input.size
//	}

	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day03_test")
	check(part1(testInput) == 198)

	val input = readInput("Day03")
	println(part1(input))
//	println(part2(input))
}
