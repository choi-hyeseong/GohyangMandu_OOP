package io

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.util.Scanner

/**
 * 입출력을 담당하는 콘솔 클래스입니다.
 * @property input 입력 스트림입니다. 기본값은 System.in 입니다.
 * @property output 출력 스트림입니다. 기본값은 System.out 입니다.
 * @property scanner 입력 스트림을 scan하는 스캐너입니다.
 * @property writer 출력 스트림을 버퍼화해 처리하는 출력기입니다.
 */
class Console(private val input : InputStream = System.`in`, private val output : OutputStream = System.out) {

    private val scanner : Scanner = Scanner(input)
    private val writer : BufferedWriter = BufferedWriter(OutputStreamWriter(output))
    /**
     * 문자열을 출력합니다.
     */
    fun print(str : String) {
        writer.write(str)
        writer.flush() //flush를 안해주면 출력 안됨
    }

    /**
     * 숫자를 입력받습니다.
     * 현재 숫자를 고르는 방식이므로 해당 함수만 구현합니다.
     * @throws InputMisMatchException 입력값이 숫자가 아닌경우 발생합니다.
     */
    fun readInt() : Int {
        return scanner.nextInt()
    }

    /**
     * read int 과정에서 생길 수 있는 Exception을 방지하여 읽을 수 있는 함수입니다.
     * 숫자가 아닌경우 -1을 반환합니다.
     */
    fun readIntSafely() : Int {
        return runCatching {
            readInt()
        }.getOrElse { -1 }
    }
}