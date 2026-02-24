#Important!
Before running the program, understand that since all of the classes are java classes, you will need the Java Development Kit (JDK) to compile the program. I also recommend putting all of the files of the repository into a single folder to avoid potential issues with files not being able to access each other. One more thing before I start describing the classes, try running the program on an IDE. Since I made these programs on Eclipse, all of the classes will have a package line on the first line. If you are not running this program on an IDE that does not require the package header, then remove that line from all of the classes that have it. Lastly, make sure you paste the folder into the src folder of your IDE, otherwise it will not run!

#--Class Descriptions--
##The Main Class:
###StudentManagementSystemMain.java
This program contains three objects that manage data about students, courses, and the enrollments in the system. It contains a bunch of callers ask the user to input information about the data fields of a specified object. These callers are navigated using a switch in the main method, where the user can enter an integer to select a menu. There is another switch in the generateReports() method, which calls the ReportGenerator class, which contains methods that the other menus in main() do not call. There is only two try-catch blocks that handle exceptions that are triggered by the user attempting to enter a non-number type in a call that is asking the user for a number.
##Non-Object Classes:
###TestClient.java
This class was used to test out various methods that were being designed as I was making this program. It is mainly where you will see  I was testing out the GenericList, GenericQueue, GenericStack, Pair, and ArrayListUtils classes and the methods within those classes. It does not have everything those classes have as some of the lines have been removed throughout debugging, but you can see exactly when I decide that the program looks good for now.
###ArrayListOperationsDemo.java
This class tests out various operations that the ArrayList and Arrays have to offer. I found it challenging to grasp how the Collections.sort method worked, since the comparator uses a lambda to figure out what it has to sort by. It is also important for me to understand that the Comparator, as it is comparing two objects, still needs to work with objects that implements Comparable, as compareTo is used to tell which element is greater than the other. It is also used to sort elements by natural order, which is crucial for when you have to call the binarySearch method.
###ArrayListVsArrayDemo.java
This class is a comparison for which data structure would be preferred, and which one produces better results. The Array in this case blows the ArrayList away as we are working with a set data size, though it still has its shortcoming for when you have to work with a data set that you do not know the size of.
###ArrayListUtils.java
This class mostly consists of generic methods that are useful for when you have to compare elements of ArrayLists with each other, get a filtered arrayList, swap elements of an ArrayList, reverse the elements of an ArrayList, and get basic stats about ArrayLists that work with numbers. There is a really useful method that prints any type of ArrayList over multiple lines (how many lines are there is based on how many elements are in the arrayList)
##Object Classes:
###GenericList.java
This class is basically a rename for the ArrayList, though it mostly serves as a showcase for the features of the ArrayList. It also shows that I know how to work with generics, which is why the class has "generic" in its name. This class is not useful for the main program.
###GenericQueue.java
Rather an unorthodox way of making a queue, though it once it touches on generics and how queues will work when we touch on it in the future. This class is not useful for the main program.
###GenericStack.java
Same case as GenericQueue, this time I am experimenting on how stacks work. I still find it odd that we are using an ArrayList to make a stack than an ordinary array. This class is not useful for the main program.
###Pair.java
Working with two generic types and separating the way how each type works. There are setters and getters for the class, as well as three overriden object methods that include equals() [compares with another pair's first and second values are the same as the caller's first and second values], toString() [prints the toString abbreviation of the two type separated by a space], and hashCode() [checks whether both types have values, and then returns the modulus of the two values together]. This class was not used in the mainp program.
###Student.java
This program mostly consists of getters and setters of its data fields, which contains info on the students full name, email, major, year, and their GPA. This class implements Comparable as it is comparing two student's last names, which was important when I was testing in the ArrayListOperationsDemo as my confusions were finally put to rest when I found it what it means for objects to be sorted by their natural order. HashCode is based on studentId, equals is also based on studentId, and toString() just returns to String abbreviated info of the data fields.
###StudentManager.java
More so serving as an ArrayList for Student.java but wrapped with more functionality as you can get ArrayLists over info on student majors, their honor roll status, and student years. It can also calculate the averageGPA of all the students or the average GPA of students in a certain major.
###Course.java
Mostly consisting of setters and getters for course details, which includes courseCodes, name of course, credits awarded to student, instructor of course, maximum enrollment for the class, and the prerequisites required for the class. A toString() method is used to for when the program has to print out info on the field details of the system.
###CourseManager.java
More so an ArrayList for Course.java, but again, wrapped with more functionality as you can get info on what courses are available to a student and which courses are being taught by the same instructor.
###Enrollment.java
Mostly consisting of getters and setters for its data fields, which contains info on the studentId, courseCode, and the semester for which they enrolled into the course with the specified ID. Grades are also evaluated with this class, which can be converted into grade points that can be shared with other classes such as StudentManager and CourseManager. Enrollment can also share which courses a student is taking with CourseManager, that way it can understand a student's ability to take other courses.
###EnrollmentManager.java
More so an ArrayList for Enrollment.java, but it contains more functionality that can be used to share info to other classes. It can obtain courses that the student has already taken, get info on how many students are taking a certain course, and also handles issues where a student might be enrolled twice to the same class in the same semester. Grades are also assigned to enrollments using this class, which in turn can be used to assign a GPA to a student through the courses that they have taken.
###ReportGenerator.java
Might as well be a class containing static methods, though it touches on the methods that the main menu could not access that could be useful in the main program.

