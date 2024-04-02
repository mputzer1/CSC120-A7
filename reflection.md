Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

I decided to overload the constructor in the House class. First, I created a constructor for the House class where the hasDiningRoom attribute is  true and the hasElevator attribute is false. I did this because most houses don't have elevators but do have dining rooms, so I determined it would be easier to create a preset constructor where the user doesn't have to repeatedly put these values in the parameters. Additionally, I created a second constructor where the user has to input no parameters, so that a house can quickly be created even if information about the house is unknown. It is once again assumed that the house has no elevator but does have a dining room. In the house class, I also overloaded the moveIn(param=number of people moving in) method so that mutliple people can move into a house at once. This makes it easier to move people in without having to call the original moveIn method several times for separate names.

Additionally, I decided to overload the Cafe class constructor. I created an alternate constructor where the user only has to input the name, address, and nFloors since people often don't know the nCoffeeOunces, nSugarPackets, nCreams, or nCups for a cafe. I also overloaded the sellCoffee method such that no parameters are inputted and it is assumed that a cup of coffee with 10 ounces, 1 sugar packet, and 1 cream is created.

Finally, I overloaded the Library class constructor. First, I created a constructor where the user does not have to state whether the library has an elevator since it is usually assumed that a library does have an elevator. I also created an alternate constructor where no parameters must be inputted so that a library can quickly be created even if information about the library is unknown. It is once again assumed that the library has an elevator. Like with the house class, I also overloaded the addTitle(param=number of titles to add) so that multiple titles can be added at once.

In terms of what worked, I found it easy to implement the house, library, and cafe class since all of these classes still worked from A6. In terms of what didn't work, I initially struggled to understand what it meant to overload a method. To help me better understand this concept, I consulted the sources listed below and reviewed the Building class. My advice to students of the future would be to revisit in-class examples and slides, since this was very helpful for me when overriding and overloading content.

I consulted the following sources since they provided basic method overloading tutorials:
https://www.shiksha.com/online-courses/articles/method-overloading-in-java/#:~:text=Method%20overloading%20in%20Java%20means,different%20data%20types%20of%20arguments.&text=For%20instance%3A,a)%20%7B%20...%20%7D

https://www.geeksforgeeks.org/constructor-overloading-java/
