Author: Abhishek Sen
Roll: 3
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Description table:
Variables:
1. int xyzMap[]-array states the map (+x,-x,+y,-y,+z,-z)
2. int direction[]-array states the direction in which the bee will move at any step, among the six directions any one direction is randomly chosen and that value is made 1 while others are 0
3. int xyzIniPos[]-array stores co-ordinates of the initial position of the bee
4. int xyzFinPos[]-array stores co-ordinates of the final position of the bee
5. double xMean-stores the mean distance over all the cases
6. double standardDeviation-stores the standard deviation
Functions:
1. void main()
2. double distance()- calculates and returns the distance between the initial position and final position co-ordinates using formulae: SquareRoot((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)
3. int random()- returns a random number between 0-5
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Logic used:
The movement of a bee in an infinite tessalating hexagon can be synonymous with movement in a 3-dimentional space.
Consider a cube with unit side. the cube has 6 sides to which the bee can move.

the array xyzMap[] represents:-
|`````|`````|`````|`````|`````|`````|
|0(+x)|1(-x)|2(+y)|3(-y)|4(+z)|5(-z)|
`````````````````````````````````````

A cube can be opened as follows:
      
         |`````|
         |4(+z)|
   |`````|`````|`````|`````| 
   |0(+x)|2(+y)|1(-x)|3(-y)|
   ``````|`````|````````````
         |5(-z)|
         ```````
Thus choosing a random number between 0-5 can be used to choose a random size for propagation.

start the algorithm for 4 steps 
->xyzIniPos[]=(0,0,0)
->xyzFinPos[]=(0,0,0)

step2->choose a random number-(say 4)
->xyzFinPos[]=(0,0,1)
step3->choose a random number-(say 1)
->xyzFinPos[]=(-1,0,1)
step4->choose a random number-(say 3)
->xyzFinPos[]=(-1,-1,1)
step5->choose a random number-(say 0)
->xyzFinPos[]=(0,-1,1)

after 4 steps the position of the bee is (0,-1,1)

the above logic can be used to calculate random final position of bee after any number of steps.

Let say it is being calculated for 16 steps.
Then the the position after 16th step will be calculated for a userdefined number of times and distance will be stored in array X[],
over which mean and standard deviation is being calculated.
------------------------------------------------------------------------------------------------------------------------------------



 




