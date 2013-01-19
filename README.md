SelfOrgMap
==========

This is a little program I made to see how a self organizing map works. It uses colors as data points because they are easy to work with. Each color consists of three components: Red, Green, and Blue. These components are easily reduced to integer values.

Simply run Driver class, and it will initialize the screen consisting of a board of Pixels. Each pixel consists of a random color. To begin the "learning" process of the self organizing map, simply click on the screen and a thread will introduce a random pixel to the board. Call this pixel A.

The program then finds the pixel on the board with the closest color in RGB values to pixel A. All pixels within a specified radius of this chosen pixel will "learn" (so to speak). This process then repeats for an arbitrarily large number of iterations.

The learning process follows a simple equation:

n(t - a)

where:

    n = learning rate constant
    t = input color value
    a = pixel color value

This calculation occurs once for each pixel's RGB values. (Three times total)

It is interesting to note:

- The learning rate must be decremented gradually for the self-organizing map (SOM) to settle down.
- The larger the learning rate, the more drastic the change in the pixel's RGB value, and therefore the more volatile the map becomes when performing each iteration of introducing a new pixel to the map.
- Iterating through the map to find the pixel with the closest euclidean distance to the introduced pixel can be an expensive operation as the map gets larger.
