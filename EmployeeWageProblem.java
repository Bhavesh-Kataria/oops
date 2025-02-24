package OOPS;

import java.util.Scanner;

class Employee{
    boolean isPresent;
    float wage;
    boolean isFullTime;

    Employee(boolean isPresent,float wage,boolean isFullTime){
        this.isPresent = isPresent;
        this.wage = wage;
        this.isFullTime = isFullTime;
    }
}

class EmpWageUseCases{
    static boolean empAttendance(){
        int isPresent = (int)Math.round(Math.random());
        return isPresent == 1 ;
    }
    static float calcuateSalary(int workingHours , float wage){
        if(empAttendance()){
            return workingHours * wage;
        }
        return 0;
    }
    static  float calculateSalary(Employee obj){
        if(obj.isPresent){
            if(obj.isFullTime){
                return obj.wage * 8;
            }else{
                return obj.wage * 4;
            }
        }
        return 0;
    }
    static void calculateSalarySwitchCase(int choice){
        switch (choice){
                case 0:
                    System.out.println("daily wage is "+0);
                    break;
                case 1 :
                    System.out.println("full time day wage is "+8*20);
                    break;
                case 3 :
                    System.out.println("part time dail wage is "+4*20);
                    break;
            }
    }
    static void calculateMonthlyWage(Employee obj,int days){
        if(days<30){
            if(obj.isFullTime){
                System.out.println("Your monthly salary is "+obj.wage*8*days);
            }else{
                System.out.println("Your monthly salary is "+obj.wage*4*days);
            }
        }
        else{
            System.out.println("No of present days cannot be more than 30");
        }
    }
    static void calculateWageConditionally(Employee obj,int presentDays){
        int targetHours = 100;
        int targetDays = 20;
        if(obj.isFullTime){
            if (presentDays<targetDays && presentDays*8<targetHours){
                System.out.println("No condition met yet");
            }
            else{
                System.out.println("100 Hours target reached");
            }
        }else{
            if (presentDays<targetDays && presentDays*4<targetHours){
                System.out.println("No condition met yet");
            }
            else{
                System.out.println("20 Day Target reached");
            }
        }

    }
}

public class EmployeeWageProblem {
    public static void main(String[] args) {
        //usecase 1
        if(EmpWageUseCases.empAttendance()){
            System.out.println("Employee was present today");
        }else{
            System.out.println("Employee was absent today");
        }

        //usecase2
        float dailyWage = EmpWageUseCases.calcuateSalary(8,20.0f);
        if(dailyWage > 0){
            System.out.println("Since employee was present today his daily wage was "+dailyWage+" Rs.");
        }else {
            System.out.println("Since employee was absent today his daily wage was 0 Rs.");
        }

        //usecase3
        Employee qk1 = new Employee(true,20,false);
        float partTimeSal = EmpWageUseCases.calculateSalary(qk1);
        System.out.println("Salary of Part time employee is Rs. "+partTimeSal);

        //usecase4
        System.out.println("Enter\n1 if Employee is FullTime\n2 if Employee is Part Time");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        EmpWageUseCases.calculateSalarySwitchCase(choice);

        //usecase5
        boolean isFullTime = false;
        System.out.println("Enter no. of days you were present in last month");
        int presentDays = sc.nextInt();
        System.out.println("Enter 1 if you are full time and 2 if u are part time");
        int fullTimeInput = sc.nextInt();
        if(fullTimeInput == 1){
            isFullTime = true;
        }
        Employee qk2 = new Employee(true,20,isFullTime);
        EmpWageUseCases.calculateMonthlyWage(qk2,presentDays);

        //usecase6
        System.out.println("Enter true if you are full time");
        isFullTime = sc.nextBoolean();
        System.out.println("Enter number of days you have been present in this month till now");
        int conditionPresentDays = sc.nextInt();
        Employee qk3 = new Employee(true,20,isFullTime);
        EmpWageUseCases.calculateWageConditionally(qk3,conditionPresentDays);

        //usecase7
        //alrady implemented code in required format

        //usecase8

    }
}
