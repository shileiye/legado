package io.legado.app.utils

import android.util.Base64
import java.nio.charset.StandardCharsets

object EncoderUtils {

    fun escape(src: String): String {
        val tmp = StringBuilder()
        for (char in src) {
            val charCode = char.toInt()
            if (charCode in 48..57 || charCode in 65..90 || charCode in 97..122) {
                tmp.append(char)
                continue
            }

            val prefix = when {
                charCode < 16 -> "%0"
                charCode < 256 -> "%"
                else -> "%u"
            }
            tmp.append(prefix).append(charCode.toString(16))
        }
        return tmp.toString()
    }

    fun base64Decoder(str: String): String {
        val bytes = Base64.decode(str, Base64.DEFAULT)
        return try {
            String(bytes, StandardCharsets.UTF_8)
        } catch (e: Exception) {
            String(bytes)
        }
    }
}