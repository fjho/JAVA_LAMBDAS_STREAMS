package com.ust.formacion.functional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class CourseDetailed {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public CourseDetailed() {
    }

    public CourseDetailed(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String toString() {
        return name + " " + category + " " + reviewScore + " " + numberOfStudents;
    }  
}

public class Fp06CustomClass {
    public static void main(String[] args) {
        // Create a list of courses
        List<CourseDetailed> courses = List.of(new CourseDetailed("Java", "Programming", 95, 2000),
                                       new CourseDetailed("Python", "Programming", 90, 1800),
                                       new CourseDetailed("JavaScript", "Programming", 85, 2200),
                                       new CourseDetailed("C++", "Programming", 80, 1500),
                                       new CourseDetailed("Spring", "Framework", 72, 1500),
                                       new CourseDetailed("Ruby", "Programming", 75, 1300),
                                       new CourseDetailed("Kotlin", "Programming", 88, 1600),
                                       new CourseDetailed("React", "Framework", 89, 1900),
                                       new CourseDetailed("Azure", "Cloud", 84, 1400),
                                       new CourseDetailed("AWS", "Cloud", 98, 2100),
                                       new CourseDetailed("Docker", "DevOps", 87, 1400),
                                       new CourseDetailed("Kubernetes", "DevOps", 93, 1200));
        
        
        Predicate<CourseDetailed> predicateReviewScoreMoreThan90 = course -> course.getReviewScore() > 90;
        Predicate<CourseDetailed> predicateReviewScoreMoreThan70 = course -> course.getReviewScore() > 70;
        Predicate<CourseDetailed> predicateReviewScoreMoreThan100 = course -> course.getReviewScore() > 100;

        //AllMatch example
        System.out.println("All courses have a review score greater than 90: " + courses.stream().allMatch(predicateReviewScoreMoreThan90));
        System.out.println("All courses have a review score greater than 70: " + courses.stream().allMatch(predicateReviewScoreMoreThan70));
        System.out.println("All courses have a review score greater than 100: " + courses.stream().allMatch(predicateReviewScoreMoreThan100));
        System.out.println("--------1---------");

        //NoneMatch example
        System.out.println("No courses have a review score more than 90: " + courses.stream().noneMatch(predicateReviewScoreMoreThan90));
        System.out.println("No courses have a review score more than 70: " + courses.stream().noneMatch(predicateReviewScoreMoreThan70));
        System.out.println("--------2---------");

        //AnyMatch example
        System.out.println("Any course has a review score greater than 90: " + courses  .stream().anyMatch(predicateReviewScoreMoreThan90));
        System.out.println("Any course has a review score greater than 70: " + courses.stream().anyMatch(predicateReviewScoreMoreThan70));
        System.out.println("--------3---------");

        Comparator<CourseDetailed> comparingNumberOfStudentsIncr = Comparator.comparingInt(CourseDetailed::getNumberOfStudents);
        System.out.println(courses.stream().sorted(comparingNumberOfStudentsIncr).collect(Collectors.toList()));
        System.out.println("---------4--------");

        Comparator<CourseDetailed> comparingNumberOfStudentsDecr = Comparator.comparingInt(CourseDetailed::getNumberOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingNumberOfStudentsDecr).collect(Collectors.toList()));
        System.out.println("---------5--------");

        Comparator<CourseDetailed> comparingNumberOfStudentsAndNumberReviewsIncr =
                    Comparator.comparingInt(CourseDetailed::getNumberOfStudents)
                    .thenComparingInt(CourseDetailed::getReviewScore);
        System.out.println(courses.stream().sorted(comparingNumberOfStudentsAndNumberReviewsIncr).collect(Collectors.toList()));
        System.out.println("--------6---------");


        //[Kubernetes DevOps 93 1200, Ruby Programming 75 1300, Azure Cloud 84 1400, Docker DevOps 87 1400, Spring Framework 72 1500, 
        // C++ Programming 80 1500, Kotlin Programming 88 1600, Python Programming 90 1800, React Framework 89 1900, Java Programming 95 2000, 
        // AWS Cloud 91 2100, JavaScript Programming 85 2200]
        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .limit(5)
                            .collect(Collectors.toList()));
        System.out.println("--------7---------");

        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .skip(3)
                            .collect(Collectors.toList()));
        System.out.println("--------8---------");

        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .skip(3)
                            .limit(5)
                            .collect(Collectors.toList()));
        System.out.println("--------9---------");

        System.out.println(courses.stream()
                            .collect(Collectors.toList()));
        System.out.println("--------10---------");
        System.out.println(courses.stream()
                            .takeWhile(c->c.getReviewScore()>=75)
                            .collect(Collectors.toList()));
        System.out.println("--------11---------");
        System.out.println(courses.stream()
                            .dropWhile(c->c.getReviewScore()>=75)
                            .collect(Collectors.toList())); 
        System.out.println("--------12---------");

        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .collect(Collectors.toList()));
        System.out.println("--------13---------");
        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .takeWhile(c->c.getReviewScore()>=75)
                            .collect(Collectors.toList()));
        System.out.println("--------14---------");
        System.out.println(courses.stream()
                            .sorted(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .dropWhile(c->c.getReviewScore()>=75)
                            .collect(Collectors.toList())); 
        System.out.println("--------15---------");

        System.out.println(courses.stream()
                            .max(comparingNumberOfStudentsAndNumberReviewsIncr));
        System.out.println("--------16---------");

        System.out.println(courses.stream()
                            .min(comparingNumberOfStudentsAndNumberReviewsIncr));
        System.out.println("--------17---------");

    
        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan100)
                            .min(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .orElse(new CourseDetailed("No course found", "", 0, 0)));
        System.out.println("--------18---------");

        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan100)
                            .max(comparingNumberOfStudentsAndNumberReviewsIncr)
                            .orElse(new CourseDetailed("No course found", "", 0, 0)));
        System.out.println("--------19---------");

        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan70)
                            .collect(Collectors.toList()));
        System.out.println("--------20---------");

        System.out.println(courses.stream()
                            .findFirst()
                        .orElse(new CourseDetailed("No course found", "", 0, 0)));
        System.out.println("--------21---------");

        System.out.println(courses.stream()
                            .findAny()
                            .orElse(new CourseDetailed("No course found", "", 0, 0)));
        System.out.println("--------22---------");

        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan90)
                            .mapToInt(CourseDetailed::getNumberOfStudents)
                            .sum());
        System.out.println("--------23---------");

        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan90)
                            .mapToInt(CourseDetailed::getNumberOfStudents)
                            .average());
        System.out.println("--------24---------");

        System.out.println(courses.stream()
                            .filter(predicateReviewScoreMoreThan90)
                            .map(c->c.getName())
                            .count());
        System.out.println("--------25---------");

        //grouping courses by category
        System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(CourseDetailed::getCategory))
        );
        System.out.println("--------26---------");

        //grouping courses by category and counting number of courses in each category
        System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(CourseDetailed::getCategory, 
                Collectors.counting()))
        );
        System.out.println("--------27---------");

        //grouping courses by category and counting and getting the course with the highest review score in each category
        System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(CourseDetailed::getCategory, 
                Collectors.maxBy(Comparator.comparingInt(CourseDetailed::getReviewScore))))
        );
        System.out.println("--------28---------");

        //grouping courses by category and counting and getting the course with the highest review score in each category
        System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(CourseDetailed::getCategory, 
                Collectors.mapping(CourseDetailed::getName, Collectors.toList())))
        );
        System.out.println("--------29---------");
    }
}
