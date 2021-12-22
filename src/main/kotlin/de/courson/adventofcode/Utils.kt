import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String, year: String = "2021") =
	File("src/main/resources/de/courson/adventofcode/aoc$year/$name.txt").readLines()
//	Files.readAllLines(object {}.javaClass.getResource("de/courson/adventofcode/aoc2021/$name.txt")?.toURI()?.toPath())

fun readInputAsInt(name: String, year: String = "2021") = readInput(name, year).map(String::toInt)

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
