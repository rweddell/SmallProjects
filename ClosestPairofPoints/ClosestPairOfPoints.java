/*
Rob Weddell
Clostest Pair of Points algorithm
2/12/2017

java version "1.8.0_161"
*/

import java.io.*;
import java.util.*;
import java.lang.Math;
import java.awt.Point;

class MergeSort {
   static void merge(Point[] list, int low, int middle, int high, String coord){
       Point[] helper = new Point[list.length];
       for (int i = low; i <= high; i++) {
           helper[i] = list[i];
       }
       int left = low;
       int right = middle+1;
       int current = low;
       if (coord.equals("x")) {
           while (left <= middle && right <= high) {
               if (helper[left].getX() <= helper[right].getX()) {
                   list[current] = helper[left];
                   left++;
               } else {
                   list[current] = helper[right];
                   right++;
               }
               current++;
           }
       } else {
           while (left <= middle && right <= high) {
               if (helper[left].getY() <= helper[right].getY()) {
                   list[current] = helper[left];
                   left++;
               } else {
                   list[current] = helper[right];
                   right++;
               }
               current++;
           }
       }
       int remaining = middle - left;
       for (int i = 0; i <= remaining; i++) {
           list[current+i] = helper[left+ i];
       }
   }
    static void sort(Point[] list, int l, int h, String coord) {
        if (l < h) {
            int m = (l + h) / 2;
            sort(list, l, m, coord);
            sort(list, m + 1, h, coord);
            merge(list, l, m, h, coord);
        }
    }
}

class PointsDistance{
    double distance;
    Point[] twoPoints = new Point[2];
	
    PointsDistance() {}
    String firstPoint (){return ("(" + twoPoints[0].getX() + ", " + twoPoints[0].getY() + ")");}
    String secondPoint(){ return ("(" + twoPoints[1].getX() + ", " + twoPoints[1].getY() + ")");}
    double getDistance(){return this.distance;}
    Point getPoint1(){return this.twoPoints[0];}
    Point getPoint2(){ return this.twoPoints[1];}
    public void setDistance(double newdistance) { this.distance = newdistance;}
    public void setPoint1(Point point1){this.twoPoints[0] = point1;}
    public void setPoint2(Point point2){ this.twoPoints[1] = point2;}
}

public class ClosestPairOfPoints {

    static PointsDistance bruteForce(Point[] xList){
            double minDistance;
            double newDistance;
            minDistance = Math.sqrt(Math.pow((xList[1].getX()-xList[0].getX()),2) + Math.pow((xList[1].getY()-xList[0].getY()),2));
            PointsDistance closePoints = new PointsDistance();
            closePoints.setDistance(minDistance);
            if (xList.length <= 2){
                closePoints.setDistance(minDistance);
                closePoints.setPoint1(xList[0]);
                closePoints.setPoint2(xList[1]);
            }
            for (int i = 1; i< xList.length; i++){
                for (int j = i+1; j< xList.length; j++){
                    if (xList[i] != xList[j]) {
                        newDistance = Math.sqrt(Math.pow((xList[j].getX() - xList[i].getX()), 2) + Math.pow((xList[j].getY() - xList[i].getY()), 2));
                        if (minDistance > newDistance) {
                            minDistance = newDistance;
                            closePoints.setDistance(newDistance);
                            closePoints.twoPoints[0] = xList[i];
                            closePoints.twoPoints[1] = xList[j];
                        }
                    }
                }
            }
            return closePoints;
        }

