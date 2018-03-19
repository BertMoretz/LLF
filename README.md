# LLF
Lego Mindstorms Line Follower (with PID Controller)

## Description
The idea of the project was to make Line Follower using PID Controller for Lego Mindstorms. We are not allowed to use native Minstorms EV3 program, so I used leJOS framework (tiny Java Virtual Machine for Lego MS). 

## Process and Problems
After installing leJOS and configuring it I started to write Java code for line follower. During the work I faced 2 huge problems that recline me back for many hours. **The first one** -  how to recieve data of ColorSensor. It has many methods and bunch of them are very similar. So, I've spent a lot of time to test these methods and to choose the best one. **The second** - the way of reading color. If white line shifts left or right, then in both situations the value is positive (so, we do not know which side to turn). The solution is to add the second sensor so that, it could easily determine the needed side.

## PID coefficients 
My coefficients: <br />
**P - 300** <br />
**I - 0** <br />
**D - 0** <br />
So, as the result I received line follower with P controller. I received these values by pure testing and information of what doing each of the coefficients. 

## Explanations
If I reduce P coefficient, then the car won't always turn in right direction. It will not have enought time. If I increase P, then my car will twitch like insane. If I add integrator, then it will be twisted and then car will get out of the way. If I increase derivative, then it will also twitch like abnormal. <br />
<br />
This is why my coefficients are the best.

## Video Demonstration
[YouTube video demonstration](https://www.youtube.com/watch?v=JJTwU-ZfOEQ)
