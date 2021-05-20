# Dual-color-Polyline-Animation
[![](https://jitpack.io/v/tintinscorpion/Dual-color-Polyline-Animation.svg)](https://jitpack.io/#tintinscorpion/Dual-color-Polyline-Animation)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Dual%20color%20Polyline-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7422)
[![BCH compliance](https://bettercodehub.com/edge/badge/tintinscorpion/Dual-color-Polyline-Animation?branch=master)](https://bettercodehub.com/)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
<br>
This library will help to show the polyline in dual color similar as Uber with animation in the demo. 
<br><br>

# Demo

<img src="https://github.com/tintinscorpion/Dual-color-Polyline-Animation/blob/master/polylinegif.gif" width="250" height="400"/>
<br><br>

## Steps:
Pass the googlemap context and Latlng points stored in arraylist.

``` java
   In Kotlin:

   MapAnimator.animateRoute(googleMap, polyLineList)

   In Java:

   MapAnimator.INSTANCE.animateRoute(googleMap, polyLineList);
```
<br>
polyLineList refers to the ArrayList<LatLng>, the coordinates which is to be decoded from the directions api of google.

 <br>
 Note:
   You can change the color and animation time and the width of the polyline by passing :

   ``` java 

   MapAnimator.setPrimaryLineColor(color)
   MapAnimator.setSecondaryLineColor(color) 
   MapAnimator.setPercentCompletion(@IntegerRes time: Int) default is 2500 //amount of time to draw the initial polyline 
   MapAnimator.setColorFillCompletion(@IntegerRes time: Int) default is 1800 //amount of time to refill the primary color
   MapAnimator.setDelayTime(@IntegerRes time: Int) default is 200 //amount of time for delaying to run the sequenceof animation
   MapAnimator.setPrimaryLineCompletion(@IntegerRes time: Int) default is 2000 //amount of time required for the animation to reach from point A to B
   MapAnimator.setPolylineWidth(width: Float) default is 8f 

   ```
   <br>
   If you are calling these methods, call it before animateRoute() method call else it won't reflect.
   <br>
   #Note:
   If you are using proguard then, write this in proguard-rules.pro 
   
   ``` java
   For android studio 4.0 and above- 
   -keepclassmembers class com.logicbeanzs.uberpolylineanimation.* {
     <fields>;
     <init>();
     <methods>;
   }
  
   below 4.0-
   -keep class com.logicbeanzs.uberpolylineanimation.**
  ```

## Dependency

```groovy
App Level:
implementation 'com.github.tintinscorpion:Dual-color-Polyline-Animation:{latest_version}'
```
```groovy
Project Level:
maven { url 'https://jitpack.io' }
```
 <br><br>

# Developers

<a href="https://github.com/tintinscorpion">Pritam Dasgupta</a>
  
## License
 
MIT License
Copyright (c) 2018 Pritam Dasgupta

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

