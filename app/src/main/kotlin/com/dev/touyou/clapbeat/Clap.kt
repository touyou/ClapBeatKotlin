package com.dev.touyou.clapbeat

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool

/**
 * Created by touyou on 16/03/27.
 */
class Clap {
    // 音楽プレイヤー
    private var soundPool: SoundPool? = null
    // 読み込んだ音声のID
    private var soundId: Int? = null

    // Clapインスタンスを初期化
    fun Clap(context: Context) {
        soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        soundId = soundPool?.load(context, R.raw.clap, 1)
    }

    fun play() {
        soundPool?.play(soundId!!, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun repeatPlay(repeat: Int) {
        var count: Int = 0
        while(count < repeat) {
            play()
            count++
            try {
                Thread.sleep(500)
            } catch(e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}