package com.testingacademy;

public class BuilderPattern {
    public BuilderPattern step1(){
        System.out.println("step1 is done");
        return this;
    }
    public BuilderPattern step2(String val){
        System.out.println("step2 is done");
        return this;
    }
    public BuilderPattern step3(){
        System.out.println("Step3 is done");
        return this;
    }

    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern();
        bp.step1().step2("jay").step3();
    }
}
