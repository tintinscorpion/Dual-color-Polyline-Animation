package com.logicbeanzs.uberpolylineanimation

import android.animation.*
import android.graphics.Color
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.annotation.ColorRes
import androidx.annotation.IntegerRes
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions

/**
 * dual-color-polyline-animation
 *
 * Created by Pritam Dasgupta on 20 May, 2021
 *
 */

object MapAnimator {
    private var backgroundPolyline: Polyline? = null
    private var foregroundPolyline: Polyline? = null
    private var optionsForeground: PolylineOptions? = null
    private var firstRunAnimSet: AnimatorSet? = null
    private var secondLoopRunAnimSet: AnimatorSet? = null
    private var GREY = Color.parseColor("#FFA7A6A6")
    private var BLACK = Color.BLACK
    private var PERCENT_COMPLETION = 2500
    private var COLOR_FILL_ANIMATION = 1800
    private var FOREGROUND_TIME = 2000
    private var DELAY_TIME = 200
    private var POLYLINE_WIDTH = 8f

    fun setPercentCompletion(@IntegerRes time: Int) {
        PERCENT_COMPLETION = time
    }

    fun setColorFillCompletion(@IntegerRes time: Int) {
        COLOR_FILL_ANIMATION = time
    }

    fun setPrimaryLineCompletion(@IntegerRes time: Int) {
        FOREGROUND_TIME = time
    }

    fun setDelayTime(@IntegerRes time: Int) {
        DELAY_TIME = time
    }

    fun setPrimaryLineColor(@ColorRes color: Int) {
        BLACK = color
    }

    fun setSecondaryLineColor(@ColorRes color: Int) {
        GREY = color
    }

    fun setPolylineWidth(width: Float) {
        POLYLINE_WIDTH = width
    }

    fun animateRoute(googleMap: GoogleMap, bangaloreRoute: List<LatLng>) {
        firstRunAnimSet = if (firstRunAnimSet == null) {
            AnimatorSet()
        } else {
            firstRunAnimSet?.removeAllListeners()
            firstRunAnimSet?.end()
            firstRunAnimSet?.cancel()
            AnimatorSet()
        }
        secondLoopRunAnimSet = if (secondLoopRunAnimSet == null) {
            AnimatorSet()
        } else {
            secondLoopRunAnimSet?.removeAllListeners()
            secondLoopRunAnimSet?.end()
            secondLoopRunAnimSet?.cancel()
            AnimatorSet()
        }
        //Reset the polylines
        foregroundPolyline?.remove()
        backgroundPolyline?.remove()

        val optionsBackground = PolylineOptions().add(bangaloreRoute[0]).color(GREY).width(POLYLINE_WIDTH)
        backgroundPolyline = googleMap.addPolyline(optionsBackground)
        optionsForeground = PolylineOptions().add(bangaloreRoute[0]).color(Color.BLACK).width(POLYLINE_WIDTH).also {
            foregroundPolyline = googleMap.addPolyline(it)
        }
        val percentageCompletion = ValueAnimator.ofInt(0, 100)
        percentageCompletion.duration = PERCENT_COMPLETION.toLong()
        percentageCompletion.interpolator = DecelerateInterpolator()
        percentageCompletion.addUpdateListener { animation ->
            val foregroundPoints = backgroundPolyline?.points
            val percentageValue = animation.animatedValue as Int
            val pointCount = foregroundPoints?.size ?: 0
            val countTobeRemoved = (pointCount * (percentageValue / 100.0f)).toInt()
            val subListTobeRemoved = foregroundPoints?.subList(0, countTobeRemoved)
            subListTobeRemoved?.clear()
            foregroundPoints?.let {
                foregroundPolyline?.points = it
            }
        }
        percentageCompletion.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                foregroundPolyline?.color = GREY
                backgroundPolyline?.points?.let {
                    foregroundPolyline?.points = it
                }
            }
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), GREY, Color.BLACK)
        colorAnimation.interpolator = AccelerateInterpolator()
        colorAnimation.duration = COLOR_FILL_ANIMATION.toLong() // milliseconds
        colorAnimation.addUpdateListener { animator -> foregroundPolyline?.color = animator.animatedValue as Int }
        val foregroundRouteAnimator = ObjectAnimator
                .ofObject(this, "routeIncreaseForward", RouteEvaluator(), *bangaloreRoute.toTypedArray())
        foregroundRouteAnimator.interpolator = AccelerateDecelerateInterpolator()
        foregroundRouteAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                foregroundPolyline?.points?.let {
                    backgroundPolyline?.points = it
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        foregroundRouteAnimator.duration = FOREGROUND_TIME.toLong()
        //        foregroundRouteAnimator.start();
        firstRunAnimSet?.playSequentially(foregroundRouteAnimator,
                percentageCompletion)
        firstRunAnimSet?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                secondLoopRunAnimSet?.start()
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        secondLoopRunAnimSet?.playSequentially(colorAnimation,
                percentageCompletion)
        secondLoopRunAnimSet?.startDelay = DELAY_TIME.toLong()
        secondLoopRunAnimSet?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                secondLoopRunAnimSet?.start()
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        firstRunAnimSet?.start()
    }

    /**
     * This will be invoked by the ObjectAnimator multiple times. Mostly every 16ms.
     */
    fun setRouteIncreaseForward(endLatLng: LatLng) {
        val foregroundPoints = foregroundPolyline?.points
        foregroundPoints?.add(endLatLng)
        foregroundPoints?.let {
            foregroundPolyline?.points = it
        }
    }
}