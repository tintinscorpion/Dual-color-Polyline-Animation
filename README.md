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
MapAnimator.getInstance().animateRoute(googleMap, polyLineList);
```
<br>
polyLineList refers to the ArrayList<LatLng>, the coordinates which is to be decoded from the directions api of google.

 <br>
 Note:
   You can change the color of the default polyline by passing :

   ``` java
   MapAnimator.getInstance().setPrimaryLineColor(color);
   MapAnimator.getInstance().setSecondaryLineColor(color);
   ```
   <br>
   If you are changing the default colors, call it before animateRoute() method call.


## Dependency

```groovy
App Level:
implementation 'com.github.tintinscorpion:Dual-color-Polyline-Animation:1.0'
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