    static PointsDistance findClosest(Point[] xList, Point[] yList){
        PointsDistance thesePoints = new PointsDistance();

        //Step 1
        if (xList.length <= 3){
            thesePoints = bruteForce(xList);
        }
        else{
			//Step 2
            double lineD = xList[xList.length/2].getX(); //defines a midpoint of the array sorted by x
            double minDistance;

            //Step 3
            Point[] leftSide = Arrays.copyOfRange(xList, 0, (xList.length/2));
            Point[] rightSide = Arrays.copyOfRange(xList, (xList.length/2), xList.length);

            //Step 4
            PointsDistance leftPoints = findClosest(leftSide, yList);
            PointsDistance rightPoints = findClosest(rightSide, yList);

            //Step 5
            if(leftPoints.getDistance() < rightPoints.getDistance())
                thesePoints = leftPoints;
            else
                thesePoints = rightPoints;
            minDistance = thesePoints.getDistance();

			
            double posD = lineD + minDistance;      //creates a 2D column of minDistance to either side of lineD
            double negD = lineD - minDistance;

            //Step 6
            List<Point> tempArray = new ArrayList<Point>(); //creates a temporary arrayList because they are dynamic
            for (int i = 0; i < yList.length; i++){
                if ((posD >= yList[i].getX()) || negD <= yList[i].getX()){         //check to the minDistance of either side of lineD for points and add them to a smaller array
                    tempArray.add(yList[i]);
                }
            }
            Point[] smallY = tempArray.toArray(new Point[tempArray.size()]);       //creates array of points within the 2D column

            //Step 7
            double newDistance;
            for (int q = 0; q < smallY.length-1; q++){
                int p = 1;
                while (p < 8 && (p+q) < smallY.length){
                    newDistance = smallY[q].distance(smallY[p+q]);
					if (minDistance > newDistance){
                        minDistance = newDistance;
                        thesePoints.setDistance(minDistance);
                        thesePoints.setPoint1(smallY[q]);
                        thesePoints.setPoint2(smallY[p+q]);
                    }
                    p++;
                }
            }
        }
        //Step 8
        return thesePoints;
    }

    public static void main(String[]args) {
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else
            fileName = "notFound";
        System.out.println("Captured this fileName: " + fileName);

        Point[] pointList = new Point[10];
        PointsDistance finalPoints;
        if (fileName.equals("notFound")) {
            System.out.println("We didn't find a filename.");
            System.out.println("Creating random list of 10 points.");
            System.out.println(" ");
            int i = 0;
            Random randy = new Random();
            System.out.println("Here's the point list.");
            System.out.println(" ");
            while (i < 10) {
                Point newPoint = new Point(randy.nextInt(100) + 1, randy.nextInt(100) + 1);
                pointList[i] = newPoint;
                System.out.println(newPoint.toString());
                i++;
            }
        }
        else{
            String line = null;
            try {
                //System.out.println("Checking the filepath");
                File chosen = new File(fileName);
                //System.out.println("Opening the file");
                FileReader fire = new FileReader(chosen);
                BufferedReader counter = new BufferedReader(fire);
                String[] star;
                int numPoints = 0;
                try {
                    while ((line = counter.readLine()) != null){
                        numPoints++;
                    }
                    pointList = new Point[numPoints];
                    counter.close();

                    chosen = new File(fileName);
                    fire = new FileReader(chosen);
                    BufferedReader bure = new BufferedReader(fire);

                    int i = 0;
                    while ((line = bure.readLine()) != null) {
                        star = line.split(" ");
                        pointList[i] = new Point(Integer.parseInt(star[0]), Integer.parseInt(star[1]));
                        i++;
                    }
                    bure.close();
                    //System.out.println("End of loop");
                } catch (FileNotFoundException fne){
                    System.out.println(fne);
                }
            } catch (Exception exc){
                System.out.println("Something went wrong.");
                System.out.println(exc);
            }
        }
		MergeSort sortStruct = new MergeSort();

        //Step 0
        Point[] xList = pointList.clone();
        Point[] yList = pointList.clone();
		sortStruct.sort(xList, 0, xList.length-1, "x");
		sortStruct.sort(yList, 0, yList.length-1, "y");

        finalPoints = findClosest(xList, yList);

        System.out.println("The calculated minimum distance is: ");
        System.out.println(finalPoints.getDistance() + ":  " + finalPoints.firstPoint() + "<----->" + finalPoints.secondPoint());
		
        //PointsDistance cheat = bruteForce(pointList);
        //System.out.println("The bruteForced minimum distance is: ");
        //System.out.println(cheat.getDistance() + ":  " + cheat.firstPoint() + "<----->" + cheat.secondPoint());
    }
}