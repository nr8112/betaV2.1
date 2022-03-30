package com.example.betav2;

import java.util.Arrays;

public class User {
   private String UserName;
   private int Gender;
   private weighing[] weigh;
   private int height;
   private int ExerciseLevel;
   private String Location ;
   private int age;

   public User(String userName, int gender, weighing weigh, int height, int exerciseLevel, String location, int age) {
      this.UserName = userName;
      this.Gender = gender;
      this.height = height;
      this.ExerciseLevel = exerciseLevel;
      this.Location = location;
      this.age = age;
     this.weigh = new weighing[0];

   }



   @Override
   public String toString() {
      return "User{" +
              "UserName='" + UserName + '\'' +
              ", Gender=" + Gender +
              ", weigh=" + Arrays.toString(weigh) +
              ", height=" + height +
              ", ExerciseLevel=" + ExerciseLevel +
              ", Location='" + Location + '\'' +
              ", age=" + age +
              '}';
   }
}

