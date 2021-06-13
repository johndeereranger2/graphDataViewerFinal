package com.deerbrain.graphdataviewer.Utill

import android.util.DisplayMetrics
import android.util.Pair
import android.view.WindowManager


fun animatePieViewResolution(windowManager: WindowManager): Pair<Int, Int> {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    val pair: Pair<Int, Int>
    if (metrics.densityDpi == DisplayMetrics.DENSITY_LOW ||
        metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
    ) {
        pair = Pair(12, 25)
        return pair
    } else if (metrics.densityDpi == DisplayMetrics.DENSITY_HIGH) {
        pair = Pair(17, 35)
        return pair
    } else if (metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {
        pair = Pair(18, 25)
        return pair
    } else if (metrics.densityDpi == DisplayMetrics.DENSITY_XXHIGH || metrics.densityDpi == DisplayMetrics.DENSITY_440 || metrics.densityDpi == DisplayMetrics.DENSITY_420) {
        pair = Pair(28, 90)
        return pair
    } else if (metrics.densityDpi == DisplayMetrics.DENSITY_560) {
        pair = Pair(35, 125)
        return pair
    } else if (metrics.densityDpi == DisplayMetrics.DENSITY_XXXHIGH) {
        pair = Pair(40, 150)
        return pair
    }
    pair = Pair(12, 50)
    return pair
}

fun ScreenResolutionForResult(windowManager: WindowManager): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    when (metrics.densityDpi) {
        DisplayMetrics.DENSITY_LOW -> return 80
        DisplayMetrics.DENSITY_MEDIUM -> return 90
        DisplayMetrics.DENSITY_HIGH -> return 100
        DisplayMetrics.DENSITY_XHIGH -> return 140
        DisplayMetrics.DENSITY_260 -> return 110
        DisplayMetrics.DENSITY_280 -> return 120
        DisplayMetrics.DENSITY_XXHIGH -> return 160
        DisplayMetrics.DENSITY_420 -> return 180
        DisplayMetrics.DENSITY_560 -> return 200
        DisplayMetrics.DENSITY_XXXHIGH -> return 280
    }
    return 280
}