package OOPS;

import java.util.Scanner;

class CompanyEmpWage{
    String companyName;
    int workingDays;
    float wage;
    CompanyEmpWage(String companyName, int workingDays, float wage){
        this.companyName = companyName;
        this.workingDays = workingDays;
        this.wage = wage;
    }
    static void totalCompanyWage(CompanyEmpWage[] emp){
        float qkWages=0;
        float bzaWages=0;
        float wiproWages=0;
        for(CompanyEmpWage e : emp){
            switch(e.companyName){
                case "QK" : qkWages += e.wage;
                            break;
                case "BZA" : bzaWages += e.wage;
                             break;
                case "WIPRO" : wiproWages += e.wage;
                               break;
            }
        }
        System.out.println("QK company expenditure "+qkWages);
        System.out.println("BZA company expenditure "+bzaWages);
        System.out.println("WIPRO company expenditure "+wiproWages);

    }

}

class Employee{
    String companyName;
    boolean isPresent;
    static int workingHoursPerDay;
    int workingDays;
    float wage;
    boolean isFullTime;

    Employee(boolean isPresent,float wage,boolean isFullTime){
        this.isPresent = isPresent;
        this.wage = wage;
        this.isFullTime = isFullTime;
    }

    Employee(String companyName , float wage , int workingDays , boolean isFullTime){
        this.companyName = companyName;
        this.wage = wage;
        this.workingDays = workingDays;
        this.isFullTime = isFullTime;
    }

    void setWorkingHoursPerDay(){
        if(companyName.equals("qk")){
            workingHoursPerDay = 8;
        }else{
            workingHoursPerDay = 6;
        }
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
    static float calculateWageCompanyWise(Employee obj , int days){
        return (days*obj.wage)/ obj.workingDays;
    }
}

public class EmployeeWageProblem {
    public static void main(String[] args) {
        //usecase 1
//        if(EmpWageUseCases.empAttendance()){
//            System.out.println("Employee was present today");
//        }else{
//            System.out.println("Employee was absent today");
//        }

        //usecase2
//        float dailyWage = EmpWageUseCases.calcuateSalary(8,20.0f);
//        if(dailyWage > 0){
//            System.out.println("Since employee was present today his daily wage was "+dailyWage+" Rs.");
//        }else {
//            System.out.println("Since employee was absent today his daily wage was 0 Rs.");
//        }

        //usecase3
//        Employee qk1 = new Employee(true,20,false);
//        float partTimeSal = EmpWageUseCases.calculateSalary(qk1);
//        System.out.println("Salary of Part time employee is Rs. "+partTimeSal);

        //usecase4
//        System.out.println("Enter\n1 if Employee is FullTime\n2 if Employee is Part Time");
        Scanner sc = new Scanner(System.in);
//        int choice = sc.nextInt();
//        EmpWageUseCases.calculateSalarySwitchCase(choice);

        //usecase5
//        boolean isFullTime = false;
//        System.out.println("Enter no. of days you were present in last month");
//        int presentDays = sc.nextInt();
//        System.out.println("Enter 1 if you are full time and 2 if u are part time");
//        int fullTimeInput = sc.nextInt();
//        if(fullTimeInput == 1){
//            isFullTime = true;
//        }
//        Employee qk2 = new Employee(true,20,isFullTime);
//        EmpWageUseCases.calculateMonthlyWage(qk2,presentDays);

        //usecase6
//        System.out.println("Enter true if you are full time");
//        isFullTime = sc.nextBoolean();
//        System.out.println("Enter number of days you have been present in this month till now");
//        int conditionPresentDays = sc.nextInt();
//        Employee qk3 = new Employee(true,20,isFullTime);
//        EmpWageUseCases.calculateWageConditionally(qk3,conditionPresentDays);

        //usecase7
        //already implemented code in required format

        //usecase8
//        Employee qk4 = new Employee("QK",15000,22,true);
//        Employee qk5 = new Employee("BZA",12000,24,true);
//        System.out.println("Enter number of days you have been present this month");
//        int days = sc.nextInt();
//        qk4.setWorkingHoursPerDay();
//        float sal = EmpWageUseCases.calculateWageCompanyWise(qk4,days);
//        System.out.println("Salary of QK Employee for working "+days+" days is Rs. "+sal);
//        qk5.setWorkingHoursPerDay();
//        sal = EmpWageUseCases.calculateWageCompanyWise(qk5,days);
//        System.out.println("Salary of BZA Employee for working "+days+" days is Rs. "+sal);

        //usecase9 and usecase10
        CompanyEmpWage emp1 = new CompanyEmpWage("QK",22,20000);
        CompanyEmpWage emp2 = new CompanyEmpWage("BZA",25,30000);
        CompanyEmpWage emp3 = new CompanyEmpWage("WIPRO",28,26000);
        CompanyEmpWage emp4 = new CompanyEmpWage("QK",22,20000);
        CompanyEmpWage[] emp = new CompanyEmpWage[4];
        emp[0]=emp1;
        emp[1]=emp2;
        emp[2]=emp3;
        emp[3]=emp4;
        CompanyEmpWage.totalCompanyWage(emp);
    }
}
