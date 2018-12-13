# Dual-color-Polyline-Animation
[![](https://jitpack.io/v/tintinscorpion/CarMarker-Animation.svg)](https://jitpack.io/#tintinscorpion/CarMarker-Animation)
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
