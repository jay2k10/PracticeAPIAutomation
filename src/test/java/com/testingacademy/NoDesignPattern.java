package com.testingacademy;

public class NoDesignPattern {
    public void step1(){
        System.out.println("Step1");
    }
    public void step2(){
        System.out.println("Step2");
    }
    public void step3(String jay){
        System.out.println("Step3");

    }

    public static void main(String[] args) {
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Manan");
    }
}
