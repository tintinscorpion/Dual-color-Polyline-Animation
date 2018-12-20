# Dual-color-Polyline-Animation
[![](https://jitpack.io/v/tintinscorpion/CarMarker-Animation.svg)](https://jitpack.io/#tintinscorpion/CarMarker-Animation)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-OverwatchProgress-blue.svg?style=flat)](https://android-arsenal.com/details/1/7381)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
<br>
This library will help to show the polyline in dual color similar as Uber with animation in the demo. 
<br><br>

# Demo
<img src="https://github.com/tintinscorpion/Dual-color-Polyline-Animation/blob/master/polylinegif.gif"/>

<br><br>

## Steps:
<UL>
<LI>Pass the googlemap context and Latlng points stored in arraylist.
<pre>
<code>
<LI>MapAnimator.getInstance().animateRoute(googleMap, polyLineList);
</LI>
<br><br>
polyLineList refers to the ArrayList<LatLng>, the coordinates which is to be decoded from the directions api of google.
</code>
</pre>
</LI>
 <br><br>
 <LI>
  <ul>Note:
   <code>
   You can change the color of the default polyline by passing :
   <br><br>
   
   <LI>MapAnimator.getInstance().setPrimaryLineColor(color);</LI>
   <LI>MapAnimator.getInstance().setSecondaryLineColor(color);</LI>
   <br> <br>
   If you are changing the default colors, call it before animateRoute() method call.
   </code>
 </LI>


## Dependency
<pre>
<LI>App Level:
implementation 'com.github.tintinscorpion:Dual-color-Polyline-Animation:1.0'
</LI>
<br>
<LI>Project Level:
maven { url 'https://jitpack.io' }
</LI>
</pre>



# Developers
<UL>
<LI><a href="https://github.com/tintinscorpion">Pritam Dasgupta</a>
</UL>
 
 ## License
<code>
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
</code>
