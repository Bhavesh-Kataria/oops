package OOPS;

import java.util.Scanner;

class EmployeeAttendanceUC1{
     boolean checkAttendance(){
        int isPresent = (int) Math.round(Math.random());
         return isPresent == 1;
    }
}

class EmployeeWageUC2{
    int WORKING_HOURS = 8;
    int WAGE_PER_HOUR = 20;
    int calculateSalary(){
        EmployeeAttendanceUC1 emp = new EmployeeAttendanceUC1();
        if(emp.checkAttendance()){
            return WORKING_HOURS*WAGE_PER_HOUR;
        }else{
            return 0;
        }
    }
}

class EmployeeWageUC3{
    int WORKING_HOURS = 8;
    int WAGE_PER_HOUR = 20;
    int PART_TIME_HOURS = 4;
    int calculateSalary(){
        Scanner sc = new Scanner((System.in));
        EmployeeAttendanceUC1 emp = new EmployeeAttendanceUC1();
        if(emp.checkAttendance()) {
            System.out.printf("Are you working full time or part time today %n1.Full time%n2.Half time");
            int durationChecker = sc.nextInt();
            if (durationChecker == 1) {
                return WORKING_HOURS * WAGE_PER_HOUR;
            } else {
                return PART_TIME_HOURS * WAGE_PER_HOUR;
            }
        }
        return 0;
    }
}

class EmployeeWageUC4{
    int WORKING_HOURS = 8;
    int WAGE_PER_HOUR = 20;
    int PART_TIME_HOURS = 4;
    void calculateSalary(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Are you working full time or part time today %n1.Full time%n2.Half time%n3.Leave%n");
        int yourAttendance = sc.nextInt();
        switch (yourAttendance){
            case 1:
                System.out.println("daily wage is "+WORKING_HOURS*WAGE_PER_HOUR);
                break;
            case 2 :
                System.out.println("half day wage is "+PART_TIME_HOURS*WAGE_PER_HOUR);
                break;
            case 3 :
                System.out.println("since on leave wage is 0 Rs .");
                break;
        }
    }
}

class EmployeeWageUC5{
    int WORKING_DAYS = 20;
    void getMonthlyWages(){
        int numOfPresentDays=0;
        for(int i=1;i<=WORKING_DAYS;i++){
            int presentCheck = (int) Math.round(Math.random());
            if(presentCheck==1){
                numOfPresentDays ++;
            }
        }
        System.out.printf("Salary for %d present days in month is %d",numOfPresentDays,numOfPresentDays*20);
    }
}

class EmployeeWageUC6{
    int TARGET_WORKING_HOURS = 100;
    int TARGET_WORKING_DAYS = 20;
    void targetWageCalculate(){
        int dayCount =0;
        int hourCount =0;
        int flag =0;
        for(int i=1;i<=30;i++){
            if(hourCount==TARGET_WORKING_HOURS){
                break;
            }
            if(dayCount == TARGET_WORKING_DAYS){
                flag = 1;
                break;
            }
            int isPresentCheck = (int) Math.round(Math.random());
            if(isPresentCheck==1){
                int isHalfDayCheck = (int) Math.round(Math.random());
                if(isHalfDayCheck == 0){
                    hourCount += 4;
                }else{
                    dayCount +=1;
                    hourCount += 8;
                }
            }
        }
        System.out.printf("Employee was present for %d days and %d hours%n",dayCount,hourCount);
        if(flag == 0){
            System.out.println("wage for month was "+hourCount*20);
        }else{
            System.out.println("wage for montth was "+dayCount*8*20);
        }
    }


}

public class EmployeeWageProblem {
    public static void main(String[] args) {
        //usecase 1
        EmployeeAttendanceUC1 emp = new EmployeeAttendanceUC1();
        if(emp.checkAttendance()){
            System.out.println("Employee was present today");
        }else{
            System.out.println("Employee was absent today");
        }

        //usecase2
        EmployeeWageUC2 emp2 = new EmployeeWageUC2();
        int dailyWage = emp2.calculateSalary();
        if(dailyWage > 0){
            System.out.println("Since employee was present today his daily wage was "+dailyWage+" Rs.");
        }else {
            System.out.println("Since employee was absent today his daily wage was 0 Rs.");
        }

        //usecase3
        EmployeeWageUC3 emp3 = new EmployeeWageUC3();
        int dailyWageUC3 = emp3.calculateSalary();
        if(dailyWageUC3 > 0){
            System.out.println("daily wage was "+dailyWageUC3+" Rs.");
        }else {
            System.out.println("Since employee was absent today his daily wage was 0 Rs.");
        }

        //usecase4
        EmployeeWageUC4 emp4 = new EmployeeWageUC4();
        emp4.calculateSalary();

        //usecase5
        EmployeeWageUC5 emp5 = new EmployeeWageUC5();
        emp5.getMonthlyWages();

        //usecase6
        EmployeeWageUC6 emp6 = new EmployeeWageUC6();
        emp6.targetWageCalculate();
    }
}
