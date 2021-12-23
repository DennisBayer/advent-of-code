package de.courson.adventofcode.aoc2021

import readInput
import java.util.*

enum class Direction { UP, DOWN, FORWARD }
data class Instruction(val direction: Direction, val vector: Int)

fun main() {
	fun parseInstructions(input: List<String>) = input.map { command ->
		//				// a) Use List obtained by splitting
		//				command.split(" ").let { Instruction(Direction.valueOf(it[0].uppercase(Locale.getDefault())), it[1].toInt()) }

		// b) Use destructuring
		val (direction, vector) = command.split(" ")
		Instruction(Direction.valueOf(direction.uppercase(Locale.getDefault())), vector.toInt())
	}

	fun part1(input: List<String>): Int {
		var horizontal = 0
		var depth = 0

		parseInstructions(input).forEach { instruction ->
			when (instruction.direction) {
				Direction.UP -> depth -= instruction.vector
				Direction.DOWN -> depth += instruction.vector
				Direction.FORWARD -> horizontal += instruction.vector
			}

		}

		return horizontal * depth
	}

	fun part2(input: List<String>): Int {
		var horizontal = 0
		var depth = 0

		var aim = 0

		parseInstructions(input).forEach { instruction ->
			when (instruction.direction) {
				Direction.UP -> aim -= instruction.vector
				Direction.DOWN -> aim += instruction.vector
				Direction.FORWARD -> {
					horizontal += instruction.vector
					depth += (instruction.vector * aim)
				}
			}
		}

		return horizontal * depth
	}

	// test if implementation meets criteria from the description, like:
	val testInput = readInput("Day02_test")
	check(part1(testInput) == 150)
	check(part2(testInput) == 900)

	val input = readInput("Day02")
	println(part1(input))
	println(part2(input))
}
